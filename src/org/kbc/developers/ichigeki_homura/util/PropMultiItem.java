package org.kbc.developers.ichigeki_homura.util;

import java.util.ArrayList;

public class PropMultiItem extends Prop{
	protected ArrayList<String> item;

	public PropMultiItem(String key, String val) {
		super(key,val);
		this.item = new ArrayList<String>();
		this.item.add(val);
	}
	public PropMultiItem(String key) {
		super(key,"");
		this.item = new ArrayList<String>();
	}
	/**
	 * @return val
	 */
	public String getVal(int i) {
		return this.item.get(i);
	}
	/**
	 * @return val
	 */
	public int size() {
		return this.item.size();
	}
	/**
	 * @param val セットする val
	 */
	public void setVal(String val) {
		super.setVal(val);
		this.item.set(0, val);
	}
	public void setVal(int i,String val) {
		if(i==0)
		{
			super.setVal(val);
		}
		this.item.set(i, val);
	}
	public void addVal(String val) {
		//super.setVal(val);
		this.item.add(val);
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.key +"="+this.item.get(0);
	}


}

