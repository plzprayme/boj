package DFS와BFS_1260;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M, V;
    static PriorityQueue[] node1;
    static PriorityQueue[] node2;
    static boolean visited[];
    static StringBuilder sb;

    private static void solution() {
        visited = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        visited = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        sb.append(start).append(' ');
        while (!node2[start].isEmpty()) {
            int now = (int) node2[start].poll();
            queue.offer(now);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (visited[now]) continue;

            visited[now] = true;
            sb.append(now).append(' ');
            while (!node2[now].isEmpty()) {
                int next = (int) node2[now].poll();
                queue.offer(next);
            }
        }
    }

    private static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;
        sb.append(start).append(' ');
        while (!node1[start].isEmpty()) {
            dfs((int) node1[start].poll());
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\DFS와BFS_1260\\input.txt");
        r.readLine();
        N = r.nextInt();
        M = r.nextInt();
        V = r.nextInt();
        node1 = new PriorityQueue[N + 1];
        node2 = new PriorityQueue[N + 1];

        for (int i = 1; i <= N; i++) {
            node1[i] = new PriorityQueue<Integer>();
            node2[i] = new PriorityQueue<Integer>();
        }

        for (int i = 0; i < M; i++) {
            r.readLine();
            int left = r.nextInt();
            int right = r.nextInt();
            node1[left].add(right);
            node1[right].add(left);

            node2[left].add(right);
            node2[right].add(left);
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }

}

