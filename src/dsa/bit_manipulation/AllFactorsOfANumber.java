package dsa.bit_manipulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AllFactorsOfANumber {
    public static void print_divisors(int n) {
        // code here
        Set<Integer> factors = new HashSet<>();
        for(int i = 1;i*i<=n;i++){
            if(n%i==0){
                factors.add(i);
                factors.add(n/i);
            }
        }
        int []ans = new int[factors.size()];
        int index = 0;
        for(int i:factors){
            ans[index++]=i;
        }
        Arrays.sort(ans);
        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
