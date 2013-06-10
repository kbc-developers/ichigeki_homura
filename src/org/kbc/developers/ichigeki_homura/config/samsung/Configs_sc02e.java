package org.kbc.developers.ichigeki_homura.config.samsung;

import java.util.ArrayList;

import org.kbc.developers.ichigeki_homura.config.Configs;
import org.kbc.developers.ichigeki_homura.util.Prop;
import org.kbc.developers.ichigeki_homura.util.PropMultiItem;
import org.kbc.developers.ichigeki_homura.util.UpdateScript;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;


@Root
public class Configs_sc02e extends Configs implements java.io.Serializable{


	//----------------------------------------------------------
	//Build Prop
	//----------------------------------------------------------
	private static final Prop[] BUILD_PROP_REPLACE_PROP = {
		new Prop("ro.product.model"		,"SC-02E") ,
		new Prop("ro.product.brand"		,"samsung"),
		new Prop("ro.product.name"		,"SC-02E"),
		new Prop("ro.product.device"	,"sc02e"),
		new Prop("ro.product"			,"sc02e"),
		new Prop("ro.build.description"	,"t0ltedcm-user 4.1.1 JRO03C SC02EOMALJF release-keys"),
		new Prop("ro.build.fingerprint"	,"samsung/SC-02E/SC-02E:4.1.1/JRO03C/SC02EOMALJF:user/release-keys"),
		new Prop("ro.factory.model"		,"SGH-N025"),
		new Prop("ro.config.*"			,""),
	};
	private static final Prop[] BUILD_PROP_ADD_PROP = {
		new Prop("ro.config.libemoji"	,"libemoji_docomo.so"),
	};

	//----------------------------------------------------------
	//Update Script
	//----------------------------------------------------------
	private static final Prop[] UPDATER_ADD_PROP = {
		new Prop(UpdateScript.BUILD_PRODUCT,"sc02e"),
		new Prop(UpdateScript.BUILD_PRODUCT,"SC-02E"),
		new Prop(UpdateScript.PRODUCT_DEVICE,"sc02e"),
		new Prop(UpdateScript.PRODUCT_DEVICE,"SC-02E"),
	};

	//----------------------------------------------------------
	//Framework
	//----------------------------------------------------------
	private static final String ARRAYS_XML_PATH="";
	private static final Prop[] ARRAYS_PROP = {
		new Prop("/resources/string-array[@name='config_statusBarIcons']/item","felica_lock"),
	};

	public Configs_sc02e()
	{
		super();
		name="sc02c";
		test="sc02c_test";
		//----------------------------------------------------------
		//File Copy
		//----------------------------------------------------------

		//----------------------------------------------------------
		//Build Prop
		//----------------------------------------------------------

		//----------------------------------------------------------
		//Update Script
		//----------------------------------------------------------
		for(int i=0;i<UPDATER_ADD_PROP.length;i++)
		{
			updater.add_prop.add(UPDATER_ADD_PROP[i]);
		}

		//----------------------------------------------------------
		//Framework
		//----------------------------------------------------------
		framework.isDecode = true;
		framework.arrays_xml_path = ARRAYS_XML_PATH;

		for(int i=0;i<UPDATER_ADD_PROP.length;i++)
		{
			framework.add_items.add(ARRAYS_PROP[i]);
		}

	}

	protected void init_build_prop()
	{
		for(int i=0;i<BUILD_PROP_REPLACE_PROP.length;i++)
		{
			build_prop.add_prop.add(BUILD_PROP_REPLACE_PROP[i]);
		}
		for(int i=0;i<BUILD_PROP_ADD_PROP.length;i++)
		{
			build_prop.add_prop.add(BUILD_PROP_ADD_PROP[i]);
		}
	}
	protected void init_updater_prop()
	{

	}
	protected void init_framework()
	{

	}
}

