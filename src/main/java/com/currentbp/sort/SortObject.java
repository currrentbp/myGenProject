package com.currentbp.sort;
/**
 * 排序的实体
 * @author current_bp
 * @createTime 20160630
 *
 */
public class SortObject implements Comparable<SortObject>{

	int key;
	String value;
	@Override
	public String toString() {
		return "SortObject [key=" + key + ", value=" + value + "]";
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public int compareTo(SortObject o) {
		
		return this.getKey()<o.getKey() ? -1 : this.getKey() == o.getKey() ? 0 : 1;
	}
	
	
}
