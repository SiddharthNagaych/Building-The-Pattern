class Solution {
    public int compress(char[] chars) {
        int index = 0; // Position to insert compressed characters
        int i = 0;

        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;

            // Count occurrences of the current character
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }

            // Store the character
            chars[index++] = currentChar;

            // Store count as individual characters if greater than 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index; // New compressed length
    }
}
