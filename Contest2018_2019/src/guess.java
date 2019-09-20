import java.util.*;
import java.io.*;

public class guess {

	static Scanner in;
	static PrintWriter out;
	static int N;
	static ArrayList<String>[] arr;
	
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("guess.in"));
			out = new PrintWriter(new File("guess.out"));
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
		
		arr = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			
			arr[i] = new ArrayList<String>();
			
		}
		for(int i = 0; i < N; i++) {
			
			in.next();
			int x = in.nextInt();
			for(int j = 0; j < x; j++) {
				
				arr[i].add(in.next());
				
			}
			
		}
		
		//printing out arr
		for(int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	private static int solve() {
		
		int count = 0, max = 0;
		
		for(int i = 0; i < N; i++) {
			
			for(int j = i + 1; j < N; j++) {
				
				if(i == j)
					continue;
				count = 0;
				
				for(String s: arr[i]) {
					
					if(arr[j].contains(s))
						count++;
					
				}
				
				//printing count each time
				System.out.println(count);
			
				max = Math.max(max, count);
			
			}
			
		}
		
		return max + 1;
		
	}
	
}
