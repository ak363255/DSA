package dsa.bit_manipulation;

public class CountSetbit {
    static int setBits(int n) {
        // code here
        int c = 0;
        while(n>0){
            c += n&1;
            n >>= 1;
        }
        return c;
    }
}
