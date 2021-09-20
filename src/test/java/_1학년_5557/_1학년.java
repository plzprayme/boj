package _1학년_5557;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class _1학년 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\_1학년_5557\\input.txt"));

        int N = parse(r.readLine());
        int[] nums = new int[N];
        long[][] dp = new long[N - 1][21];

        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = parse(st.nextToken());
        }

        dp[0][nums[0]] = 1;
        for (int i = 0; i < nums.length - 2; i++) {

            for (int j = 0; j <= 20; j++) {
                long now = dp[i][j];
                if (now == 0) continue;

                if (j + nums[i + 1] <= 20) {
                    dp[i + 1][j + nums[i + 1]] += now;
                }

                if (j - nums[i + 1] >= 0) {
                    dp[i + 1][j - nums[i + 1]] += now;
                }
            }

        }

        System.out.println(dp[N-2][nums[nums.length - 1]]);


    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }
}
