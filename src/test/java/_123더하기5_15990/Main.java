package _123더하기5_15990;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static long[][] dp = new long[100_001][3];

    @Test
    public static void main(String[] args) throws IOException {
        preprocess();
        process();

    }

    private static void preprocess() {
        // dp[i][0] 1로 끝나는 수
        // dp[i][1] 2로 끝나는 수
        // dp[i][2] 3으로 끝나는 수
        // 초기식
        dp[1][0] = 1;

        dp[2][1] = 1;

        dp[3][0] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        // 점화식
        for (int i = 4; i < 100_001; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % 1_000_000_009;
            dp[i][1] = (dp[i-2][0] + dp[i-2][2]) % 1_000_000_009;
            dp[i][2] = (dp[i-3][0] + dp[i-3][1]) % 1_000_000_009;
        }
    }

    private static void process() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\_123더하기5_15990\\input.txt");
        int N = r.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < N; i++) {
            int n = r.nextInt();
            sb.append((dp[n][0] + dp[n][1]+ dp[n][2]) % 1_000_000_009).append('\n');
        }
        System.out.println(sb);
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
