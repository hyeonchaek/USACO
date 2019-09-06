import java.util.*;
import java.io.*;

public class backforth {

	static Scanner in;
	static PrintWriter out;
	static int aOrig[], bOrig[], a[], b[], n = 10;
	
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("backforth.in"));
			out = new PrintWriter(new File("backforth.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}
	
	private static void init() throws FileNotFoundException {
		
		aOrig = new int[n];
		bOrig = new int[n];
		a = new int[n];
		b = new int[n];
		for(int i = 0; i < n; i++) {
			
			aOrig[i] = in.nextInt();
			a[i] = aOrig[i];
			
		}
		for(int i = 0; i < n; i++) {
			
			bOrig[i] = in.nextInt();
			b[i] = bOrig[i];
			
		}
		
	}
	
	private static int solve() {
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < n; i++) {
			
			for(int j = 0; j < n; j++) {
				
				//Tue, Wed
				int milk = 0 - a[i] + b[j];
				int temp = a[i];
				a[i] = b[j];
				b[j] = temp;
				
				//Thur, Fri
				for(int k = 0; k < n; k++) {
					
					for(int l = 0; l < n; l++) {
						
						int result = milk - a[k] + b[l];
						set.add(result);
						
					}
					
				}
				
				//reset
				a = aOrig.clone();
				b = bOrig.clone();
				
			}
			
		}
		
		return set.size();
		
	}
	
}
