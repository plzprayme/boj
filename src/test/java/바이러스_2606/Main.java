package 바이러스_2606;

import java.io.*;
import java.sql.Array;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N, M;
    static boolean[] visit;
    static List<Integer>[] graph;
    static int answer = 0;

    private static void solution() {
        bfs(1);
        System.out.println(answer);
    }

    private static void dfs(int now) {
        visit[now] = true;

        for (int next : graph[now]) {
            if (visit[next]) continue;
            answer++;
            dfs(next);
        }
    }

    private static void bfs(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.add(node);
        visit[node] = true;

        while (!stack.isEmpty()) {
            int now = stack.pop();

            for (int next : graph[now]) {
                if (visit[next]) continue;
                answer++;
                visit[next] = true;
                stack.add(next);

            }
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\바이러스_2606\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            graph[left].add(right);
            graph[right].add(left);
        }
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

