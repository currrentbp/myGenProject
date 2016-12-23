package com.bp.test;

/**
 * 
 * @author current_bp
 * @createTime 20160819
 *
 */
public class IntegerEqint {

	public static void main(String[] args) {
		IntegerEqint ie = new IntegerEqint();
		
		ie.isEqual();
	}
	
	public void isEqual(){
		Integer in = new Integer(1);
		Integer i2 = new Integer(1);
		
		if(1 == in){//isOK
//		if(in == i2.intValue()){//isOK
			System.out.println("======");
		}else{
			System.out.println("+++++++");
		}
	}
}
