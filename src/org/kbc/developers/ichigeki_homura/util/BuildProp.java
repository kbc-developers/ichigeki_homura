package org.kbc.developers.ichigeki_homura.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildProp{
	public static final String TAG="BuildProp";

	private TextFile mSrcTextFile;
	private TextFile mDstTextFile;
	private ArrayList<Prop>	mProps;

	public BuildProp(TextFile src)
	{
		this(src,src);
	}

	public BuildProp(TextFile src,TextFile dst)
	{
		mSrcTextFile = src;
		mDstTextFile = dst;

		getPropsFromFile();
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String val="";
		for(int i=0; i < mProps.size();i++)
		{
			val += mProps.get(i).toString() + "\n";
		}

		return val;
	}

	/**
	 *
	 */
	public void flush()
	{
		mDstTextFile.outputText(this.toString());
	}

	public String replace(String body,String regex,String after)
	{
	    Pattern p = Pattern.compile(regex);
	    Matcher m = p.matcher(body);
		return m.replaceAll(after);
	}

	private void getPropsFromFile()
	{
		String text = mSrcTextFile.getText();

		mProps = new ArrayList<Prop>();

		String[] lines = text.split("\n");

		for(int i=0;i<lines.length;i++)
		{
			String line = lines[i].trim();

			//Skip Comment line
			if(!line.trim().startsWith("#"))
			{
				String[] item = line.split("=");
				Prop p = new Prop(item[0],item[1]);
				mProps.add(p);
			}
		}
	}

	private String getProp(String key)
	{
		String val=null;
		for(int i=0; i < mProps.size();i++)
		{
			Prop p = mProps.get(i);
			if(key.equals(p.getKey()))
			{
				val =  p.getVal();
				break;
			}
		}

		return val;
	}

	public static final String API_LEVEL="ro.build.version.sdk";
	public static final String PRODUCT_NAME="ro.product.name";
	public static final String PRODUCT_DEVICE="ro.product.device";
	public int getApiLevel()
	{
		String val = getProp(API_LEVEL);
		int api = -1;
		try{
			api= Integer.parseInt(val);
		}
		catch(Exception e )
		{
			e.printStackTrace();
			Log.e(TAG,"error ro.build.version.sdk" + val);
		}
		return api;
	}
	public String getProductName()
	{
		String val = getProp(PRODUCT_NAME);

		if(val== null)
		{
			val = "";
		}
		return val;
	}

	public String getProductDevice()
	{
		String val = getProp(PRODUCT_DEVICE);

		if(val== null)
		{
			val = "";
		}
		return val;
	}

	public void replaceProp(String key,String val)
	{
		String prop = getProp(key);

		if(prop==null)
		{
			Prop p = new Prop(key,val);
			mProps.add(p);
		}
		else
		{
			for(int i=0; i < mProps.size();i++)
			{
				Prop p = mProps.get(i);
				if(key.equals(p.getKey()))
				{
					p.setVal(val);
					break;
				}
			}
		}
	}

}

