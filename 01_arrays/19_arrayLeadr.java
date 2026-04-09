// GFG - Array Leaders
// Difficulty: Easy
// Approach: We can traverse the array from the end and keep track of the maximum element seen so far. If the current element is greater than or equal to the maximum element, it is a leader and we add it to our result list. Finally, we reverse the result list to maintain the original order of leaders.
// Time Complexity: O(N) 
// Space Complexity: O(1)

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int maxSoFar = arr[arr.length - 1];
        ans.add(maxSoFar);
        
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxSoFar) {
                ans.add(arr[i]);
                maxSoFar = arr[i];
            } 
        }
        Collections.reverse(ans);
        return ans;
    }
}
