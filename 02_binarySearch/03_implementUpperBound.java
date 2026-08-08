// GFG - Upper Bound
// Difficulty: Easy
// Approach: Binary Search, maintain 'ans', if arr[mid] > target, then this is a potential answer, else search right. if target not found then return length of array.
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;
        
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            if (arr[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
