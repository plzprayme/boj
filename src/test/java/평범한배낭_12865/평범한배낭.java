package 평범한배낭_12865;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = parse(st.nextToken());
        int W = parse(st.nextToken());

        int[] _W = new int[N + 1];
        int[] V = new int[N + 1];
        int[] dp = new int[W + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(r.readLine());
            _W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = W; j - _W[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - _W[i]] + V[j]);
            }
        }

        w.write(String.format(String.valueOf(dp[W])));
        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
