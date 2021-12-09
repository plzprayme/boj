package 가장가까운공통조상_3584;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

	static int T;

    static int[] parentTable;

    static Set<Integer> visit = new HashSet<>();

    static InputReader r;

    private static void solution() throws IOException {
        // 트리 입력
        int N = r.nextInt();
        parentTable = new int[N + 1];
        for (int i = 1; i < N; i++) {
            int parent = r.nextInt();
            int child = r.nextInt();
            parentTable[child] = parent;
        }

        dfs(r.nextInt());
        System.out.println(dfs(r.nextInt()));
        visit.clear();
    }

    private static int dfs(int node) {
        if (visit.contains(node) || parentTable[node] == 0) return node;
        visit.add(node);
        return dfs(parentTable[node]);
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\가장가까운공통조상_3584\\input.txt");
        T = r.nextInt();
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < T; i++) {
            solution();
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

