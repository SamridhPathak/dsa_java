// LeetCode (2678) - Num Of Citizens
// Difficulty: Easy
// Approach: for each string in ‘details’ arr, pick the substring at idx 11 and 12 (bcoz it is specified that age is at that indx), convert it into integer, then compare to 60. Then return ans accordingly. 
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) {
            String age = s.substring(11, 13);
            int num = Integer.parseInt(age);
            if (num > 60) count++;
        }
        return count;
    }
}