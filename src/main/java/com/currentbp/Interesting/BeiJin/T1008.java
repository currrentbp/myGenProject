package com.currentbp.Interesting.BeiJin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author current_bp
 * @createTime 20160705
 *
 */
public class T1008 {

/*
Description
During his last sabbatical, professor M. A. Ya made a surprising discovery about the old 
Maya calendar. From an old knotted message, professor discovered that the Maya 
civilization used a 365 day long year, called Haab, which had 19 months. 
Each of the first 18 months was 20 days long, and the names of the months were pop, 
no, zip, zotz, tzec, xul, yoxkin, mol, chen, yax, zac, ceh, mac, kankin, muan, pax, koyab,
 cumhu. Instead of having names, the days of the months were denoted by numbers starting 
 from 0 to 19. The last month of Haab was called uayet and had 5 days denoted by numbers 
 0, 1, 2, 3, 4. The Maya believed that this month was unlucky, 
 the court of justice was not in session, the trade stopped, 
 people did not even sweep the floor. 

For religious purposes, the Maya used another calendar in which the year was called 
Tzolkin (holly year). The year was divided into thirteen periods, each 20 days long. 
Each day was denoted by a pair consisting of a number and the name of the day. 
They used 20 names: imix, ik, akbal, kan, chicchan, cimi, manik, lamat, muluk, ok, chuen,
 eb, ben, ix, mem, cib, caban, eznab, canac, ahau and 13 numbers; both in cycles. 

Notice that each day has an unambiguous description. For example, 
at the beginning of the year the days were described as follows: 

1 imix, 2 ik, 3 akbal, 4 kan, 5 chicchan, 6 cimi, 7 manik, 8 lamat, 9 muluk, 
10 ok, 11 chuen, 12 eb, 13 ben, 1 ix, 2 mem, 3 cib, 4 caban, 5 eznab, 6 canac, 
7 ahau, and again in the next period 8 imix, 9 ik, 10 akbal . . . 

Years (both Haab and Tzolkin) were denoted by numbers 0, 1, : : : , 
where the number 0 was the beginning of the world. Thus, the first day was: 

Haab: 0. pop 0 

Tzolkin: 1 imix 0 
Help professor M. A. Ya and write a program for him to convert the dates from the Haab
 calendar to the Tzolkin calendar. 
Input

The date in Haab is given in the following format: 
NumberOfTheDay. Month Year 

The first line of the input file contains the number of the input dates in the file. 
The next n lines contain n dates in the Haab calendar format, each in separate line.
 The year is smaller then 5000. 
Output

The date in Tzolkin should be in the following format: 
Number NameOfTheDay Year 

The first line of the output file contains the number of the output dates. 
In the next n lines, there are dates in the Tzolkin calendar format,
in the order corresponding to the input dates. 
Sample Input

3
10. zac 0
0. pop 0
10. zac 1995
Sample Output

3
3 chuen 0
1 imix 0
9 cimi 2801
Source

Central Europe 1995
 */
	
	
	
	
/*
本题的意思类似于中国古代的历法，天干地支对应现在的历法
 */
	
/*
pop, no, zip, zotz, tzec, xul, yoxkin, mol, chen, yax, zac, 
ceh, mac, kankin, muan, pax, koyab, cumhu : 18个月
这个类似于现代的历法，只不过前18个月是20天，第19月（uayet）是5天，
每个月开始从：0,1,2。。。
 */
/*
imix, ik, akbal, kan, chicchan, cimi, manik, lamat, muluk, ok, chuen, eb, ben, 
ix, mem, cib, caban, eznab, canac, ahau 
这个历法类似于天干地支
天干13，
地支20
 */	
/*
Haab: 0. pop 0 
	日. 月  年
Tzolkin: 1 imix 0 
		天干  地支   年
 */
	
	public int lineNum = 0;
	public Map<String,Integer> oldMonths = new HashMap<String,Integer>();
	public String[] twoDays = new String[]{"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk",
			"ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau" };
	public String[] months = new String[]{"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", 
			"yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu" };
	public List<String> raw = new ArrayList<String>();
	public List<Integer> allDays = new ArrayList<Integer>();
	public List<String> target = new ArrayList<String>();
	
	{
		for(int i=0;i<months.length;i++){
			oldMonths.put(months[i], i+1);
		}
	}
	
	
	
	public void init(){
		Scanner sc = new Scanner(System.in);
		
		lineNum = Integer.parseInt(sc.nextLine());
/*
3
10. zac 0
0. pop 0
10. zac 1995
*/
		for(int i=0;i<lineNum;i++){
			raw.add(sc.nextLine());
		}
	}
	
	public void calculationAllDays(){
		int day = 0;
		int month = 0;
		int year = 0;
		for(int i=0;i<lineNum;i++){
			String[] r = raw.get(i).split(" ");
			int length = r[0].length();
			day = Integer.parseInt(r[0].substring(0, length-1));
			month = oldMonths.get(r[1]);
			year = Integer.parseInt(r[2]);
//			System.out.println("day:"+day+" month:"+month+" year:"+year);
			allDays.add(year*365+(day+1) + (month-1)*20);
		}
		
		target.add(""+lineNum);
		for(int i=0;i< allDays.size();i++){
			int days = allDays.get(i);
			year = days/(13*20);
			month = (days % (13*20)) %13 ;
			day = (days % (13*20)) %20;
			
//			System.out.println("month:"+(month)+" day:"+twoDays[day-1]+" year:"+year);
			target.add(""+month+" "+twoDays[day-1]+" "+year);
		}
	}
	
	public void print(){
		for(int i=0;i<target.size();i++){
			System.out.println(target.get(i));
		}
	}
	
	public static void main(String[] args) {
		T1008 t = new T1008();
		t.init();
		t.calculationAllDays();
		t.print();
	}

}
