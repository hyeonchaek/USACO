
/*
ID: joannek1
LANG: JAVA
TASK: ride
*/
package _1_2;

import java.util.*;
import java.io.*;

public class ride {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static String[] list;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("ride.in"));
			out = new PrintWriter(new File("ride.out"));
			
			init();
			
			//write out file
			out.println(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}

	}
	
	private static void init() {
		
		//get data
		//initialize input variables
		
		list = new String[2];
		
		list[0] = in.nextLine();
		list[1] = in.nextLine();
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		if(convert(list[0]) == convert(list[1]))
			result = "GO";
		else
			result = "STAY";
		
		return result;
		
	}
	
	//Algorithm methods
	private static int convert(String s){
		int prod = 1;
		for(int i = 0; i < s.length(); i++) {
				
			prod *= s.charAt(i) - 'A'+1;
				
		}
			
		prod %= 47;
		
		return prod;
		
	}

}
