package org.kbc.developers.ichigeki_homura.util;

public class Prop{
	private String key;
	private String val;

	public Prop(String key, String val) {
		super();
		this.key = key;
		this.val = val;
	}

	/**
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key セットする key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return val
	 */
	public String getVal() {
		return val;
	}

	/**
	 * @param val セットする val
	 */
	public void setVal(String val) {
		this.val = val;
	}

	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.key +"="+this.val;
	}


}

