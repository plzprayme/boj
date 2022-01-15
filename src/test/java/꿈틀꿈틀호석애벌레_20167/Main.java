package 꿈틀꿈틀호석애벌레_20167;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, K;
    static int[] num = new int[100_001];
    static int[][] dp = new int[100_001][3];
    static long[] answer = new long[100_001];

    static long ans = 0;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        dfs(1, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int cur, int sum, int satis) {
        if (sum >= K) {
            satis += sum - K;
            sum = 0;
        }

        if (cur == N + 1) {
            ans = Math.max(satis, ans);
        } else {
            dfs(cur + 1, sum + num[cur], satis);
            dfs(cur + 1, 0, satis);
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\꿈틀꿈틀호석애벌레_20167\\input.txt");

        // 먹이의 개수 20
        // 최소 만족도 K
        N = r.nextInt(); K = r.nextInt();

        for (int i = 1; i <= N; i++) {
            num[i] = r.nextInt();
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

        public long nextLong() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Long.parseLong(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

