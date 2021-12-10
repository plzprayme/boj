package 서울지하철2호선_16947;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N;
    static List<Integer>[] graph;
    static int[][] dist;
    static boolean[] visit; // 무조건 연결되어있다.
    static int[] parent;

    static int[] distance;



    private static void solution() {

        // 싸이클 판별
        dfs(0, 1);

    }

    private static void dfs(int pre, int cur) {

        visit[cur] = true;
        for (int next : graph[cur]) {

            if (visit[next] && pre != next) {
                distance[next] = Integer.MAX_VALUE;
                continue;
            }

            dfs(cur, next);


        }
    }

    private static void union(int a, int b) {
        int tree1 = find(a);
        int tree2 = find(b);

        if (tree1 > tree2) parent[a] = tree2;
        else parent[b] = tree1;
    }

    // 두 원소가 같은 부모를 가리키면 같은 집합이다.
    // 자기 자신이 부모면 그 값이 집합을 대표하는 번호다.
    // 지금 원소가 가리키는 값을 재귀적으로 다시 find 함수에 넘겨준다.
    private static int find(int node) {
        if (parent[node] == node) return node;
        return find(parent[node]);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\서울지하철2호선_16947\\input.txt");
        N = r.nextInt();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        visit = new boolean[N + 1];

        dist = new int[N + 1][N + 1];

        distance = new int[N + 1];

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
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
