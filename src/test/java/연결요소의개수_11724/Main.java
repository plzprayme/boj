package 연결요소의개수_11724;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static boolean[] visit;
    static List<Integer>[] graph;


    private static void solution() {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            // dfs(i);
            bfs(i);
            count++;
        }
        System.out.println(count);
    }

    private static void dfs(int i) {
        visit[i] = true;

        for (int j : graph[i]) {
            if (visit[j]) continue;
            dfs(j);
        }
    }

    private static void bfs(int i) {
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        visit[i] = true;

        while (!stack.isEmpty()) {
            int now = stack.pop();

            for (int j : graph[now]) {
                if (visit[j]) continue;
                stack.add(j);
                visit[j] = true;
            }
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\연결요소의개수_11724\\input.txt");
        r.readLine();
        N = r.nextInt(); M = r.nextInt();
        graph = new List[N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            r.readLine();
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }

}

