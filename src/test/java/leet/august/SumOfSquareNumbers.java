package leet.august;

class Solution {
    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        long[] dp = new long[sqrt + 1];
        for (int i = 0; i <= sqrt; i++) {
            dp[i] = (long) i * i;
        }

        int i1 = 0;
        int i2 = sqrt;
        long sum;
        while (i1 <= i2) {
            sum = dp[i1] + dp[i2];
            if (sum == c) return true;
            else if (sum > c) i2--;
            else i1++;
        }
        return false;
    }
}
