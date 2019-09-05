
/*
ID: joannek1
LANG: JAVA
TASK: palsquare
 */

import java.util.*;
import java.io.*;

public class palsquare {

    static int N;
    static Scanner in;
    static PrintWriter out;

    public static void main(String[] args) {
        try {
            in = new Scanner(new File("palsquare.in"));
            out= new PrintWriter(new File("palsquare.out"));

            init();
            out.print(solve());

            in.close();
            out.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    static void init() {
        N = in.nextInt();
    }

    static String solve() {
        String result = "";

        for(int i = 1; i <= 300; i++) {
            String q = "" + i;
            String n = baseConversion(q, 10, N).toUpperCase();
            String s = "" + (i * i);

            String square = baseConversion(s, 10, N).toUpperCase();

            if(isPalindrome(square)) {
                result += n + " " + square + "\n";
            }
        }

        return result;

    }

    static String baseConversion(String number, int sBase, int dBase) {
        return Integer.toString(Integer.parseInt(number, sBase), dBase);
    }

    static boolean isPalindrome(String s) {
        int idx = s.length() -1;
        for(int i = 0; i < s.length() /2; i++) {
            if(s.charAt(i) != s.charAt(idx)) 
                return false;
            idx--;
        }
        return true;
    }


}