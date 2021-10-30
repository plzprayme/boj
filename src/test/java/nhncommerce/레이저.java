package nhncommerce;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class 레이저 {

    static int N, M, K;
    static int[][] nums;
    static int[] idx;
    static int[] selected;
    static int answer = Integer.MIN_VALUE;
    @Test
    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\nhncommerce\\input2.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new int[N][M];
        selected = new int[N]; idx = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0);
        System.out.println(answer);
    }

    static private void combination(int n) {
        if (n == N) {
            int move = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                move += M - idx[i];
                sum += nums[i][idx[i]];
            }
            if (move == K) {
                answer = Math.max(answer, sum);
            }
        } else {
            for (int i = 0; i < M; i++) {
                selected[n] = nums[n][i];
                idx[n] = i;
                combination(n + 1);
            }
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
    }

}

