import java.util.*;
import java.io.*;

public class sleepy {
	
	static Scanner in;
	static PrintWriter out;
	static int arr[], N;
	
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("sleepy.in"));
			out = new PrintWriter(new File("sleepy.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	private static void init() {
		
		N = in.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			
			arr[i] = in.nextInt();
			
		}
		
	}
	
	private static int solve() {
		
		int i = 0;
		
		for(i = N-1; i > 0; i--) {
			
			if(arr[i] > arr[i-1])
				continue;
			else
				return i;
			
		}
		
		return 0;
		
	}

}
