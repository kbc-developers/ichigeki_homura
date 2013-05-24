package org.kbc.developers.ichigeki_homura.test;

import org.kbc.developers.ichigeki_homura.util.BuildProp;
import org.kbc.developers.ichigeki_homura.util.Log;
import org.kbc.developers.ichigeki_homura.util.TextFile;


public class BuildPropTest implements Testable{
	private	static final String TAG="BuildPropTest";

	TextFile mTextFile;
	BuildProp mBuildProp;
	public BuildPropTest()
	{
		mTextFile =  new TextFile("Test/build.prop", TextFile.EUC_JP);
		mBuildProp = new BuildProp(mTextFile);
	}


	@Override
	public void run() {
		Log.d(TAG,"Start Test");

		Log.d(TAG,"API Level = "+ mBuildProp.getApiLevel());
		Log.d(TAG,"ProductDevice = "+ mBuildProp.getProductDevice());
		Log.d(TAG,"ProductName = "+ mBuildProp.getProductName());
		Log.d(TAG,"all props :\n"+ mBuildProp.toString());

		Log.d(TAG,"End Test");
	}

}
