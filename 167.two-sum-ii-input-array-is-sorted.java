/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo < hi) {
            int sum = numbers[lo] + numbers[hi];

            if (sum == target) {
                return new int[] {lo + 1, hi + 1};
            } else if (sum > target) {
                hi--;
            } else {
                lo++;
            }
        }

        return new int[] {-1, -1};
    }
}
// @lc code=end

