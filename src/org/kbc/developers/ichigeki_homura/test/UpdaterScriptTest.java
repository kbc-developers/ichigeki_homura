package org.kbc.developers.ichigeki_homura.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kbc.developers.ichigeki_homura.util.BuildProp;
import org.kbc.developers.ichigeki_homura.util.Log;
import org.kbc.developers.ichigeki_homura.util.TextFile;
import org.kbc.developers.ichigeki_homura.util.UpdateScript;


public class UpdaterScriptTest implements Testable{
	private	static final String TAG="UpdaterScriptTest";

	TextFile mTextFile;
	BuildProp mBuildProp;
	public UpdaterScriptTest()
	{
		mTextFile =  new TextFile("Test/updater-script", TextFile.EUC_JP);
		mBuildProp = new BuildProp(mTextFile);
	}

/*getprop("ro.product.device") == "t0lte" || getprop("ro.build.product") == "t0lte"*/
	@Override
	public void test() {
		Log.d(TAG,"Start Test");

		UpdateScript us = new UpdateScript(mTextFile,mTextFile);

		Log.d(TAG,"-------------------");
		Log.d(TAG,us.toString());
		Log.d(TAG,"-------------------");
		Log.d(TAG,"End Test");
	}

}
