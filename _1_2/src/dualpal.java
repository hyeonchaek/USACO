
/*
ID: joannek1
LANG: JAVA
TASK: dualpal
 */

import java.util.*;
import java.io.*;

public class dualpal {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static String[] list;
	static int N;
	static int S;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("dualpal.in"));
			out = new PrintWriter(new File("dualpal.out"));
			
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
		N = in.nextInt();
		S = in.nextInt();
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		int count = 0;
		//i is starting number
		int i = S + 1;
		while(true) {
			
			//number so you can do baseConversion
			String number = "" + i;
			int c = 0;
			
			for(int j = 2; j <= 10; j++) {
				
				if(isPalindrome(baseConversion(number, 10, j)))
					c++;
				if(c > 1) {
					
					result += number + "\n";
					count++;
					break;
					
				}
				if(count == N) {
					
					return result;
					
				}
				
			}
			//go onto the next number
			i++;
			
		}
		
	}
	
	//Algorithm methods
	//private static int change(String s){
	//
	//}
	
	static String baseConversion(String number, int sBase, int dBase) {
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
    }
	
    static boolean isPalindrome(String s) {
        int idx = s.length() -1;
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(idx)) 
                return false;
            idx--;
        }
        return true;
    }

}
