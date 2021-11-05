package DFS와BFS_1260;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M, V;
    static List<Integer>[] adj;
    static boolean visited[];
    static StringBuilder sb;

    private static void solution() {
        dfs(V);
        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    // 여기는 탐색 가능하다고 보장
    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(' ');

        for (int i : adj[start]) {
            if (visited[i]) continue;
            dfs(i);
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;
        sb.append(start).append(' ');

        while (!q.isEmpty()) {
            for (int i : adj[q.poll()]) {
                if (visited[i]) continue;
                q.add(i);
                visited[i] = true;
                sb.append(i).append(' ');
            }
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\DFS와BFS_1260\\input.txt");
        r.readLine();
        N = r.nextInt();
        M = r.nextInt();
        V = r.nextInt();
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            r.readLine();
            int left = r.nextInt(), right = r.nextInt();
            adj[left].add(right);
            adj[right].add(left);
        }

        for (int i = 1; i <= N; i++) Collections.sort(adj[i]);
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }

}

