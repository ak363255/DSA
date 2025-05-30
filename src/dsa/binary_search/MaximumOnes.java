package dsa.binary_search;

import java.util.ArrayList;

public class MaximumOnes {
    public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int ans = -1,lb,size  =0;
        ArrayList<Integer> a = new ArrayList<>();;
        for(int i = 0;i<mat.size();i++){
            //  System.out.println("i "+i);
            a = mat.get(i);
            lb = lowerBound(a);
            if(lb != -1){
                if(((a.size()-1) -lb) +1 > size){
                    size = ((a.size()-1) -lb) +1;
                    ans = i;
                }
            }
        }
        return ans;
    }
    public static int lowerBound(ArrayList<Integer> a){
        int s =0,e = a.size()-1,mid,ans = -1;
        while(s <= e){
            mid = (e-s)/2+s;
            if(a.get(mid)==1){
                ans = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return ans;
    }
}
