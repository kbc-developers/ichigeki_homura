package org.kbc.developers.ichigeki_homura.test;

import org.kbc.developers.ichigeki_homura.config.Configs;
import org.kbc.developers.ichigeki_homura.config.ConfigsManager;
import org.kbc.developers.ichigeki_homura.util.BuildProp;
import org.kbc.developers.ichigeki_homura.util.Log;
import org.kbc.developers.ichigeki_homura.util.TextFile;


public class SerializeTest implements Testable{
	private	static final String TAG="SerializeTest";


	private	static final String TEST_CONF="Test/test_conf.xml";


	public SerializeTest()
	{

	}


	@Override
	public void run() {
		Log.d(TAG,"Start Test");
		ConfigsManager cm = new ConfigsManager(TEST_CONF);

		Configs ddp;
		try {
			ddp = cm.load();
		} catch (Exception e) {
			e.printStackTrace();

			Log.d(TAG,"not exist file");

			ddp = new Configs();
			ddp.name ="test";
			ddp.test ="test";
			try {
				Log.d(TAG,"save to file");
				cm.save(ddp);
			} catch (Exception e2) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		Log.d(TAG,"ddp.name:"+ddp.name);
		Log.d(TAG,"ddp.test:"+ddp.test);

		//TEST_CONF

		Log.d(TAG,"End Test");
	}

}
