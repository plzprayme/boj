package 마인크래프트_18111;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int N, M, B;
    static int[][] map;
    static int[] dp;      // 높이 저장해두기 인덱스는 높이를 의미한다!

    private static void solution() {

        // 최소 높이 ~ 최대 높이 순회
        for (int i = min; i <= max; i++) {
            go(i); // i 높이로 평탄화 하는데에 걸리는 시간 계산하기
        }

        // 정답 알아내기
        int value = Integer.MAX_VALUE;
        int index = -1;
        for (int i = min; i <= max; i++) {
            if (value >= dp[i]) {
                value = dp[i];
                index = i;
            }
        }

        System.out.printf("%d %d", value, index);

    }

    private static void go(int h) {
        int time = 0;
        int b = B;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                // num이 양수면 블록을 캐내는 행위
                // num이 음수면 블록을 쌓는 행위
                int num = map[y][x] - h;

                // 양수면 블록 더해주고 2초 더하기
                if (num > 0) {
                    b += num;
                    num *= 2;
                }
                // 음수면 블록 빼주고 1초 더하기
                else if (num < 0) {
                    b += num;
                    num *= -1;
                }
                time += num;
            }
        }

        // 계산 했는데 블록이 음수면 최대값 넣어버리기
        if (b < 0) time = Integer.MAX_VALUE;
        dp[h] = time;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\마인크래프트_18111\\input.txt");
        N = r.nextInt(); M = r.nextInt(); B = r.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = r.nextInt();
                map[i][j] = num;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }

        dp = new int[max + 1];
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
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

