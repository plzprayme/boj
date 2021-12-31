package 포도주시식_2156;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] drink;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // TODO

        // 포도주 잔을 선택 후 다 마시고 원래 위치에 놓는다.
        // 연속으로 3잔을 모두 마실 수 없다.

        // 최대한 많은 양의 포도주를 맛보고 싶다.

        // 1 1 0

        // 1 0 1
        // 1 0 0

        // 0 1 1
        // 0 1 0

        // 2잔을 연속으로 마셨는지 확인해야한다.
        // 0 안마심 1 마심 2 마심

        // dp[1][0] = 0        안마심
        // dp[1][1] = drink[0] 마심
        // dp[1][2] = 0

        // dp[i][0] = Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2])
        // dp[i][1] = dp[i-1][0] + drink[i]
        // dp[i][2] = dp[i-1][1] + drink[i]

        int[][] dp = new int[N + 1][N + 1];
        dp[1][1] = drink[1];

        for (int i = 2; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
            dp[i][1] = dp[i-1][0] + drink[i];
            dp[i][2] = dp[i-1][1] + drink[i];
        }

        System.out.println(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2])));
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\포도주시식_2156\\input.txt");
        N = r.nextInt();

        drink = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            drink[i] = r.nextInt();
        }
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

