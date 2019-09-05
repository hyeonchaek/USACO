/*
ID: joannek1
LANG: JAVA
TASK: milk2
 */


import java.util.*;
import java.io.*;

public class milk2 {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	
	static class milking implements Comparable<milking>{
		
		int in;
		int out;
		
		public milking(int in, int out) {
			
			this.in = in;
			this.out = out;
			
		}

		@Override
		public int compareTo(milking that) {
			
			return this.in - that.in;
			
		}
		
	}
	
	static int N;
	static milking[] list;
	static int maxC;
	static int maxB;
	static int start;
	static int end;
	static int currI;
	static int currO;
	static int num;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("milk2.in"));
			out = new PrintWriter(new File("milk2.out"));
			
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
		
		list = new milking[N];
		for(int i = 0; i < N; i++) {
			
			String[] temp = in.nextLine().split(" ");
			
			list[i] = new milking(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			
		}
		Arrays.sort(list);
		
		start = list[0].in;
		end = list[0].out;
		maxC = end - start;
		maxB = 0;
		num = maxC;
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int i = 1; i < N; i++) {
			
			currI = list[i].in;
			currO = list[i].out;
			
			if(end < currI) {
				
				if(maxB < currI - end)
					maxB = currI - end;
				end = currO;
				start = currI;
				
			}else if(end < currO) {
				
				if(maxC < currO - start)
					maxC = currO - start;
				end = currO;
				
			}
			
			if(currO - currI > num)
				num = currO - currI;
			
		}
		
		if(num > maxC)
			maxC = num;
		
		result = maxC + " " + maxB + "\n";
		return result;
		
	}
	
	//Algorithm methods
	//private static int change(String s){
	//
	//}

}

