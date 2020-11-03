package com.currentbp.test.other;

/**
 * 测试方法参数传入的是地址还是值
 * @author current_bp
 * @time 20160405
 *
 */
public class ValueOrAddress {
	
	private int x = 0;
	VA va1 = new VA();
	VA va2=new VA();
	public static void main(String[] args) {
		
		ValueOrAddress voa = new ValueOrAddress();
		
//		System.out.println(voa.getVa().hashCode());
//		
//		va.useVA(voa.getVa());
//		
//		System.out.println(voa.getVa().hashCode()+"==="+voa.getVa().getY());
		
		//2
		if(voa.getVa() == voa.useVA2(voa.getVa())){
			System.out.println("???");
		}else{
			System.out.println(false);
		}
//		if(voa.getVa()==voa.useVA2(voa.getVa2())){
//			System.out.println("???");
//		}else{
//			System.out.println("!!!");
//		}
		
	}
	
	
	public VA useVA2(VA va){
		va.setY(112);
		return va;
	}
	public VA useVA(VA va){
		System.out.println(va.hashCode());
		va.setY(33333);
		VA va1 = new VA();
		va1.setY(222);
		va = va1;
		return va;
	}
	
	
	public VA getVa(){
		return this.va1;
	}
	public VA getVa2(){
		return this.va2;
	}
	
	class VA {
		private int y = 0;
		
		public int getY(){
			return this.y;
		}
		public void setY(int y){
			this.y = y;
		}
	}
}
