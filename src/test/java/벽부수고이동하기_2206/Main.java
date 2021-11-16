package 벽부수고이동하기_2206;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int X, Y;
    static int[][] map;
    static boolean[][][] visit;
    static int answer = Integer.MAX_VALUE;

    static int[][] dxy = {
        // y x
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    private static void solution() {
        bfs();

        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 0, 1));

        while (!q.isEmpty()) {
            State now = q.poll();
            if (now.x == X - 1 && now.y == Y - 1) {
                answer = Math.min(answer, now.c);
                continue;
            }

            for (int[] xy : dxy) {
                int ny = now.y + xy[0];
                int nx = now.x + xy[1];
                int nc = now.c + 1;
                int nw = now.w;

                if (isOut(nx, ny) || visit[ny][nx][now.w]) continue;
                if (now.w == 1 && map[ny][nx] == 1) continue;

                if (map[ny][nx] == 1) { nw = 1; }

                visit[ny][nx][nw] = true;
                q.add(new State(nx, ny, nw, nc));
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return check(x, X) || check(y, Y);
    }

    private static boolean check(int p, int l) {
        return p < 0 || p > l - 1;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\벽부수고이동하기_2206\\input.txt");
        Y = r.nextInt(); X = r.nextInt();
        map = new int[Y][X];
        visit = new boolean[Y][X][2];

        for (int y = 0; y < Y; y++) {
            char[] arr = r.nextCharArr();
            for (int x = 0; x < X; x++) {
                map[y][x] = arr[x] - '0';
            }
        }
        map[0][0] = 2;
        visit[0][0][0] = true;
        visit[0][0][1] = true;
    }

    private static class State {
        int x, y, w, c;

        public State(int x, int y, int w, int c) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.c = c;
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

