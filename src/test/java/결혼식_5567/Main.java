package 결혼식_5567;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visit;

    private static void solution() {

        System.out.println(bfs(1));
    }

    private static int bfs(int start) {
        Queue<State> queue = new LinkedList<>();
        for (int i : graph[start]) {
            queue.add(new State(i, 1));
        }
        visit[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.depth > 2) continue;
            if (visit[current.node]) continue;
            visit[current.node] = true;
            count++;

            for (int i : graph[current.node]) {
                queue.add(new State(i, current.depth + 1));
            }
        }

        return count;
    }

    private static class State {
        int node, depth;

        public State(int node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }



    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\결혼식_5567\\input.txt");
        N = r.nextInt(); M = r.nextInt();

        visit = new boolean[N + 1];

        graph = new List[N + 1];
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

