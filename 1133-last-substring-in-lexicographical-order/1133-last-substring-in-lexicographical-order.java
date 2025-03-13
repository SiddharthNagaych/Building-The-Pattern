public class Solution {
    public String lastSubstring(String s) {
        int n = s.length();
        int i = 0; // Pointer for the first character of the result substring
        int j = 1; // Pointer for the current character being compared
        int k = 0; // Length of the common prefix

        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                // If characters are the same, move to the next character
                k++;
            } else if (s.charAt(i + k) < s.charAt(j + k)) {
                // If the current character at j is larger, update i to j
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            } else {
                // If the current character at j is smaller, move j forward
                j = j + k + 1;
                k = 0;
            }
        }

        return s.substring(i);
    }
}