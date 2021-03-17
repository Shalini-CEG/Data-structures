public class Solution {
    // Best time to buy and sell stocks
    public int maxProfit(final List<Integer> A) {
        int max = 0;
        int minSoFar = Integer.MAX_VALUE;

        for(int i=0; i<A.size(); i++){
            minSoFar = Math.min(minSoFar, A.get(i));
            max = Math.max(max, A.get(i) - minSoFar);
        }
        
        return max;
    }
}
