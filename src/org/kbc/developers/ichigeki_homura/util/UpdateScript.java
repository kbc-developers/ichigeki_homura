package org.kbc.developers.ichigeki_homura.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
getprop("ro.product.device") == "t0lte" || getprop("ro.build.product") == "t0lte"
*/

public class UpdateScript{
	public static final String TAG="UpdateScript";

	private TextFile mSrcTextFile;
	private TextFile mDstTextFile;
	private ArrayList<PropMultiItem>	mProps;

	private String mScript;

	public UpdateScript(TextFile src)
	{
		this(src,src);
	}

	public UpdateScript(TextFile src,TextFile dst)
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
		return mScript;
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
	public void addDevice(String device)
	{
		//Todo：
		// Prop ArrayListに追加
	}


	public static final String BUILD_PRODUCT="ro.build.product";
	public static final String PRODUCT_DEVICE="ro.product.device";


	private void getPropsFromFile()
	{
		String text = mSrcTextFile.getText();
		mScript = text;


		mProps = new ArrayList<PropMultiItem>();
		mProps.add( getPropsAll(text,BUILD_PRODUCT) );
		mProps.add( getPropsAll(text,PRODUCT_DEVICE) );


	}
	private PropMultiItem getPropsAll(String str,String key) {
        //getprop\("[^\s]*"\) == "[^\s]*"

        String regex = key+"\"\\)\\s*==\\s*\"[^\\s]*\"";
        Pattern p = Pattern.compile(regex);
        String regex2 = "\"[^\\s]*\"";
        Pattern p2 = Pattern.compile(regex2);

        PropMultiItem prop = new PropMultiItem(key);

        for(;;)
        {
	        Matcher m = p.matcher(str);
	        if (m.find()){
	          Matcher m2 = p2.matcher(m.group());
	          if (m2.find()){
	        	  String val = m2.group().replaceAll("\"", "");
	        	  Log.d(TAG,"detect "+ key+ ":"+val);
	        	  prop.addVal(val);
	          }
	          str = str.substring(m.end());
	        }
	        else
	        {
	        	break;
	        }
        }
        return prop;
	}

	private String getProp(String key)
	{
		String val=null;
///Todo
//		for(int i=0; i < mProps.size();i++)
//		{
//			Prop p = mProps.get(i);
//			if(key.equals(p.getKey()))
//			{
//				val =  p.getVal();
//				break;
//			}
//		}

		return val;
	}




	public String getBuild()
	{
		String val = getProp(BUILD_PRODUCT);

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



}

