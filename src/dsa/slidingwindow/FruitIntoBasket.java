package dsa.slidingwindow;

import java.util.HashMap;

public class FruitIntoBasket {

    public int totalFruit(int[] fruits) {

        /*
         -------------------------------------
         */
        int i = 0,j = 0,ans = 0;
        HashMap<Integer,Integer> fruitFreq = new HashMap<>();
        while(i < fruits.length){
            fruitFreq.put(fruits[i], fruitFreq.getOrDefault(fruits[i],0)+1);
            while(fruitFreq.size() > 2){
                int count = fruitFreq.get(fruits[j])-1;
                if(count==0)fruitFreq.remove(fruits[j]);
                else fruitFreq.put(fruits[j],count);
                j++;
            }
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }
}
