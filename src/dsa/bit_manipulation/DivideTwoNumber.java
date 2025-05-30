package dsa.bit_manipulation;

public class DivideTwoNumber {

    public static int divide(int dnd, int div) {
        long dividend = dnd,divisor = div;
        boolean isNegative = false;
        if((dividend <0 && divisor >0) || (dividend > 0 && divisor <0)){
            isNegative = true;
        }
        dividend = Math.abs(1L*dividend);
        divisor = Math.abs(1L*divisor);
        long tdiv = divisor;

        long ans = 0,temp ;
        while(dividend >= divisor){
            temp = 1;
            while(dividend >= 2*divisor){
                temp *= 2;
                divisor *= 2;
            }
            dividend -= divisor;
            ans += temp;
            divisor = tdiv;
        }
        int intans;
        if(isNegative){
            intans = Integer.parseInt((-1*ans)+"");
        }else{
            intans =  -1*ans == Integer.MIN_VALUE ? Integer.MAX_VALUE: Integer.parseInt(ans+"");
        }
        return intans;
    }
}
