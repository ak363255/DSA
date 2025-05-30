package dsa.bit_manipulation;

public class MinBitFlipToConvertNumber {
    public static int minBitFlips(int start, int goal) {
        int ans = 0;
        while(start > 0 || goal > 0){
            ans += start > 0 && goal > 0 ? ((start&1)^(goal&1)): start > 0 ? start&1 : goal&1;
            start >>= 1;
            goal >>= 1;
        }
        return ans;
    }
}
