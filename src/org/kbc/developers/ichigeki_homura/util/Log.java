package org.kbc.developers.ichigeki_homura.util;

public class Log {
	public static int NONE=0;
	public static int ERROR=1;
	public static int WRAN=2;
	public static int INFO=3;
	public static int DEBUG=4;
	public static int VERBOSE=5;


	private static int m_loglevel = INFO;
	/**
	 * @return m_loglevel
	 */
	public static int getLoglevel() {
		return m_loglevel ;
	}
	/**
	 * @param m_loglevel セットする m_loglevel
	 */
	public static void setLoglevel(int loglevel) {
		m_loglevel = loglevel;
	}

	public static void print(int loglevel ,String tag,String log) {
     	if(m_loglevel >= loglevel)
     	{
     		System.out.println("["+tag+"] " + log);
     	}
	}

	public static void e(String tag,String log) {
		print(ERROR,tag,log);
	}
	public static void w(String tag,String log) {
		print(WRAN,tag,log);
	}

	public static void i(String tag,String log) {
		print(INFO,tag,log);
	}
	public static void d(String tag,String log) {
		print(DEBUG,tag,log);
	}
	public static void v(String tag,String log) {
		print(VERBOSE,tag,log);
	}
}
