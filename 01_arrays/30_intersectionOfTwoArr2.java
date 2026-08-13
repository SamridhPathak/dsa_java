// LeetCode (350) - Intersection of Two Arrays II
// Difficulty: Easy
// Approach: use two pointers approach, sort the arrays and use two pointers to find common elements. i==j, then add in the list, if i<j then i++ (we increased i bcoz we might find the common element at i+1 or i+2 or etc bcoz i is smaller so high chances that we might find the same element). copy the list to res arr.
// Time Complexity: O(n logn + m logm)
// Space Complexity: O(min(n, m)  {output space}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < result.length; k++) {
            result[k] = list.get(k);
        }
        return result;
    }
}