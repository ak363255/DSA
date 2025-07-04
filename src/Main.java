import dsa.GFG_ProblemOfTheDay.MaxMinHeight;
import dsa.array.*;
import dsa.binary_search.*;
import dsa.bit_manipulation.*;
import dsa.recursion.ExpressionAndOperators;
import dsa.recursion.RatMaze;
import dsa.slidingwindow.LongestSubstringWithUniques;
import dsa.slidingwindow.NoOfNiceSubArray;
import dsa.stack_queue.*;
import dsa.string.LongestCommonPrefix;
import dsa.string.RomanToInt;
import dsa.string.SubStringWithAtMostKDistinctChar;
import lld.ride_sharing_app.RideSharingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static dsa.recursion.RatMaze.ans;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public final class Main {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int []a = new int[n];
        for(int i = 0;i<n;i++)a[i] = sc.nextInt();
        int k = sc.nextInt();
        int w = sc.nextInt();
        int ans = MaxMinHeight.maxMinHeight(a,k,w);
        out.write(ans+"");
        out.flush();
    }


    public final static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}