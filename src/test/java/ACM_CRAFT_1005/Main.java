package ACM_CRAFT_1005;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int T, N, K, W;
    static int[] time;

    static List<Integer>[] out;

    static boolean[] visit;

    static int[] step;
    static int answer = 0;

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\ACM_CRAFT_1005\\input.txt");
        T = r.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            solution();
        }
    }

    private static void solution() {
        // TODO
        // 건물 짓는 순서가 정해져있지 않다.

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(W, 1));
        visit[W] = true;

        while (!queue.isEmpty()) {
            State now = queue.poll();
            step[now.s] = Math.max(step[now.s], step[now.s - 1] + time[now.n]);

            for (int pre : out[now.n]) {
                if (visit[pre]) continue;
                visit[pre] = true;
                queue.add(new State(pre, now.s + 1));
            }

            answer = now.s;
        }
        System.out.println(step[answer]);
    }

    private static class State {
        int n, s;

        public State(int n, int s) {
            this.n = n;
            this.s = s;
        }
    }

    private static void input() throws IOException {
        N = r.nextInt();
        K = r.nextInt();
        time = new int[N + 1];
        for (int i = 1; i <= N; i++) time[i] = r.nextInt();

        out = new List[N + 1];
        for (int i = 1; i <= N; i++) out[i] = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            out[right].add(left);
        }

        W = r.nextInt();

        step = new int[N + 1];

        visit = new boolean[N + 1];
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

