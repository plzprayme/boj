package 유기놈배추_1012;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int T, M, N, K;
    static boolean[][] map;
    static boolean[][] visit;
    static InputReader r;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    private static void solution() throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\유기놈배추_1012\\input.txt");
        r.readLine();
        T = r.nextInt();

        for (int t = 0; t < T; t++) {
            input();
            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }

    }

    private static void bfs(int y, int x) {
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(x, y));

        while (!stack.isEmpty()) {
            Point now = stack.pop();
            visit[now.y][now.x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isOut(nx, ny) || visit[ny][nx] || !map[ny][nx]) continue;
                stack.add(new Point(nx, ny));
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return y < 0 || y >= M || x < 0 || x >= N;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        r.readLine();
        M = r.nextInt();
        N = r.nextInt();
        map = new boolean[M][N];
        visit = new boolean[M][N];

        K = r.nextInt();
        for (int i = 0; i < K; i++) {
            r.readLine();
            map[r.nextInt()][r.nextInt()] = true;
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
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
