// LeetCode (31) - Next Permutation 
// Difficulty: Medium
// Approach: 1. Find the first decreasing element from the end of the array. Let's call this index 'idx'.
//           2. If no such element is found, it means the array is in descending order. In this case, reverse the entire array to get the lowest order (first permutation).
//           3. If such an element is found, find the just larger element than arr[idx] from the end of the array and swap them.
//           4. Finally, reverse the subarray from idx + 1 to the end of the array to get the next permutation.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;

        //find first decreasnig element from end
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }

        //if no dip found OR elements keeps increasing (starting from end)
        if (idx == -1) {
            reverse (arr, 0, arr.length - 1);
            return;
        }

        //find just larger element
        for (int i = n - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                swap (arr, i, idx);
                break;
            }
        }

        //reverse part after index
        reverse (arr, idx + 1, arr.length - 1);
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap (arr, start, end);
            start++;
            end--;
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}