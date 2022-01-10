package 우수마을_1949;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] population;
    static List<Integer>[] graph;

    static int[][] dp;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        dfs(0, 1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int prev, int cur) {
        dp[cur][1] = population[cur];

        for (int next : graph[cur]) {
            if (prev == next) continue;
            dfs(cur, next);
            dp[cur][0] += Math.max(dp[next][0], dp[next][1]);
            dp[cur][1] += dp[next][0];
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
