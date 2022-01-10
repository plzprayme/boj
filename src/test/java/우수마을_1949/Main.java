package 우수마을_1949;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] population;
    static List<Integer>[] graph;

    static int[][] dp;

    static int ans = 0;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 무방향 트리 구조를 가진 N 개의 마을이 있다.
        // 우수 마을을 선정해보자.

        // 우수 마을로 선정된 마을 주민 수의 총 합을 최대로 해야 한다.
        // 인전합 두 마을은 우수 마을로 선정될 수 없다.
        // 우수마을로 선정되지 못한 마을은 적어도 하나의 우수마을과 인접해야 한다.

        // 초기식
        // 루트를 1로 고정
        dp[1][0] = population[1];

        for (int next : graph[1]) dfs(1, next);
        // 점화식
        // 0 == 우수 마을
        // 1 == 우수 X
        // 2 == 2연속 우수 X (리프 노드는 2연속 우수 X 안된다.)


        System.out.println(ans);
    }

    private static void dfs(int prev, int cur) {
        dp[cur][0] = Math.max(dp[prev][1], dp[prev][2]) + population[cur];
        dp[cur][1] = dp[prev][0];
        dp[cur][2] = dp[prev][1];

        if (graph[cur].size() == 1) {
            ans += Math.max(dp[cur][0], dp[cur][1]);
            return;
        }

        for (int next : graph[cur]) {
            if (prev == next) continue;
            dfs(cur, next);
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\우수마을_1949\\input.txt");

        N = r.nextInt();
        graph = new List[N + 1];
        population = new int[N + 1];
        for (int i = 1; i <= N; i ++) {
            population[i] = r.nextInt();
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            graph[left].add(right);
            graph[right].add(left);
        }

        dp = new int[N + 1][3];
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
