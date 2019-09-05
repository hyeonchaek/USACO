/*
ID: joannek1
LANG: JAVA
TASK: friday
 */
package _1_2;

import java.util.*;
import java.io.*;

public class friday {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static int[] days;
	static int[] dates = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	static int date;
	static int N;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("friday.in"));
			out = new PrintWriter(new File("friday.out"));
			
			init();
			
			//write out file
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}

	}
	
	private static void init() {
		
		//get data
		//initialize input variables
		date = 0;
		N = Integer.parseInt(in.nextLine()) + 1900;
		days = new int[7];
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int i = 1900; i < N; i++) {
			
			for(int j = 1; j <= 12; j++) {
				
				days[(date+13)%7]++;
				
				if(j == 2) {
					
					if(check(i))
						date += 29;
					else
						date += 28;
					
				}else {
					
					date += dates[j];
					
				}
				
			}
			
		}

		result += days[6] + " ";
		for(int i = 0; i < 6; i++) {
			
			if(i == 5)
				result += days[i] + "\n";
			else
				result += days[i] + " ";
			
		}
		
		return result;
		
	}
	
	private static boolean ifLeap(int y) {
		
		return y % 4 == 0;
		
	}
	
	private static boolean isCentury(int y) {
		
		if(y % 100 == 0) {
			
			if(y % 400 == 0)
				return false;
			return true;
			
		}else {
			
			return false;
			
		}
		
	}
	
	private static boolean check(int y) {
		
		return y % 4 == 0 && (y % 400 == 0 || y % 100 != 0);
		
	}
	
	//Algorithm methods
	//private static int change(String s){
	//
	//}

}
