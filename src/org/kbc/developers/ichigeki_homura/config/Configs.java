package org.kbc.developers.ichigeki_homura.config;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root
public class Configs implements java.io.Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -3019800764906699358L;

	@Element
	public String name;
	@Element
	public String test;

	public Configs()
	{
		name="";
		test="";
	}
}

