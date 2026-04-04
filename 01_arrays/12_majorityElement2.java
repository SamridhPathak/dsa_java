import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
// LeetCode (229) - Majority Element II
// Difficulty: Medium
// Approach: Hash Map
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) { //true
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {  //false
                map.put(nums[i], 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > n/3) {
                list.add(key);
            }
        }
        return list;
    }
}