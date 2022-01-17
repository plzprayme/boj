package 꿈틀꿈틀호석애벌레_20167;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, K;
    static int[] num;
    static List<State>[] dp;
    static int[] answer;

    static long ans = 0;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }


    private static class State {
        int l, v;

        public State(int l, int v) {
            this.l = l;
            this.v = v;
        }
    }

    private static void solution() {
        // 100_001 * 10_000_001

        // 투 포인터
        int sum = 0;
        int right = 1;
        for (int left = 1; left <= N; left++) {
            while (sum < K && right <= N) {
                sum += num[right];
                right++;
            }

            if (sum - K >= 0) {
                dp[right - 1].add(new State(left, sum - K));
                sum -= num[left];
            }
        }

        for (int curRight = 1; curRight <= N; curRight++) {

            for (State now : dp[curRight]) {
                answer[curRight] = Math.max(answer[curRight - 1], answer[now.l - 1] + now.v);
            }

        }

        System.out.println(answer[N]);
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

        dp = new List[N + 1];
        num = new int[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = r.nextInt();
            dp[i] = new ArrayList<>();
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

