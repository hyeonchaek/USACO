package _1_2;

/*
ID: joannek1
LANG: JAVA
TASK: transform
 */

import java.util.*;
import java.io.*;

public class transform {

	static Scanner in;
	static PrintWriter out;
	
	//input Variables
	static String[] list;
	static int N;
	static char[][] input;
	static char[][] output;
	
	public static void main(String[] args) {
		
		try {
			
			//initialize in & out
			in = new Scanner(new File("transform.in"));
			out = new PrintWriter(new File("transform.out"));
			
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
		input = new char[N][N];
		for(int i = 0; i < N; i++) {
			
			String temp = in.nextLine();
			for(int j = 0; j < N; j++) {
				
				input[i][j] = temp.charAt(j);
				
			}
			
		}
		output = new char[N][N];
		for(int i = 0; i < N; i++) {
				
			String temp = in.nextLine();
			for(int j = 0; j < N; j++) {
				
				output[i][j] = temp.charAt(j);
				
			}
			
		}
		
	}
	
	private static String solve() {
		
		//process and output
		String result = "";
		
		if(check(_90(input)))
			result += 1;
		else if(check(_180(input)))
			result += 2;
		else if(check(_270(input)))
			result += 3;
		else if(check(reflect(input)))
			result += 4;
		else if(check(reflect(_90(input))) || check(reflect(_180(input))) || check(reflect(_270(input))))
			result += 5;
		else if(check(input))
			result += 6;
		else
			result += 7;
		
		return result + "\n";
		
	}
	
	//Algorithm methods
	public static boolean check(char[][] in){
		
		for(int i = 0; i < in.length; i++) {
			
			for(int j = 0; j < in.length; j++) {
				
				if(in[i][j] != output[i][j])
					return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public static char[][] _90(char[][] in){
		
		char[][] res = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N; j++) {
				
				res[i][j] = in[N-j-1][i];
				
			}
			
		}
		
		return res;
		
	}
	
	private static char[][] _180(char[][] in){
		
		char[][] res = new char[N][N];
		
		res = _90(_90(in));
		
		return res;
		
	}
	
	private static char[][] _270(char[][] in){
		
		char[][] res = new char[N][N];
		
		res = _90(_180(in));
		
		return res;
		
	}
	
	private static char[][] reflect(char[][] in){
	
		char[][] res = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			
			for(int j = 0; j < N; j++) {
			
				res[i][j] = in[i][N-j-1];
			
			}
			
		}
			
		return res;
	
	}


}
