package dsa.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public static List<Integer> majorityElement(int[] v) {

        /*
           f > n/2
           n/2 + n/2  = n
           thre will be maximum of 1 majority element that occurs > n/2

           1 2 3 1 2 3 3 3 3 4 4 4
           1 1 1 1 1 1 2 3 4 3 2 1


           f1 = 0,no1 = MIN_VALUE
           f2 = 0,no2 = MIN_VALUE

            1 2 3 1 2 3 3 3 3 4 4 4
      f1    1 1 0 1 1 0 1 2 3 3 3 3
      f2    0 1 0 0 1 0 0 0 0 1 2 3
      no1   1 1 M 1 1 M 3 3 3 3 3 3
      no2   M 2 M M 2 M M M M 4 4 4
         */
        int f1 = 0,no1 = Integer.MIN_VALUE,f2 = 0,no2 = Integer.MIN_VALUE,n = v.length;
        for(int i= 0;i<n;i++){
            if(no1==Integer.MIN_VALUE && no2 != v[i]){
                no1 = v[i];
                f1 = 1;
            }else if(no2 == Integer.MIN_VALUE && no1 != v[i]){
                no2 = v[i];
                f2 = 1;
            }else if(no1 == v[i]){
                f1++;
            }else if(no2 == v[i]){
                f2++;
            }else{
                f1--;
                f2--;
                if(f1==0)no1 = Integer.MIN_VALUE;
                if(f2==0)no2 = Integer.MIN_VALUE;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        f1 = 0;
        f2 =0 ;
        for(int i:v){
            if(i==no1)f1++;
            else if(i==no2)f2++;
        }
        if(f1>n/3)ans.add(no1);
        if(f2 > n/3)ans.add(no2);
        return  ans;
    }

}
