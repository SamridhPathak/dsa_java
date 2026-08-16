// GFG - Find Kth Rotation
// Difficulty: Easy
// Approach: The index of the minimum element is the number of rotations. If arr[mid] > arr[end], the minimum lies on the right side, so move start = mid + 1. Otherwise, the minimum is at mid or on the left side, so move end = mid. When start == end, that 'start' index is the minimum element and hence the number of rotations.
// Time Complexity: O(log n) 
// Space Complexity: O(1)

class Solution {
    public int findKRotation(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}