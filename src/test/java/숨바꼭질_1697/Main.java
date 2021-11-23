package 숨바꼭질_1697;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, K;
    static boolean[] visit = new boolean[200_001];
    static int answer;

    private static void solution() {
        if (N < K) {
            bfs(N, 0);
        }

        System.out.println(answer);
    }

    private static void bfs(int start, int depth) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(start, depth));

        while (!queue.isEmpty()) {
            State state = queue.poll();

            if (state.cur == K) answer = Math.min(answer, state.depth);
            if (state.cur < 0 || state.cur > 200_000 || visit[state.cur] || state.depth >= answer) continue;
            visit[state.cur] = true;

            if (state.cur < K) {

                if (state.cur * 2  - K <= answer) {
                    queue.add(new State(state.cur * 2, state.depth + 1));
                }

                if (state.cur + 1 - K <= answer) {
                    queue.add(new State(state.cur + 1, state.depth + 1));
                }

            }

            queue.add(new State(state.cur - 1, state.depth + 1));
        }
    }

    private static class State {
        int cur, depth;

        public State(int cur, int depth) {
            this.cur = cur;
            this.depth = depth;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\숨바꼭질_1697\\input.txt");
        N = r.nextInt(); K = r.nextInt();

        answer = Math.abs(K - N);
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

