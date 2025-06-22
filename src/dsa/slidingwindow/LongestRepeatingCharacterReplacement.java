package dsa.slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        s = s.toLowerCase();
        int []charFreq = new int[26];
        int i = 0,j = 0,ans = 0,maxFre = 0,maxFreIndex = 0;
        char []cArray = s.toCharArray();
        while( i < cArray.length){
            charFreq[cArray[i]-'a']++;
            maxFre = Math.max(maxFre,charFreq[cArray[i]-'a']);
            while((i-j+1) - maxFre > k){
                charFreq[cArray[j]-'a']--;
                j++;
            }
            ans = Math.max(ans,i-j+1);
            i++;
        }
        return ans;
    }
}
