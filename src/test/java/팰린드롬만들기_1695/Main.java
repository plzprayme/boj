package 팰린드롬만들기_1695;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class Main {

    private static int[] nums = new int[5001];
    private static int[][] dp = new int[5001][5001];

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\팰린드롬만들기_1695\\input.txt"));

        int N = parse(r.readLine());
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = parse(st.nextToken());
        }

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(dfs(0, N - 1));

    }

    private static int dfs(int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        int left = nums[l];
        int right = nums[r];
        if (left == right) {
            return dp[l][r] = dfs(l + 1, r - 1);
        }

        return dp[l][r] = Math.min(dfs(l + 1, r) + 1, dfs(l, r - 1) + 1);
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
