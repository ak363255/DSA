package dsa.bit_manipulation;

import java.util.Arrays;

public class TwoNumberAppearingOddNoOfTimes {
    public int[] twoOddNum(int Arr[], int N) {
        // code here
        int xor = 0;
        for(int i:Arr){
            xor ^= i;
        }
        int mask = (xor)&(-xor);
        int group1 = 0,group2 = 0;
        for(int i:Arr){
            if((i&mask) != 0)group1 ^= i;
            else group2 ^= i;
        }
        int ans[] = new int[]{Math.max(group1,group2),Math.min(group2,group1)};
        return ans;
    }
}
