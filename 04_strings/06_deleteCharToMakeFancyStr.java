// LeetCode (1957) - Delete Characters to Make Fancy String 
// Difficulty: Medium
// Approach: traverse the string arr, if len<2, then append the ‘ch’, 	else take last and secLast character of the SB string, if they both are equal to current ‘ch’, then continue, else append to the string. Then return
// Time Complexity: O(n) - only one traversal of string
// Space Complexity: O(n) - stringBuilder 

class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ans.length() < 2) {
                ans.append(ch);
            } else {
                char last = ans.charAt(ans.length() - 1);
                char secLast = ans.charAt(ans.length() - 2);

                if (last == ch && secLast == ch) {
                    continue;
                } else {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}