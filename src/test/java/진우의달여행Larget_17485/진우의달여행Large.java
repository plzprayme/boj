package 진우의달여행Larget_17485;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class 진우의달여행Large {

    static int N, M;
    static int[][] fuels;
    static int[][][] dp;

    private static void solution() {
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                for (int d = 0; d < 3; d++) {
                    dp[d][y][x] = getBestWay(y - 1, x, d) + fuels[y][x];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= M; x++) {
            for (int d = 0; d < 3; d++) min = Math.min(min, dp[d][N][x]);
        }
        System.out.println(min);
    }

    // 0 : ↙
    // 1 : ↓
    // 2 : ↘
    private static int getBestWay(int y, int x, int d) {
        if (x == 1 && d == 0) return 101;
        if (x == M && d == 2) return 101;
        int[] dx = {1, 0, -1};

        int d1, d2;
        if (d == 0) { d1 = 1; d2 = 2; }
        else if (d == 1) { d1 = 0; d2 = 2; }
        else { d1 = 0; d2 = 1; }


        return Math.min(dp[d1][y][x + dx[d1]], dp[d2][y][x + dx[d2]]);
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\진우의달여행Small_17484\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        dp = new int[3][N + 1][M + 2]; fuels = new int[N + 1][M + 1];

        for (int y = 1; y <= N; y++) {
            dp[2][y][0] = 101;
            dp[0][y][1] = 101;
            dp[2][y][M] = 101;
            dp[0][y][M + 1] = 101;
        }


        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(r.readLine());
            for (int x = 1; x <= M; x++) {
                fuels[y][x] = Integer.parseInt(st.nextToken());
            }
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}

