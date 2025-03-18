class Solution {
    public double[] sampleStats(int[] count) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        long sum = 0;
        int totalCount = 0;
        int mode = 0;
        int maxFrequency = 0;

        // Calculate minimum, maximum, sum, totalCount, and mode
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (i < minimum) {
                    minimum = i;
                }
                if (i > maximum) {
                    maximum = i;
                }
                sum += (long) i * count[i];
                totalCount += count[i];
                if (count[i] > maxFrequency) {
                    maxFrequency = count[i];
                    mode = i;
                }
            }
        }

        double mean = (double) sum / totalCount;

        // Calculate median
        double median = 0;
        int medianPos = (totalCount + 1) / 2;
        int currentCount = 0;
        boolean isEven = totalCount % 2 == 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                currentCount += count[i];
                if (currentCount >= medianPos) {
                    if (!isEven || currentCount > medianPos) {
                        median = i;
                    } else {
                        // If even, find the next non-zero count to calculate the average
                        for (int j = i + 1; j < count.length; j++) {
                            if (count[j] > 0) {
                                median = (i + j) / 2.0;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }

        return new double[]{minimum, maximum, mean, median, mode};
    }
}