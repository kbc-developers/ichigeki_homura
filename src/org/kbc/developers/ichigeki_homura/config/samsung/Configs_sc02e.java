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

	private static final Prop[] ADD_PROP = {
		new Prop(UpdateScript.BUILD_PRODUCT,"sc02e"),
		new Prop(UpdateScript.BUILD_PRODUCT,"SC-02E"),
		new Prop(UpdateScript.PRODUCT_DEVICE,"sc02e"),
		new Prop(UpdateScript.PRODUCT_DEVICE,"SC-02E"),
	};


	public Configs_sc02e()
	{
		super();
		name="sc02c";
		test="";

		for(int i=0;i<ADD_PROP.length;i++)
		{
			updater.add_prop.add(ADD_PROP[i]);
		}

	}


}

