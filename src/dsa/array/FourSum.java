package dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int []a, int target) {
        Arrays.sort(a);
       List<List<Integer>> ans = new ArrayList<>();
       int n = a.length;
       for(int i = 0;i<n;i++){
           if(i != 0 && a[i-1]==a[i])continue;
           for(int j = i+1;j<n;j++){
               if(j != i+1 && a[j-1]==a[j])continue;
               int k = j+1,l = n-1;
               while(k<l){
                   int sum = a[i]+a[j]+a[k]+a[l];
                   if(sum > target){
                       l--;
                   }else if(sum < target){
                       k++;
                   }else{
                       ArrayList<Integer> temp = new ArrayList<>();
                       temp.add(a[i]);
                       temp.add(a[j]);
                       temp.add(a[k]);
                       temp.add(a[l]);
                       ans.add(temp);
                       k++;
                       l--;
                       while(k<n && a[k-1]==a[k])k++;
                       while(l>=0 && a[l+1]==a[l])l--;
                   }
               }

           }
       }
       return ans;
    }
}
