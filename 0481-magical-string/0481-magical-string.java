class Solution {
    public int magicalString(int n) {
              if (n == 0) return 0;
        if (n <= 3) return 1;

        // Initialize the magical string with the first three characters
        int[] s = new int[n + 1];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;

        int readPointer = 2; // Pointer to read the next group size
        int writePointer = 3; // Pointer to write the next group
        int countOnes = 1; // Count of '1's, starting with the first character

        while (writePointer < n) {
            int nextGroupSize = s[readPointer];
            int nextChar = s[writePointer - 1] == 1 ? 2 : 1; // Alternate between 1 and 2

            for (int i = 0; i < nextGroupSize; i++) {
                if (writePointer < n) {
                    s[writePointer] = nextChar;
                    if (nextChar == 1) {
                        countOnes++;
                    }
                    writePointer++;
                }
            }
            readPointer++;
        }

        return countOnes;

    }
}