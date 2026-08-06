// LeetCode (13) - Roman To Integer
// Difficulty: Easy
// Approach: traverse from left to right. If current is smaller than next, then subtract it, else add it. Make a helper function to get value of a Roman numeral using switch case.
// Time Complexity: O(n) 
// Space Complexity: O(1)

class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int currVal = getVal(s.charAt(i));
            if (i < s.length() - 1) {
                int nextVal = getVal(s.charAt(i + 1));
                if (currVal < nextVal) {
                    ans -= currVal;
                } else {
                    ans += currVal;
                }
            } else {
                ans += currVal;
            }
        }
        return ans;
    }
    private int getVal(char ch) {
        switch(ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}