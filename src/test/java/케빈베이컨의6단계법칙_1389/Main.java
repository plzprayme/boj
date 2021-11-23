package 케빈베이컨의6단계법칙_1389;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static Set<Integer>[] graph;

    private static void solution() {
        int value = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int tmp = bfs(i);
            if (value > tmp) {
                value = tmp;
                answer = i;
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int start) {
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<State> queue = new PriorityQueue<>();
        for (int next : graph[start]) {
            queue.add(new State(next, 1));
        }
        visit[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            if (visit[cur.node]) continue;
            visit[cur.node] = true;
            count += cur.depth;
            for (int next : graph[cur.node]) {
                if (visit[next]) continue;
                queue.add(new State(next, cur.depth + 1));
            }
        }
        return count;
    }

    private static class State implements Comparable<State> {
        int node, depth;

        public State(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        @Override
        public int compareTo(State o) {
            return Integer.compare(depth, o.depth);
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader(
            "C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\케빈베이컨의6단계법칙_1389\\input.txt");
        N = r.nextInt();
        M = r.nextInt();

        graph = new Set[N + 1];
        for (int i = 1; i <= N; i++)
            graph[i] = new HashSet<>();

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
            if (!st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }

}

