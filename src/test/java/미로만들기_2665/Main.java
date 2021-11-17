package 미로만들기_2665;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int X, Y;
    static char[][] map;
    static int[][] count;

    static int[][] dxy = {
        // x y
        {0, -1},
        {1, 0},
        {0, 1},
        {-1, 0}
    };

    private static void solution() {
        bfs();
        System.out.println(count[Y - 1][X - 1]);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); q.add(0);
        count[0][0] = 0;

        while(!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();

            for (int[] xy : dxy) {
                int nx = x + xy[0];
                int ny = y + xy[1];
                int nc = count[y][x];

                if (isOut(nx, ny) || count[ny][nx] <= count[y][x]) continue;
                if (map[ny][nx] == '0') {  nc++; }
                q.add(nx); q.add(ny);
                count[ny][nx] = nc;
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
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\미로만들기_2665\\input.txt");
        X = r.nextInt();
        Y = X;
        map = new char[Y][X];
        count = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            map[y] = r.nextCharArr();
            Arrays.fill(count[y], Integer.MAX_VALUE);
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

