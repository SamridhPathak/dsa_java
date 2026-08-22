// GFG - Find Nth root of M
// Difficulty: Medium
// Approach: Binary Search, Since x^n is increasing as x increases, I can use Binary Search. search space - start=0 & end=m. For every mid, calculate:mid^n & Then compare it with m. If mid^n == m return mid. If mid^n > m go left. If mid^n < m go right. If the loop finishes without finding an exact value: return -1.
// Time Complexity: O(log M)
// Space Complexity: O(1)

class Solution {
    public int nthRoot(int n, int m) {
        int start = 0;
        int end = m;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (Math.pow(mid,n) == m) {
                return mid;
            } else if (Math.pow(mid,n) > m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}