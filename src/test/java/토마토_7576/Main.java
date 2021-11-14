package 토마토_7576;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int X, Y;
    static int[][] map;

    static Queue<Position> q = new LinkedList<>();

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    private static void solution() {
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!q.isEmpty()) {
            Position now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isOut(nx, ny) || map[ny][nx] != 0) continue;
                map[ny][nx] = map[now.y][now.x] + 1;
                q.add(new Position(nx,ny));
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int[] row: map) {
            for (int col : row) {
                if (col == 0) return -1;
                answer = Math.max(answer, col);
            }
        }
        if (answer == 1) return 0;
        return answer - 1;
    }

    private static boolean isOut(int x, int y) {
        return out(x, X) || out(y, Y);
    }

    private static boolean out(int p, int limit) {
        return p < 0 || p > limit - 1;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\토마토_7576\\input.txt");
        X = r.nextInt();
        Y = r.nextInt();
        map = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                int num = r.nextInt();
                if (num == 1) q.add(new Position(x, y));
                map[y][x] = num;
            }
        }

    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
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
            if (!st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }

}

