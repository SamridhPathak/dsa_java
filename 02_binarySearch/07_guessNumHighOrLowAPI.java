// LeetCode (374) - Guess Number Higher or Lower API
// Difficulty: Easy
// Approach: Use binary search on 1 → n. For each mid, call guess(mid): -1 → guess too high → move high left, 1 → guess too low → move low right, 0 → return mid.
// Time Complexity: O(log n)
// Space Complexity: O(1)

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = high + (low - high) / 2;
            int result = guess(mid);

            if (result == -1) {
                high = mid - 1;
            } else if (result == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}