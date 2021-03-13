class MajorityElt
{
  //Boyer-Moore Algorithm
    static int majorityElement(int a[], int size)
    {
        int ansIndex = 0;
        int count = 1;
        int res = 0;
        
        for(int i=0; i<a.length; i++){
            if(a[i] == a[ansIndex])
                count++;
            else
                count--;
            if(count == 0){
                ansIndex = i;
                count = 1;
            }    
        }
        
        for(int i = 0; i<a.length; i++){
            if(a[i] == a[ansIndex])
                res += 1;
        }
        
        if(res > a.length/2)
            return a[ansIndex];
        else
            return -1;
    }
  
  //Solution 2
  
    public int majorityElement(final List<Integer> A) {
         int ans = A.get(0), count = 1;
    
    for(int i = 1; i < A.size(); i++){
        if(A.get(i) == ans){
            count++;
        }
        else{
           count--;
            if(count == 0){
                ans = A.get(i);
                count = 1;
            }
        }
    }
    
    return ans;
        
    }
}
