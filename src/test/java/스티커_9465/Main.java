package 스티커_9465;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N;
    static int[][] dp = new int[3][100_001];
    static int[][] stickers = new int[2][100_001];

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\스티커_9465\\input.txt");
        int t = r.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solution();
        }
        System.out.println(sb);
    }

    private static void solution() {
        // TODO

        // 스티커 2N 개
        // 스티커는 2행 N열 배치

        // 경우의 수
        // 0 윗 행을 뗴거나
        // 1 아랫 행을 뗴거나
        // 2 안떼거나

        // 초기식 없음

        dp[0][0] = stickers[0][0];
        dp[1][0] = stickers[1][0];
        dp[2][0] = 0;

        // 점화식
        for (int i = 1; i <= N; i++) {
             dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + stickers[0][i];
             dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + stickers[1][i];
             dp[2][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1], dp[2][i-1]));
        }

        sb.append(Math.max(dp[0][N], dp[1][N])).append('\n');
    }

    private static void input() throws IOException {
        N = r.nextInt();

        for (int j = 0; j < 2; j++) {
            for (int i = 1; i <= N; i++) {
                stickers[j][i] = r.nextInt();
            }
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
