// LeetCode 49 - Group Anagrams
// Difficulty: Medium
// Approach: use a HashMap where the key is the sorted version of the word and the value is the list of words sharing that sorted form, which groups all anagrams together.
// Time Complexity: O(N * K log K), where N is the number of strings and K is the maximum length of a string in the input array. This is because we are sorting each string, which takes O(K log K) time, and we do this for all N strings.
// Space Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string in the input array. This is because we are storing all the strings in the HashMap, and in the worst case, all strings could be anagrams of each other, leading to O(N * K) space usage.

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);  //convert the array to string

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}