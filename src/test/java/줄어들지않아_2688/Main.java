package 줄어들지않아_2688;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int N;
    static long[][] dp = new long[65][10];

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\줄어들지않아_2688\\input.txt");
        pre();

        int t = r.nextInt();
        for (int i = 0; i < t; i++) {
            input();
            solution();
        }

        System.out.println(sb);
    }

    private static void pre() {
        // 1234는 줄어들지 않는다.
        // 0011 1111 1112 1122 2223

        // 가장 끝의 숫자가 무엇으로 끝나는지 파악하자.

        // 시간 복잡도
        // 63 * (10^2 + 10) / 2


        // 초기식
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 점화식
        for (int i = 2; i < 65; i++) { // 63
            for (int j = 0; j < 10; j++) { // 10
                for (int k = j; k > -1; k--) { //
                    dp[i][j] += dp[i-1][k];
                }
            }
        }
    }

    private static void solution() {
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
        }
        sb.append(sum).append('\n');
    }

    private static void input() throws IOException {
        N = r.nextInt();
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

