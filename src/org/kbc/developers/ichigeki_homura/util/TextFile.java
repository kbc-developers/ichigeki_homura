package org.kbc.developers.ichigeki_homura.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TextFile {
	//"EUC-JP"

	public static final String EUC_JP="EUC-JP";
	public static final String UTF_8="UTF-8";

	private String mPath;
	private String mEncoding;

	public TextFile(String path,String encoding)
	{
		mPath = path;
		mEncoding = encoding;
	}

	public String getText()
	{
		String ret = "";
		try {
			BufferedReader br = new BufferedReader(	new InputStreamReader(
										new FileInputStream(new File(mPath)),mEncoding));
			String line;
			while ( ( line = br.readLine()) != null ) {
				ret += line + "\n";
			}
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public void outputText(String val)
	{
		try {
			PrintWriter pw = 	new PrintWriter( new OutputStreamWriter(
										new FileOutputStream( new File(mPath) ) ,mEncoding ) );
			pw.print(val);
			pw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
