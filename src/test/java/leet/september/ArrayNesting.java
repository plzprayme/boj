package leet.september;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArrayNesting {
    @Test
    public void main() {
        arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2});
    }

    boolean[] visited;
    int[] dp;
    public int arrayNesting(int[] nums) {
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited = new boolean[nums.length];
            dp[i] = dfs(nums.clone(), i, 0);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private int dfs(int[] nums, int index, int count) {
        int num = nums[index];
        if (visited[num]) return count;
        visited[num] = true;
        return dfs(nums, num, ++count);
    }
}
