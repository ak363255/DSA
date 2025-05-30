package dsa.bit_manipulation;

public class CheckKthBitSetOrNot {

    public static boolean checkKthBit(int n, int k) {
        // Your code here
        int mask = 1<<k;
        if((n&mask) != 0)return true;
        return false;
    }
}
