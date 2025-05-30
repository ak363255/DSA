package dsa.bit_manipulation;

public class SetRightmostUnsetBit {
    static int setBit(int n) {
        // code here
        int mask = 1;
        while(true){
            if((n&mask)==0)return n | mask;
            mask <<= 1;
        }
    }
}
