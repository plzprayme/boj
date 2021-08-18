package 로또_2758;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 로또 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\로또_2758\\input.txt"));

        int C = parse(r.readLine());
        for (int K = 0; K < C; K++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int N = parse(st.nextToken());
            int M = parse(st.nextToken());

            long[][] dp = new long[N + 1][M + 1];
            for (int i = 0; i <= M; i++) {
                dp[0][i]++;
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    // 그림 참고 https://boomrabbit.tistory.com/36
                    // j / 2 가 핵심 아이디어
                    dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
                }
            }
            System.out.println(dp[N][M]);
        }

    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

}
