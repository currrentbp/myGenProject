package com.currentbp.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/***
 * 
 * @author current_bp
 * @creatTime 20161209
 *
 */
public class Preloader {

	private final FutureTask<ProductInfo> future = 
			new FutureTask<ProductInfo>(new Callable<ProductInfo>(){
				public ProductInfo call() throws Exception{
					return new ProductInfo(2);
				}
			});
	
	private final Thread thread = new Thread(future);
	
	public void start(){
		thread.start();
	}
	
	public ProductInfo get() throws Exception{
		return future.get();
	}
	
	public static void main(String[] args) throws Exception{
		Preloader pl = new Preloader();
		pl.start();
		ProductInfo pi = pl.get();
		System.out.println(pi);
		
		System.out.println(pi);
	}
}


class ProductInfo{
	private Integer i = 1;
	public ProductInfo(){
	}
	public ProductInfo(int i){
		this.i=i;
	}
	@Override
	public String toString() {
		return "ProductInfo [i=" + i + "]";
	}
	
	
	
}