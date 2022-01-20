package 전쟁_1303;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {-1, 0, 1, 0};

    static int N, M;

    static char[][] map;
    static boolean[][] visited;

    static int count;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int left = 0, right = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                int result = bfs(i, j);

                if (map[i][j] == 'W') left += result;
                else right += result;
            }
        }

        System.out.printf("%d %d", left, right);
    }

    private static int bfs(int y, int x) {
        Stack<XY> stack = new Stack<>();
        stack.add(new XY(x, y));
        visited[y][x] = true;
        count = 1;

        while (!stack.isEmpty()) {
            XY cur = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != map[cur.y][cur.x]) continue;
                stack.add(new XY(nx, ny));
                visited[ny][nx] = true;
                count++;
            }
        }


        return count * count;
    }

    private static class XY {
        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\전쟁_1303\\input.txt");
        M = r.nextInt(); N = r.nextInt();

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = r.nextCharArr();
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

