package com.currentbp.Interesting.BeiJin;

/**
 * 1、一瓶酒2元，两个空瓶换一瓶酒，四个瓶盖换一瓶酒。问，10元钱能喝到多少瓶酒？
 * @author current_bp
 * @createTime 20160721
 *
 */
public class TotalBeer {
	
	public int sumMoney = 10;
	public int beerNeedMoney = 2;
	public int topToBeer = 4;
	public int glassToBeer = 2;
	public int sumBeer = 0;
	
	public int sumBeer(){
		int initBeer = sumMoney / beerNeedMoney;
		int top = initBeer,glass = initBeer;
		
		sumBeer = calculationBeer(top,glass)+ initBeer;
		
		return sumBeer;
	}
	
	public int calculationBeer(int top, int glass) {
		int remainTop = top % topToBeer;
		int remainGlass = glass % glassToBeer;
		int beers = top / topToBeer + glass / glassToBeer;
		
		if((remainTop+beers) / topToBeer + (remainGlass+beers) / glassToBeer> 0){
			return beers + calculationBeer(remainTop+beers, remainGlass+beers);
		}else{
			return beers;
		}
		
	}



	public static void main(String[] args) {
		TotalBeer t = new TotalBeer();
		System.out.println(t.sumBeer());
	}

}
