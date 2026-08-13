// LeetCode (349) - Intersection of Two Arrays
// Difficulty: Easy
// Approach: store elements from nums1 in a HashSet and then iterate through nums2 and check for common elements. if found then add in the list and remove 
// from the set to avoid duplicates and attain uniqueness. then copy the list into result array.
// Time Complexity:   O(n + m). Traverse first array once. Traverse second array once
// Space Complexity: O(n) -> HashSet storage.

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num); // for uniqueness
            }
        }

        int[] res = new int[ans.size()];

        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
}