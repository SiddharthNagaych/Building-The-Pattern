class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeroCount = 0;

        // Count the number of zeros to determine the shift
        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            }
        }

        // Iterate from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            if (i + zeroCount < n) {
                arr[i + zeroCount] = arr[i];
            }
            if (arr[i] == 0) {
                zeroCount--;
                if (i + zeroCount < n) {
                    arr[i + zeroCount] = 0;
                }
            }
        }
    }
}