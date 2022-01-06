package _123더하기3_15988;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static long[] dp = new long[1_000_001];

    @Test
    public static void main(String[] args) throws IOException {
        preprocess();
        process();
    }

    private static void preprocess() {
        // 초기식
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 점화식
        for (int i = 4; i < 1_000_001; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
        }
    }

    private static void solution() {
        // TODO

    }

    private static void process() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\_123더하기3_15988\\input.txt");

        int T = r.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[r.nextInt()]).append('\n');
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

