package 계단오르기_2579;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] a;
    static int[][] dp;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // TODO
        // 한 계단 혹은 두 계단
        // 연속된 세 개의 계단 X
        // 마지막 계단은 밟아야함

        // 1 1 2

        // 이 계단에서 1칸 or 2칸
        //

        // 10 or 20

        // 파티셔닝이 일정하지 않다.
        // 마지막에 한칸을 오른 경우
        // 마지막에 두칸을 오른 경우

        // 이 계단에 어떻게 도착했는지?
        // 직전에 i - 2번째 계단도 밟았는가? (세개의 칸을 연속적으로 밟았는지?)
        // 모자란 정보 (i - 2번쨰 계단을 밟았는지 정보)를 추가한다.

        // dp[i][0] i-1계단을 밟지 않고서 i번째에 도착하는 최대점수
        // dp[i][1] i-1계단을 밟고서 i번째에 도착하는 최대 점수

        // 초기식
        // dp[0][0] = a[0]

        // dp[1][0] = a[1]
        // dp[1][1] = a[0] + a[1]

        // 점화식 (i > 1)
        // dp[i][0] = Max(dp[i-2][0], dp[i-2][1]) + a[i]
        // dp[i][1] = dp[i-1][0] + a[i]


        // 예외 처리
        if (N == 1) {
            System.out.println(a[1]);
            return;
        } else if (N == 2) {
            System.out.println(a[1] + a[2]);
            return;
        }

        int[][] dp = new int[N + 1][N + 1];
        // 초기식
        dp[1][0] = a[1];

        dp[2][0] = a[2];
        dp[2][1] = a[1] + a[2];

        // 점화식
        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + a[i];
            dp[i][1] = dp[i - 1][0] + a[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\계단오르기_2579\\input.txt");
        N = r.nextInt();

        a = new int[N + 1];
        for (int i = 1; i <= N; i++) a[i] = r.nextInt();
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
