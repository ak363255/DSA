package dsa.bit_manipulation;

public class SwapTwoNumberUsingBitManipulation {

    public static void swapTwoNumber(int a,int b){
        b = a^b;
        a = a^b; // a =b
        b = b^a;
        System.out.println("a is "+a+" b is "+b);
    }
}
