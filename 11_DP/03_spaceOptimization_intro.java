// Space optimization approach 
// Time complexity: O(n)
// Space complexity: O(1)

class Solution {
    public int fib(int n) {

        if(n == 0) return 0;  //if n is 0 return 0
        if(n == 1) return 1;  // If n is 1 return 1

        int prev2 = 0;   // prev2 stores fib(n-2)
        
        int prev = 1;   // prev stores fib(n-1)
        
        int curr = 0;   // curr stores current fib

        for(int i = 2; i <= n; i++) {
            
            curr = prev + prev2;  //calculate current fib
            
            prev2 = prev;    //update prev2
            
            prev = curr;   //update prev
        }
        
        return prev;   //return final answer
    }
}