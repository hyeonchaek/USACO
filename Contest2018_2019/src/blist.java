import java.util.*;
import java.io.*;

public class blist {
	
	static Scanner in;
	static PrintWriter out;
	static int n, s, e, b, time[];
	
	public static void main(String[] args) {
		
		try {
			
			init();
			solve();
			in.close();
			out.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	private static void init() throws IOException{
		
		in = new Scanner(new File("blist.in"));
		out = new PrintWriter(new File("blist.out"));
		n = in.nextInt();
		time = new int[1000];
		
	}
	
	private static void solve() throws FileNotFoundException {
		
		for(int i = 0; i < n; i++) {
			
			s = in.nextInt();
			e = in.nextInt();
			b = in.nextInt();
			
			for(int j = s; j < e; j++) {
				
				time[j] += b;
				
			}
			
		}
		
		Arrays.sort(time);
		out.println(time[1000]);
		
	}

}
