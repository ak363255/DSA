package dsa.bit_manipulation;

public class MinBitFlips {

    public static int minBitFlips(int start, int goal) {
        int ans = 0;
        /*
             111
            1010
         */
        while(goal > 0 || start > 0){
            if((goal&(1)) != (start&(1)))ans++;
            if(goal > 0)goal = goal>>1;
            if(start > 0)start = start>>1;
        }
        return ans;
    }
}
