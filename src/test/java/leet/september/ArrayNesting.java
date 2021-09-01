package leet.september;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayNesting {
    @Test
    public void main() {
        System.out.println(arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
        System.out.println(arrayNesting(new int[]{0, 1, 2}));
        System.out.println(arrayNesting(new int[]{0, 2, 1}));
    }

    int[] dp;
    public int arrayNesting(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dfs(nums.clone(), i, 0);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private void dfs(int[] nums, int index, int count) {
        int num = nums[index];
        if (dp[num] > 0)  return;
        dp[num] = count;
        dfs(nums, num, ++count);
    }
}
