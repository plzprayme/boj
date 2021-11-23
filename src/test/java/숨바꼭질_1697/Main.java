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
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); queue.add(depth);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curDepth = queue.poll();

            if (cur == K) answer = Math.min(answer, curDepth);
            if (cur < 0 || cur > 200_000 || visit[cur] || curDepth >= answer) continue;
            visit[cur] = true;

            if (start < K) {

                if (start * 2  - K <= answer) {
                    queue.add(cur * 2); queue.add(curDepth + 1);
                }

                if (cur + 1 - K <= answer) {
                    queue.add(cur + 1); queue.add(curDepth + 1);
                }

            }

            queue.add(cur - 1); queue.add(curDepth + 1);
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

