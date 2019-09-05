/*
ID: joannek1
LANG: JAVA
TASK: barn1
 */



import java.util.*;
import java.io.*;

public class barn1 {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static String[] list;
	static int M;
	static int S;
	static int C;
	static int[] stalls;
	static int[] empty;
	static int covered;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("barn1.in"));
			out = new PrintWriter(new File("barn1.out"));
			
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
		M = Integer.parseInt(temp[0]);
		S = Integer.parseInt(temp[1]);
		C = Integer.parseInt(temp[2]);
		
		stalls = new int[C];
		for(int i = 0; i < C; i++) {
			
			stalls[i] = Integer.parseInt(in.nextLine());
			
		}
		Arrays.sort(stalls);
		
		empty = new int[C-1];
		covered = stalls[stalls.length-1] - stalls[0]+1;
		
		if(M > C - 1)
			M = C;
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		for(int i = 0; i < stalls.length-1; i++) {
			
			empty[i] = stalls[i+1] - stalls[i] - 1;
			
		}
		Arrays.sort(empty);
		
		for(int i = 0; i < M-1; i++) {
			
			covered -= empty[empty.length-1-i];
			System.out.println(covered);
			
		}
		
		result = covered + "\n";
		return result;
		
	}
	
	//Algorithm methods
	//private static int change(String s){
	//
	//}

}
