package 평범한배낭_12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 평범한배낭 {
    @Test
    public static void main(String[] args) throws IOException {
        /**
         * 모든 경우의 수 탐색이 필요해보인다.
         * ex ) K=7 / (6, 100,000), (5, 10), (5, 20), (8, 50), (9, 15), (7, 0)
         *
         * V=0 인 것 제외, K > W인 것 제외외
         */

        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\평범한배낭_12865\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        // N K 입력 받기
        String[] nk = r.readLine().split(" ");
        int N = parse(nk[0]);
        int K = parse(nk[1]);

        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            String[] WV = r.readLine().split(" ");
            W[i] = parse(WV[0]);
            V[i] = parse(WV[1]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                if (W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }

            }
        }
        w.write(String.valueOf(dp[N][K]));
        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
