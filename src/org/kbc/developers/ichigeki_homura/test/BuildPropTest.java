package org.kbc.developers.ichigeki_homura.test;

import org.kbc.developers.ichigeki_homura.util.Log;
import org.kbc.developers.ichigeki_homura.util.TextFile;


public class BuildPropTest implements Testable{
	private	static final String TAG="BuildPropTest";

	TextFile mTextFile;

	public BuildPropTest()
	{
		mTextFile =  new TextFile("Test/build.prop", TextFile.EUC_JP);
	}

	@Override
	public void run() {
		Log.d(TAG,"Start Test");



		Log.d(TAG,"End Test");
	}

}
