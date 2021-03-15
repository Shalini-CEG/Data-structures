public class Solution {
  // Add One to Number
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = 0;
        int sum = 0;
        int carry = 1;
        
        while(i < A.size()-1 && A.get(i) == 0)
            A.remove(i);
            
        for(int j=A.size() - 1; j >= 0; j--){
            sum = A.get(j) + carry;
            carry = sum/10;
            
            A.set(j, sum%10);
            
            if(carry == 0)
                break; 
        }
        
        if(carry != 0)
            A.add(0, carry);
            
        return A;
    }
}
