package 작업;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 작업 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\작업\\input.txt"));

        int N = parse(r.readLine());
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        dp[1] = parse(st.nextToken());

        int max = 0;
        for (int i = 2; i < N + 1; i++) {
            st = new StringTokenizer(r.readLine());
            int time = parse(st.nextToken());
            int pre = parse(st.nextToken());

            if (pre == 0) {
                max = Math.max(max, time);
            } else {
                int longest = 0;
                for (int j = 0; j < pre; j++) {
                    int index = parse(st.nextToken());
                    longest = Math.max(longest, dp[index]);
                }
                dp[i] = longest + time;
            }

        }

        System.out.println(Math.max(dp[N], max));
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
