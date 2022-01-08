package 기타리스트_1495;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, S, M;
    static int[] vol;
    static Set<Integer>[] dp;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 필요한 정보
        // 1. i 번째 곡에서 연주 가능한 볼륨의 경우의 수
        // 2. 중복해서 계산하지 않도록 하기

        for (int i = 0; i < N; i++) {

            if (dp[i].isEmpty()) {
                System.out.println(-1);
                return;
            }

            for (int p : dp[i]) {
                int b = p + vol[i + 1];
                int s = p - vol[i + 1];
                if (b <= M) {
                    dp[i + 1].add(b);
                }

                if (s >= 0) {
                    dp[i + 1].add(s);
                }
            }
        }

        int ans = -1;
        for (int p : dp[N]) {
            ans = Math.max(p, ans);
        }
        System.out.println(ans);

    }

    private static void rec(int N) {

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\기타리스트_1495\\input.txt");
        N = r.nextInt();
        S = r.nextInt();
        M = r.nextInt();

        vol = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            vol[i] = r.nextInt();
        }

        dp = new HashSet[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = new HashSet();
        }

        dp[0].add(S);
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

