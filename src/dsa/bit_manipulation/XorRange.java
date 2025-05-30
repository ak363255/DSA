package dsa.bit_manipulation;

public class XorRange {

    public static  int findRangeXOR(int l, int r) {
        //your code goes here
        int prev = xorOneToN(Math.max(0,l-1));
        int next = xorOneToN(r);
        return next^prev;
    }
    public static int xorOneToN(int n){
        if(n%4==1)return 1;
        else if(n%4==2)return n+1;
        else if(n%4==3)return 0;
        return n;
    }

}
