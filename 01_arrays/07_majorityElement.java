// LeetCode (169) - Majority Element 
// Difficulty: Easy 
// Approach: HashMap to store the frequency of each element and then check which element has frequency greater than n/2.
// Time Complexity: O(n) - We traverse the array once to fill the HashMap and then traverse the HashMap to find the majority element.
// Space Complexity: O(n) - In the worst case, all elements are different and we store them in the HashMap.

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {  //true
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {  //false
                map.put(nums[i], 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n/2) {
                return key;
            }
        }

        return 0;
    }
}