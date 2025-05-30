package dsa.bit_manipulation;

import java.util.HashSet;
import java.util.Set;

public class DistinictPrimeFactorProductArray {
    public static int distinctPrimeFactors(int[] nums) {
        int prime[] = new int[10000+1];
        findPrime(prime);
        Set<Integer> primeFactorizeSet = new HashSet<>();
        for(int i:nums){

            for(int j = 2;j*j<=i;j++){
                if(prime[j]==0 && i%j==0){
                    int temp = i;
                    while(temp%j==0){
                        temp /= j;
                    }
                    primeFactorizeSet.add(j);
                    if(temp*temp > i && prime[temp]==0)primeFactorizeSet.add(temp);
                }
            }
            if(prime[i]==0)primeFactorizeSet.add(i);
        }
        return primeFactorizeSet.size();

    }
    public static void findPrime(int p[]){
        p[0] = 1;
        p[1] = 1;
        int n = p.length;
        for(int i = 2;i*i<n;i++){
            if(p[i]==0){
                for(int j = 2*i;j<n;j+=i){
                    p[j] = 1;
                }
            }
        }
    }
}
