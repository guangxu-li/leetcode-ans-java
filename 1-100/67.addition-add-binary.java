/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';

            int sum = x + y + carry;
            carry = sum / 2;

            sb.append(sum % 2);

            i--;
            j--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
// @lc code=end

