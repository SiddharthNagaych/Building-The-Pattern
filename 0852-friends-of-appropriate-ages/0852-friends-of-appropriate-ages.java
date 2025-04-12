import java.util.Arrays;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        int n = ages.length;
        for (int i = 0; i < n; i++) {
            int age = ages[i];
            if (age < 15) continue;
            double lower = 0.5 * age + 7;
            int upper = age;
            int left = findFirstGreater(ages, lower);
            int right = findLastLessOrEqual(ages, upper);
            if (left > right) continue;
            res += right - left + 1; // +1 to include the person at 'left'
            if (left <= i && i <= right) {
                res--; // subtract 1 to exclude themselves
            }
        }
        return res;
    }

    private int findFirstGreater(int[] ages, double target) {
        int low = 0, high = ages.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (ages[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int findLastLessOrEqual(int[] ages, int target) {
        int low = 0, high = ages.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ages[mid] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}