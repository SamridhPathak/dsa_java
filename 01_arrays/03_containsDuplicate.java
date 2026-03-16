// LeetCode 217 - Contains Duplicate 
// Difficulty: Easy
// Approach: Use a HashSet to keep track of the numbers we have seen so far. If we encounter a number that is already in the set, we return true. If we finish iterating through the array without finding any duplicates, we return false.
// Time Complexity: O(n), where n is the length of the input array. We need to iterate through the array once, and each insertion and lookup operation in the HashSet takes O(1) time on average.
// Space Complexity: O(n), in the worst case, if all elements in the array are unique, we will store all n elements in the HashSet.

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}