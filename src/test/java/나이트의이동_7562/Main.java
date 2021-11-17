package 나이트의이동_7562;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int T, X, Y;
    static int[] src, dst;
    static int[][] dist;

    static InputReader r;

    static int[][] dxy = {
        // x y
        {1, -2},
        {2, -1},
        {2, 1},
        {1, 2},
        {-1, 2},
        {-2, 1},
        {-2, -1},
        {-1, -2}
    };


    private static void solution() {
        bfs();
        System.out.println(dist[dst[1]][dst[0]]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(src[0]); q.add(src[1]);
        dist[src[1]][src[0]] = 0;

        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            if (x == dst[0] && y == dst[1]) continue;

            for (int[] xy : dxy) {
                int nx = x + xy[0];
                int ny = y + xy[1];

                if (isOut(nx, ny)) continue;
                if (dist[ny][nx] != Integer.MAX_VALUE) continue;
                q.add(nx); q.add(ny);
                dist[ny][nx] = dist[y][x] + 1;
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
        X = r.nextInt(); Y = X;
        dist = new int[X][Y];
        for (int i = 0; i < X; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        src = new int[2]; src[0] = r.nextInt(); src[1] = r.nextInt();
        dst = new int[2]; dst[0] = r.nextInt(); dst[1] = r.nextInt();
    }

    @Test
    public static void main(String[] args) throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\나이트의이동_7562\\input.txt");
        T = r.nextInt();
        for (int t = 0; t< T; t++) {
            input();
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

