// GFG - First 1 in sorted binary array
// Difficulty: Easy
// Approach: Find the first occurrence of 1 using binary search. If arr[mid] == 1, store mid as ans and continue searching left. If arr[mid] == 0, search right. Return ans after the loop.
// Space Complexity: O(1)