package org.kbc.developers.ichigeki_homura.test;

import org.kbc.developers.ichigeki_homura.util.Log;



public class TestMain {

	private void run() {
		Log.setLoglevel(Log.DEBUG);
//		new BuildPropTest().run();

		new SerializeTest().test();

//		new UpdaterScriptTest().run();
	}

   public static void main(final String[] args) {
	   TestMain test = new TestMain();


    	String osName = System.getProperty("os.name");
        System.out.println(osName);

        test.run();
    }



}
