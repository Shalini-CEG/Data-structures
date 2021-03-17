public class Stocks {
    // Best time to buy and sell stocks = II
    public int maxProfit(final List<Integer> A) {
        int profit = 0;
        
        for(int i=1; i<A.size(); i++){
            if(A.get(i) > A.get(i-1)){
                profit += (A.get(i) - A.get(i-1));
            }
        }
        
        return profit;
    }
}
