// LeetCode 1200 - Minimum Absolute Difference
// Difficulty: Easy
// Approach: Sort the array, find the minimum difference between adjacent elements, then collect all adjacent pairs having that difference.
// Time Complexity: O(n log n) due to sorting
// Space Complexity: O(n) for the result list

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= arr.length - 2; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        for (int i = 0; i <= arr.length - 2; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff == minDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i + 1]);
                ans.add(pair);
            }
        }
        return ans;
    }
}