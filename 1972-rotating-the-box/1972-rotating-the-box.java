class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] rotated = new char[n][m];

        // Step 1: Apply Gravity
        for (int i = 0; i < m; i++) {
            int emptySpace = n - 1; // Track the last empty space position
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][emptySpace] = '#';
                    emptySpace--;
                } else if (boxGrid[i][j] == '*') {
                    emptySpace = j - 1; // Reset empty space pointer
                }
            }
        }

        // Step 2: Rotate 90 Degrees Clockwise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotated;
    }
}
