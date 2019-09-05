/*
ID: joannek1
LANG: JAVA
TASK: crypt1
 */

package _1_2;

import java.util.*;
import java.io.*;

public class crypt1 {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static String[] list;
	static int N;
	static String values;
	static String up;
	static int count;
	static int[] nums;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("crypt1.in"));
			out = new PrintWriter(new File("crypt1.out"));
			
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
		N = Integer.parseInt(in.nextLine());
		
		list = in.nextLine().split(" ");
		
		values = "";
		for(int i = 0; i < list.length; i++) {
			
			values += list[i];
						
		}
		
		nums = new int[N];
		for(int i = 0; i < list.length; i++) {
			
			nums[i] = Integer.parseInt(list[i]);
			
		}
		
		up = "";
		count = 0;
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int i = 0; i < N; i++) {
			
			if(nums[i] == 0)
				continue;
			
			up = "" + nums[i];
			
			for(int j = 0; j < N; j++) {
				
				up = "" + nums[i] + nums[j];
				
				for(int x = 0; x < N; x++) {
					
					up = "" + nums[i] + nums[j] + nums[x];
					
					for(int k = 0; k < N; k++) {
						
						if(nums[k] == 0)
							continue;
						
						int first = Integer.parseInt(up);
						first *= nums[k];
						
						if(checkLength(first)) {
							
							if(checkNum(first)) {
								
								for (int m = 0; m < N; m++) {
									
									int second = Integer.parseInt(up) * nums[m];
									if(checkLength(second)) {
										
										if(checkNum(second)) {
										
											if(checkNum(first + second * 10))
												count++;
											
										}
									
									}
								
								}
							
							}
						
						}
					
					}
				
				}
			
			}
			
		}
		
		result = count + "\n";
		return result;
		
	}
	
	//Algorithm methods
	private static boolean checkLength(int n){
	
		String temp = "" + n;
		return temp.length() == 3;
		
	}
	
	private static boolean checkNum(int n) {
		
		String temp = "" + n;
		for(int i = 0; i < temp.length(); i++) {
			
			String s = "" + temp.charAt(i);
			if(!values.contains(s))
				return false;
			
		}
		
		return true;
		
	}

}