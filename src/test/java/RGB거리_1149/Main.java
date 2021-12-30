package RGB거리_1149;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static final int R = 0;
    static final int G = 1;
    static final int B = 2;

    static int N;
    static int[][] costs;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // TODO

        // N번 집과 N - 1번 집의 색은 같지 않아야 한다 .
        // i - 1 번과 i 번 집의 색과 같지 않아야 한다.
        // i + 1 번과 i 번 집의 색과 같지 않아야 한다.

        // 어쨋든 왼쪽이랑 색만 다르면 된다.

        // 초기식
        // dp[0][r] = r.next();
        // dp[0][g] = r.next();
        // dp[0][b] = r.next();

        // 점화식
        // dp[i][r] = Min(dp[i - 1][g], dp[i - 1][b]) + costs[i][r];
        // dp[i][g] = Min(dp[i - 1][r], do[i - 1][b]) + costs[i][g];
        // dp[i][b] = Min(dp[i - 1][r], do[i - 1][g]) + costs[i][b];

        int[][] dp = new int[N + 1][N + 1];
        dp[1][R] = costs[1][R];
        dp[1][G] = costs[1][G];
        dp[1][B] = costs[1][B];

        for (int i = 2; i <= N; i++) {
            dp[i][R] = Math.min(dp[i - 1][G], dp[i - 1][B]) + costs[i][R];
            dp[i][G] = Math.min(dp[i - 1][R], dp[i - 1][B]) + costs[i][G];
            dp[i][B] = Math.min(dp[i - 1][R], dp[i - 1][G]) + costs[i][B];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i< 3; i++) {
            min = Math.min(dp[N][i], min);
        }
        System.out.println(min);
    }


    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\RGB거리_1149\\input.txt");

        N = r.nextInt();
        costs = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            costs[i][R] = r.nextInt();
            costs[i][G] = r.nextInt();
            costs[i][B] = r.nextInt();
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

