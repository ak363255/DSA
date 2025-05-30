package dsa.bit_manipulation;

public class Divison {

    public static int divide(int dividend, int divisor) {
       boolean isNegative = false;
       if((dividend < 0 && divisor >= 0) || (divisor < 0 && dividend >= 0)){
           isNegative = true;
       }
       long dnd = Math.abs((long) dividend),div = Math.abs((long) divisor);
       long ans = 0;
       while(dnd >= div){
           int power = 1;
           while(div*(1L <<power) <= dnd){
               power++;
           }
           dnd -= (div*(1L<<(power-1)));
           ans += (1L<<(power-1));
       }
       if(isNegative)ans = -1*ans;
       return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE:Integer.parseInt(""+ans);
    }
}
