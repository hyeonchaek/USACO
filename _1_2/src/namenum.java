
/*
ID: joannek1
LANG: JAVA
TASK: namenum
 */

import java.util.*;
import java.io.*;

public class namenum {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static ArrayList<String> list;
	static String input;
	static Scanner inD;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("namenum.in"));
			out = new PrintWriter(new File("namenum.out"));
			
			init();
			
			//write out file
			out.print(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}

	}
	
	private static void init() throws FileNotFoundException {
		
		//get data
		//initialize input variables
		input = in.nextLine();
		inD = new Scanner(new File("dict.txt"));
		list = new ArrayList<String>();
		while(inD.hasNextLine()) {
			
			list.add(inD.nextLine());
			
		}
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int i = 0; i < list.size(); i++) {
			
			if(input.equals(convert(list.get(i))))
				result += list.get(i) + "\n";
			
		}
		
		if(result.length() == 0)
			result = "NONE" + "\n";
		
		return result;
		
	}
	
	//Algorithm methods
	private static String convert(String name){
	
		String res = "";
		
		for(int i = 0; i < name.length(); i++) {
			
			if(name.charAt(i) == 'A' || name.charAt(i) == 'B' || name.charAt(i) == 'C')
				res += 2;
			else if(name.charAt(i) == 'D' || name.charAt(i) == 'E' || name.charAt(i) == 'F')
				res += 3;
			else if(name.charAt(i) == 'G' || name.charAt(i) == 'H' || name.charAt(i) == 'I')
				res += 4;
			else if(name.charAt(i) == 'J' || name.charAt(i) == 'K' || name.charAt(i) == 'L')
				res += 5;
			else if(name.charAt(i) == 'M' || name.charAt(i) == 'N' || name.charAt(i) == 'O')
				res += 6;
			else if(name.charAt(i) == 'P' || name.charAt(i) == 'R' || name.charAt(i) == 'S')
				res += 7;
			else if(name.charAt(i) == 'T' || name.charAt(i) == 'U' || name.charAt(i) == 'V')
				res += 8;
			else if(name.charAt(i) == 'W' || name.charAt(i) == 'X' || name.charAt(i) == 'Y')
				res += 9;
			
		}
		
		return res;
		
	}

}
