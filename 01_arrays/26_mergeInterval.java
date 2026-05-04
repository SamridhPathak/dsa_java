// LeetCode (56) - Merge Intervals
// Difficulty: Medium
// Approach: Sort the intervals based on their start times. Then, iterate through the sorted intervals and merge them if they overlap. If they do not overlap, add the current interval to the result list and move on to the next interval. Finally, convert the result list back to an array and return it.
// Time Complexity: O(n log n) - due to sorting the intervals, where n is the number of intervals
// Space Complexity: O(n) - in the worst case, if all intervals are non-overlapping, we will have n intervals in the result list

class Solution {
    public int[][] merge(int[][] intervals) {
        //sort intervals based on start 
        Arrays.sort(
            intervals,
            (a, b) -> Integer.compare(a[0], b[0])
        );

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= current[1]) { //if overlap
                current[1] = Math.max(current[1], next[1]);
            } else { //if no overlap
                result.add(current); 
                current = next;
            }
        }

        //for last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}