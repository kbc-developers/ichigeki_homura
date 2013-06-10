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


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONFIG_NAME="sc02e_without_oneseg";
	//----------------------------------------------------------
	//Build Prop
	//----------------------------------------------------------
	private static final Prop[] BUILD_PROP_DEL_PROP = {
		new Prop("ro.config.*"			,""),
	};
	private static final Prop[] BUILD_PROP_REPLACE_PROP = {
		new Prop("ro.product.model"		,"SC-02E") ,
		new Prop("ro.product.brand"		,"samsung"),
		new Prop("ro.product.name"		,"SC-02E"),
		new Prop("ro.product.device"	,"sc02e"),
		new Prop("ro.product"			,"sc02e"),
		new Prop("ro.build.description"	,"t0ltedcm-user 4.1.1 JRO03C SC02EOMALJF release-keys"),
		new Prop("ro.build.fingerprint"	,"samsung/SC-02E/SC-02E:4.1.1/JRO03C/SC02EOMALJF:user/release-keys"),
		new Prop("ro.factory.model"		,"SGH-N025"),
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
	private static final boolean IS_FRAME_WORK_DECODE=true;
	private static final String ARRAYS_XML_PATH="res/values/arrays.xml";
	private static final Prop[] ARRAYS_PROP = {
		new Prop("/resources/string-array[@name='config_statusBarIcons']/item","felica_lock"),
	};

	@Override
	protected void init_name()
	{
		this.name=CONFIG_NAME;
	}
	@Override
	protected void init_build_prop()
	{
		propArraytoArrayList(BUILD_PROP_DEL_PROP  , build_prop.del_prop);
		propArraytoArrayList(BUILD_PROP_REPLACE_PROP , build_prop.replace_prop);
		propArraytoArrayList(BUILD_PROP_ADD_PROP , build_prop.add_prop);
	}
	@Override
	protected void init_updater_prop()
	{
		propArraytoArrayList(UPDATER_ADD_PROP  , updater.add_prop);
	}

	@Override
	protected void init_framework()
	{
		framework.isDecode = IS_FRAME_WORK_DECODE;
		framework.arrays_xml_path = ARRAYS_XML_PATH;

		propArraytoArrayList(ARRAYS_PROP  , framework.add_items);
	}
}

