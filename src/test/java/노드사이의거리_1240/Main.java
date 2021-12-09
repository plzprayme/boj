package 노드사이의거리_1240;

import java.io.*;
import java.util.*;


import org.junit.jupiter.api.Test;

class Main {

    static int N, M;

    static List<Node>[] tree;

    static InputReader r;

    private static void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int src = r.nextInt();
            int dst = r.nextInt();
            sb.append(dfs(src, src, dst, 0)).append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int pre, int cur, int dst, int weight) {
        if (cur == dst) return weight;

        for (Node next : tree[cur]) {
            if (next.n == pre) continue;
            int distance = dfs(cur, next.n, dst, weight + next.w);
            if (distance != 0) return distance;
        }

        return 0;
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\노드사이의거리_1240\\input.txt");
        N = r.nextInt(); M = r.nextInt();
        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            int weight = r.nextInt();

            tree[left].add(new Node(right, weight));
            tree[right].add(new Node(left, weight));
        }
    }

    static class Node {
        int n, w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
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

