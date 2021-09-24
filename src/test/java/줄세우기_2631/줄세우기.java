package 줄세우기_2631;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class 줄세우기 {

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\줄세우기_2631\\input.txt"));

        int N = parse(r.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = parse(r.readLine());
        }

        int answer = 0;
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {

            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) dp[i]++;
                answer = Math.max(answer, dp[i]);
            }

        }

        System.out.printf("%d", N - answer);
    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }
}
