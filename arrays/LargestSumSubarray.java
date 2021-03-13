public class LargestSumSubarray {
   //Kadanae's Algorithm
    public int maxSubArray(final List<Integer> list) {
        int maxSum = list.get(0);
        int curSum = list.get(0);
        
        if(list.size() == 1 && list.get(0) < 0)
            return list.get(0);
        
        for(int i=1; i<list.size(); i++){
            curSum = Math.max (curSum + list.get(i), list.get(i));
            
            if(curSum > maxSum)
                maxSum = curSum;
        }
        
        return maxSum;
    }
}
