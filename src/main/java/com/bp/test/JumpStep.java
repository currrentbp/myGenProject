package com.bp.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
/**
 * 台阶的各种走法。超过30 时就速度特别的慢。。。有打印语句 的更慢。。
  * @author current_bp
 * @time 20160405
 *
 */
public class JumpStep {
	public int sumStep = 25;
	public static int count = 0;
	
	public void jump(ArrayList<Integer> list){
		if(sumStep - sumList(list) <= 0)
		{
			count ++;
			list.remove(0);
			System.out.println(list);
			return;
		}
		for(int j =1;j<=2;j++)
		{
			if(sumStep - sumList(list) >= 2)
			{
				ArrayList al1 = null;
				al1 = (ArrayList)list.clone();//copyArrayList(list);//可以使用list:copy()。
				//表明使用list:clone()比自己写的克隆代码好得多。
				al1.add(j);
				jump(al1);
			}
			
			
		}
		if(sumStep - sumList(list) == 1)
		{
			ArrayList aL3 = null;
			aL3 = copyArrayList(list);
			aL3.add(1);
			jump(aL3);
			
		}
	}
	
	public ArrayList copyArrayList(ArrayList list)
	{
		ArrayList a = new ArrayList();
		for(int i=0;i<list.size();i++)
		{
			a.add(list.get(i));
		}
		return a;
	}
	
	public int sumList(ArrayList<Integer> list)
	{
		int sum = 0;
		for(int i=0;i<list.size();i++)
		{
			sum =sum + list.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		JumpStep js = new JumpStep();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(0);
		Date d1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		js.jump(al);
		Date d2 = new Date();
		System.out.println("count:"+js.count+" stime:"+sdf.format(d1)+" etime:"+sdf.format(d2));
	}

}
