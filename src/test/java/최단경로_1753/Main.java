package 최단경로_1753;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int V, E;
    static int start;

    static List<Node>[] graph;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.n] != now.w) continue;

            for (Node next : graph[now.n]) {
                if (now.w + next.w >= dist[next.n]) continue;
                dist[next.n] = now.w + next.w;
                pq.add(new Node(next.n, dist[next.n]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\최단경로_1753\\input.txt");
        V = r.nextInt(); E = r.nextInt();
        start = r.nextInt();

        graph = new List[V + 1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            int from = r.nextInt();
            int to = r.nextInt();
            int weight = r.nextInt();
            graph[from].add(new Node(to, weight));
        }
    }

    private static class Node {
        int n, w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
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

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

