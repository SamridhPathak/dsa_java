// LeetCode (8) - String To Integer
// Difficulty: Medium
// Approach: skip spaces, determine sign, convert to int, take each digit and put it into the number, check overflow and underflow, return
// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        if (i == n) return 0; //if str contains only spaces

        int sign = 1; //determine sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        long number = 0;
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            number = number * 10 + digit;

            if (sign * number <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (sign * number >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            i++;
        }

        return (int)(sign * number);
    }
}