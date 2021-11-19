package 촌수계산_2644;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N, M, L, R;
    static List<Integer>[] graph;

    static boolean[][] visit;

    static int answer = Integer.MAX_VALUE;

    private static void solution() {
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(L); q.add(0);

        while (!q.isEmpty()) {
            int now = q.poll();
            int count = q.poll();
            for (int next : graph[now]) {
                if (next == R) return count + 1;
                if (visit[now][next]) continue;
                visit[now][next] = true;
                q.add(next); q.add(count + 1);
            }
        }

        return -1;
    }

    private static void dfs(int now, int count) {
        if (now == R) {
            answer = Math.min(answer, count);
        } else {

            for (int next : graph[now]) {
                if (visit[now][next]) continue;
                visit[now][next] = true;
                dfs(next, count + 1);
            }

        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\촌수계산_2644\\input.txt");
        N = r.nextInt();
        L = r.nextInt(); R = r.nextInt();
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        visit = new boolean[N + 1][N + 1];

        M = r.nextInt();
        for (int i = 1; i <= M; i++) {
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

