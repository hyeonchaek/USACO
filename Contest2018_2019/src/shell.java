import java.util.*;
import java.io.*;

public class shell {
	
	static Scanner in;
	static PrintWriter out;
	static int[] arr, a, b, c;
	static int N;
	
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("shell.in"));
			out = new PrintWriter(new File("shell.out"));
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
		
		arr = new int[3];
		
		a = new int[N];
		b = new int[N];
		c = new int[N];
		for(int i = 0; i < N; i++) {
			
			a[i] = in.nextInt()-1;
			b[i] = in.nextInt()-1;
			c[i] = in.nextInt()-1;
			
		}
		
	}
	
	private static int solve() {
		
		int max = 0;
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			
			arr[0] = 0;
			arr[1] = 0;
			arr[2] = 0;
			arr[i] = 1;
			
			for(int j = 0; j < N; j++) {
				
				int first = a[j];
				System.out.println(first);
				int second = b[j];
				int temp = arr[first];
				arr[first] = arr[second];
				arr[second] = temp;
				System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
				
				if(arr[c[j]] == 1)
					count++;
				
			}
			
			if(count > max)
				max = count;
			count = 0;
			
		}
		
		return max;
		
	}

}
