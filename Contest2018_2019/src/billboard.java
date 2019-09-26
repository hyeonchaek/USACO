import java.util.*;
import java.io.*;

public class billboard {
	
	static Scanner in;
	static PrintWriter out;
	static boolean grid[][];
	static int x1, x2, y1, y2;
		
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("billboard.in"));
			out = new PrintWriter(new File("billboard.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}

	}
	
	private static void init() {
		
		grid = new boolean[2001][2001];
		x1 = 0;
		x2 = 0;
		y1 = 0;
		y2 = 0;
		
	}
	
	private static int solve() {
		
		int count = 0;
		
		for(int i = 0; i < 2; i++) {
			
			x1 = in.nextInt() + 1000;
			y1 = in.nextInt() + 1000;
			x2 = in.nextInt() + 1000;
			y2 = in.nextInt() + 1000;
			
			for(int j = x1; j < x2; j++) {
				
				for(int x = y1; x < y2; x++) {
					
					grid[j][x] = true;
					count++;
					
				}
				
			}
			
		}
		
		x1 = in.nextInt() + 1000;
		y1 = in.nextInt() + 1000;
		x2 = in.nextInt() + 1000;
		y2 = in.nextInt() + 1000;
		
		for(int i = x1; i < x2; i++) {
			
			for(int j = y1; j < y2; j++) {
				
				if(grid[i][j] == true)
					count--;
				
			}
			
		}
		
		return count;
		
	}

}
