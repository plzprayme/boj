package 미로탐색_2178;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int X, Y, answer = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visit;

    static int[][] dxy = {
        // x y
        {0, -1},
        {1, 0},
        {0, 1},
        {-1, 0}
    };

    private static void solution() {
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == X - 1 && now[1] == Y - 1) answer = Math.min(answer, now[2]);

            for (int[] xy : dxy) {
                int nx = now[0] + xy[0];
                int ny = now[1] + xy[1];

                if (isOut(nx, ny) || visit[ny][nx] || map[ny][nx] == 0) continue;
                visit[ny][nx] = true;
                q.add(new int[] {nx, ny, now[2] + 1});
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
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\미로탐색_2178\\input.txt");
        Y = r.nextInt(); X = r.nextInt();
        map = new int[Y][X];
        visit = new boolean[Y][X];

        for (int y = 0; y < Y; y++) {
            char[] arr = r.nextCharArr();
            for (int x = 0; x < X; x++) {
                map[y][x] = arr[x] - '0';
            }
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

