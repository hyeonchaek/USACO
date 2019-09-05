/*
ID: joannek1
LANG: JAVA
TASK: gift1
 */

import java.util.*;
import java.io.*;

public class gift1 {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static LinkedHashMap<String, Integer> list;
	static int NP;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("gift1.in"));
			out = new PrintWriter(new File("gift1.out"));
			
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
		NP = Integer.parseInt(in.nextLine());
		list = new LinkedHashMap<String, Integer>();
		
		for(int i = 0; i < NP; i++) {
			
			list.put(in.nextLine(), 0);
			
		}
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int j = 0; j < NP; j++) {
			
			String giver = in.nextLine();
			String[] temp = in.nextLine().split(" ");
			int amount = Integer.parseInt(temp[0]);
			int people = Integer.parseInt(temp[1]);
			
			if(people == 0) continue;
				
			int money = amount / people;
			int left = amount - (money * people);
			
			list.put(giver, list.get(giver)-amount+left);
				
			for(int i = 0; i < people; i++) {
					
				String name = in.nextLine();
				list.replace(name, list.get(name) + money);
					
			}
				
		}
		
		for(String s: list.keySet()) {
			
			result += s + " " + list.get(s) + "\n";
			
		}
		
		return result;
		
	}
	
	//Algorithm methods
	//private static int change(String s){
	//
	//}

}

