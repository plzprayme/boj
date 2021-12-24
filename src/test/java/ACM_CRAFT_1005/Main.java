package ACM_CRAFT_1005;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int T, N, K, W;
    static int[] time;

    static int[] indegree;

    static List<Integer>[] out;

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\ACM_CRAFT_1005\\input.txt");
        T = r.nextInt();
        for (int t = 0; t < T; t++) {
            input();
            solution();
        }
        System.out.println(sb);
    }

    private static void solution() {
        // TODO
        // 건물 짓는 순서가 정해져있지 않다.

        int[] currentTime = new int[N + 1];
        Queue<State> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) queue.add(new State(i, time[i]));
        }

        while (!queue.isEmpty()) {
            State now = queue.poll();

            if (now.n == W) {
                sb.append(now.t).append('\n');
                return;
            }

            for (int next : out[now.n]) {
                currentTime[next] = Math.max(currentTime[next], now.t + time[next]);
                if (--indegree[next] == 0) {
                    queue.add(new State(next, currentTime[next]));
                }
            }

        }

    }

    private static class State {
        int n, t;

        public State(int n, int t) {
            this.n = n;
            this.t = t;
        }
    }

    private static void input() throws IOException {
        N = r.nextInt();
        K = r.nextInt();
        time = new int[N + 1];
        for (int i = 1; i <= N; i++) time[i] = r.nextInt();

        out = new List[N + 1];
        for (int i = 1; i <= N; i++) out[i] = new ArrayList<>();

        indegree = new int[N + 1];

        for (int i = 0; i < K; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            out[left].add(right);
            indegree[right]++;
        }

        W = r.nextInt();
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

