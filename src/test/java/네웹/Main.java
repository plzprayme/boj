package 네웹;

import java.util.Arrays;

// arr
public class Main {
    public void solution() {
        int x = 3;
        int[] arr = new int[] {1, 2, 4, 5, 6};

        int[] dp = new int[x + 1];
        boolean[][] selected = new boolean[x + 1][x + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= x) {
                dp[arr[i]] = i;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[x - i] != -1 && !selected[i][x-i]) {
                selected[i][x-i] = true;
                System.out.println(dp[i] + dp[x - i]);
            }
        }

    }
}
