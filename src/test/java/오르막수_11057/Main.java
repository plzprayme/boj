package 오르막수_11057;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[][] dp;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 초기식
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 점화식
        for (int i = 2; i <= N; i++) {
            for (int now = 0; now < 10; now++) {
                for (int pre = now; pre > -1; pre--) {
                    dp[i][now] =  (dp[i][now] + dp[i - 1][pre]) % 10_007;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % 10_007;
        }
        System.out.println(sum);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        N = r.nextInt();

        dp = new int[N + 1][10];
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

