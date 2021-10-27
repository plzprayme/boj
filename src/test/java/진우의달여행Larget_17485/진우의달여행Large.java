package 진우의달여행Larget_17485;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class 진우의달여행Large {

    static int N, M;
    static int[][] fuels;
    static int[][][] dp;

    private static void solution() {
        for (int d = 0; d < 3; d++) {
            for (int x = 1; x <= M; x++) dp[d][1][x] = fuels[1][x];
        }

        for (int y = 1; y <= N; y++) {
            dp[2][y][M] = 101;
            dp[0][y][1] = 101;
        }

        for (int y = 2; y <= N; y++) {
            for (int x = 1; x <= M; x++) {
                if (x == 1) { // 가장 왼쪽일 때
                    dp[1][y][x] = dp[0][y - 1][x + 1] + fuels[y][x]; // 직진할 때는 왼쪽으로 출발한 녀석만 추가 가능
                    dp[2][y][x] = Math.min(dp[0][y - 1][x + 1], dp[1][y - 1][x]) + fuels[y][x]; // 좌회전 한 녀석과 직진 한 녀석 중 작은 녀석을 추가 가능
                } else if (x == M) { // 가장 오른쪽 일 때
                    dp[1][y][x] = dp[2][y - 1][x -1] + fuels[y][x]; // 직진할 때는 우회전 한 녀석만 추가 가능
                    dp[0][y][x] = Math.min(dp[2][y-1][x-1], dp[1][y-1][x]) + fuels[y][x]; // 좌회전 할 때는 우회전 한 셔거이나 직진한 녀석만 추가 가능
                } else {
                    dp[0][y][x] = Math.min(dp[1][y-1][x], dp[2][y-1][x-1]) + fuels[y][x];
                    dp[1][y][x] = Math.min(dp[0][y-1][x+1], dp[2][y-1][x-1]) + fuels[y][x];
                    dp[2][y][x] = Math.min(dp[0][y-1][x+1], dp[1][y-1][x]) + fuels[y][x];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x = 1, m = M + 1; x < m; x++) {
            for (int d = 0; d < 3; d++) min = Math.min(min, dp[d][N][x]);
        }
        System.out.println(min);
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\진우의달여행Small_17484\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[3][N + 1][M + 1];
        fuels = new int[N + 1][M + 1];

        for (int y = 1, n = N + 1; y < n; y++) {
            st = new StringTokenizer(r.readLine());
            for (int x = 1, m = M + 1; x < m; x++) {
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

