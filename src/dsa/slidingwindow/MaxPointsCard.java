package dsa.slidingwindow;

public class MaxPointsCard {

    public int maxScore(int[] cardPoints, int k) {
        int []prefixSum = new int[cardPoints.length+1];
        int ans = 0;
        for(int i = 0;i<cardPoints.length;i++){
            prefixSum[i+1] = prefixSum[i] + cardPoints[i];
        }
        for(int i = 0;i<=k;i++){
            ans = Math.max(ans,prefixSum[i] + prefixSum[cardPoints.length] - prefixSum[cardPoints.length - (k-i)]);
        }
        return ans;
    }
}
