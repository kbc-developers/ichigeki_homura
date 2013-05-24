package org.kbc.developers.ichigeki_homura.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
getprop("ro.product.device") == "t0lte" || getprop("ro.build.product") == "t0lte"
*/

public class UpdateScript{
	public static final String TAG="UpdateScript";

	public static final String BUILD_PRODUCT="ro.build.product";
	public static final String PRODUCT_DEVICE="ro.product.device";

	private TextFile mSrcTextFile;
	private TextFile mDstTextFile;
	private PropMultiItem	mBuildProduct;
	private PropMultiItem	mProductDevice;

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
		String ret = getAssertDevice();

		ret +=mScript;
		return ret;
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
		mScript = text;

		mBuildProduct = getPropsAll(text,BUILD_PRODUCT);
		mProductDevice  = getPropsAll(text,PRODUCT_DEVICE);

		removeAssert();
		removeModemFlash();
		removeEfsFlash();
		replaceKernelPartition();
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

	public void addProductDevice(String val)
	{
		mProductDevice.addVal(val);
	}
	public void addBuildProduct(String val)
	{
		mBuildProduct.addVal(val);
	}
	private String getProp(PropMultiItem prop)
	{
		String val="";
///Todo
		for(int i=0; i < prop.size();i++)
		{
			if(i != 0)
			{
				val += "\n || ";
			}
			val+= "getprop(\""+prop.getKey()+"\") == \""+prop.getVal(i)+"\"";
		}

		return val;
	}

	public String getProductDevice()
	{
		return getProp(this.mProductDevice);
	}

	public String getBuildProduct()
	{
		return getProp(this.mBuildProduct);
	}

	private void removeModemFlash()
	{
		///todo
	}
	private void removeEfsFlash()
	{
		///todo
	}
	private void replaceKernelPartition()
	{
		///todo
	}

	private void removeAssert()
	{
        String regex = "assert\\(([^;]*[\\w\\s\"\\r\\n])*.*\\).*;";
        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(mScript);
        if (m.find()){
        	  //this.mScript = m.group();
        	  //Log.d(TAG,"assret "+  m.group());
        	  this.mScript = this.mScript.substring(m.end());
        }
	}

	private String getAssertDevice()
	{
		String productDevice = getProductDevice();
		String buildProduct = this.getBuildProduct();

		if("".equals(productDevice) || "".equals(buildProduct))
		{
			//ありえないパス
			return "";
		}
		String ret="assert( \n    ";
		ret += productDevice +"\n || " + buildProduct +" );\n";
		return ret;
	}

}

