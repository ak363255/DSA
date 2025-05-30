package dsa.array;

import java.util.HashMap;
import java.util.HashSet;

public class SubArrayWithXorK {

    public static int subarraysWithSumK(int[] a, int b) {

        /*
        target - k
          a b c d e f
          a
          a^b
          a^b^c
          a^b^c^d

          1 2 3 2
             1  2  3  2
      pxor   1  3
     reqxor  3  1
         */


        HashMap<Long, Integer> xor = new HashMap<>();
        long pxor = 0, reqXor;
        int count = 0;
        for (int i : a) {
            pxor ^= i;
            reqXor = pxor ^ b;
            if(reqXor == 0)count++;
            if (xor.containsKey(reqXor)) {
                count += xor.get(reqXor);
            }
            xor.put(pxor, xor.getOrDefault(pxor, 0) + 1);
        }
        return count;
    }
}
