package dsa.array;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> triplet(int n, int a[]) {
          /*
            1 2 3 4 2 3 2

            -1, -1, 0 1 2
             i  j       k
             i     j k
                   i j  k
           */
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i != 0 && a[i-1] == a[i])continue;
            int j = i+1,k = n-1;
            while(j<n && j>=0 &&  k <n  && k >=0 && j<k){
                int value = a[i]+a[j]+a[k];
                if(value == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(a[i]);
                    temp.add(a[j]);
                    temp.add(a[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<n && a[j-1]==a[j])j++;
                    while(k>=0 && a[k+1]==a[k])k--;
                }else if(value > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return   ans;
    }
}
