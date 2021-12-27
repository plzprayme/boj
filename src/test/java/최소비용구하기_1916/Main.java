package 최소비용구하기_1916;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static List<City>[] graph;

    static int from, to;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<City> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        pq.add(new City(from, 0));
        dist[from] = 0;

        while (!pq.isEmpty()) {
            City now = pq.poll();
            if (dist[now.n] != now.w) continue;

            for (City next : graph[now.n]) {
                if (now.w + next.w >= dist[next.n]) continue;
                dist[next.n] = now.w + next.w;
                pq.add(new City(next.n, dist[next.n]));
            }
        }

        System.out.println(dist[to]);
    }

    private static class City {
        int n, w;

        public City(int n, int w) {
            this.n = n;
            this.w = w;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\최소비용구하기_1916\\input.txt");

        N = r.nextInt(); M = r.nextInt();

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int src = r.nextInt();
            int dst = r.nextInt();
            int cost = r.nextInt();
            graph[src].add(new City(dst, cost));
        }

        from = r.nextInt(); to = r.nextInt();
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

