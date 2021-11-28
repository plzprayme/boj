package 트리의부모찾기_11725;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static List<Integer>[] tree;
    static int[] parent;

    private static void solution() {
        dfs(0, 1);
        printAnswer();
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(int parentNode, int curNode) {
        parent[curNode] = parentNode;
        for (int next : tree[curNode]) {
            if (parent[next] != -1) continue;
            dfs(curNode, next);
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\트리의부모찾기_11725\\input.txt");
        // 루트는 1이다.
        // 각 노드의 부모를 구하는 프로그램
        int N = r.nextInt();
        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        parent = new int[N + 1];
        Arrays.fill(parent, -1);

        // 1 -> 6
        for (int i = 0; i < N - 1; i++) {
            int parent = r.nextInt();
            int child = r.nextInt();
            tree[child].add(parent);
            tree[parent].add(child);
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

