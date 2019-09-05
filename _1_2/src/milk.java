/*
ID: joannek1
LANG: JAVA
TASK: milk
 */

package _1_2;

import java.util.*;
import java.io.*;

public class milk {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	
	
	static class farmer implements Comparable<farmer>{
		
		int price;
		int amount;
		
		public farmer(int price, int amount) {
			
			this.price = price;
			this.amount = amount;
			
		}

		@Override
		public int compareTo(farmer that) {
			// TODO Auto-generated method stub
			
			return this.price - that.price;
			
		}
		
	}
	
	static int N;
	static int M;
	static farmer[] list;
	static int money;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("milk.in"));
			out = new PrintWriter(new File("milk.out"));
			
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
		String[] temp = in.nextLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		
		list = new farmer[M];
		for(int i = 0; i < M; i++) {
			
			String[] temp1 = in.nextLine().split(" ");
			list[i] = new farmer(Integer.parseInt(temp1[0]), Integer.parseInt(temp1[1]));
			
		}
		Arrays.sort(list);
		
		money = 0;
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int i = 0; i < M; i++) {
			
			if(N > list[i].amount) {
				
				N -= list[i].amount;
				money += list[i].price * list[i].amount;
				
			}else {
				
				money += N * list[i].price;
				N -= N;
				
			}
			
		}
		
		result = money + "\n";
		return result;
		
	}
	
	//Algorithm methods
	//private static int change(String s){
	//
	//}

}
