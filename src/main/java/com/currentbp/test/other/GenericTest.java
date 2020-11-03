package com.currentbp.test.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于泛型的测试类
 * 
 * @author current_bp
 * @createTime 20161114
 *
 */
public class GenericTest {

	public static void main(String[] args) {
		GenericTest gt = new GenericTest();

		List<keyValue> keyValues = new ArrayList<keyValue>();

		keyValues.add(new keyValue("1234", "567890"));
		keyValues.add(new keyValue(new Integer(1), "1"));
		keyValues.add(new keyValue(new Long(2), "2"));

		for (keyValue kv : keyValues) {
			System.out.println("key:" + kv.getKey() + " value:" + kv.getValue() + " keytype:" + 
						gt.getObjectType(kv.getKey())+" valuetype:"+gt.getObjectType(kv.getValue()));
		}
	}

	public String getObjectType(Object o) {
		if(o instanceof String){
			return "String";
		}else if(o instanceof Integer){
			return "Integer";
		}else if(o instanceof Long){
			return "Long";
		}else if(o instanceof Float){
			return "Float";
		}else{
			return "Object";
		}
	}

}

class keyValue<K, V> {
	private K key;
	private V value;

	public keyValue(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return this.key;
	}

	public V getValue() {
		return this.value;
	}

}
