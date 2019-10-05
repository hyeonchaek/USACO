import java.util.*;
import java.io.*;

public class shuffle {
	
	static Scanner in;
	static PrintWriter out;
	static int[] arr, place, b;
	static int N;
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("shuffle.in"));
			out = new PrintWriter(new File("shuffle.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}

	}
	
	private static void init() {
		
		N = in.nextInt();
		System.out.println(N);
		place = new int[N];
		for(int i = 0; i < N; i++) {
			
			place[i] = in.nextInt();
			System.out.print(place[i] + " ");
			
		}
		System.out.println();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			
			arr[i] = in.nextInt();
			System.out.print(arr[i] + " ");
			
		}
		System.out.println();
		
		b = new int[N];
		
	}
	
	private static String solve() {
		
		String ans = "";
	
		System.out.println("a");
		for(int i = 0; i < N; i++) {
				
			b[i] = arr[place[i]-1];
			for(int x = 0; x < b.length; x++) {
				System.out.println(b[x]);
			}
				
		}
		
		for(int i = 0; i < N; i++) {
			
			arr[i] = b[place[i]-1];
			for(int x = 0; x < arr.length; x++) {
				System.out.println(arr[x]);
			}
				
		}
		
		for(int i = 0; i < N; i++) {
			
			b[i] = arr[place[i]-1];
			for(int x = 0; x < b.length; x++) {
				System.out.println(b[x]);
			}
				
		}
		
		ans = b[0] + "";
		for(int i = 1; i < N; i++) {
			
			ans += "\n" + b[i];
			
		}
		
		return ans;
		
	}

}
