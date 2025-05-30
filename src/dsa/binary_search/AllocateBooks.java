package dsa.binary_search;

import java.util.ArrayList;

public class AllocateBooks {

    public static int findPages(ArrayList<Integer> a, int n, int m) {
        // Write your code here.
        /*
         29 29 29 49
         3
         */
        if(m > n)return -1;
        long s = 0,e = 0,mid;
        int ans = -1;
        boolean possible = false;
        for(int i: a){
            s = Math.max(i,s);
            e += i;
        }
        while(s <= e){
            mid = (e-s)/2 +s;
            possible = splitBook(a,mid,m);
            if(possible){
                ans = (int)mid;
                e = mid-1;
            }else{
                 s = mid+1;
            }
        }
        return ans;
    }

    private static boolean splitBook(ArrayList<Integer> a, long pages, int no) {
        int count = 1,pSum = 0;
        for(int i:a){
           if(pSum + i > pages){
               count++;
               pSum = i;
           }else{
               pSum += i;
           }
        }
        return count <= no;
    }
}
