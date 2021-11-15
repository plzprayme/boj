package 연구소_14502;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int X, Y, answer = Integer.MIN_VALUE;
    static int[][] map;
    static int[][] clone;
    static List<int[]> list = new ArrayList<>();

    static int[][] dxy = {
        // x y
        {0, -1},
        {1, 0},
        {0, 1},
        {-1, 0}
    };

    private static void solution() {
        // 벽 세개 결정하기..
        backtracking(0, 0);
        System.out.println(answer);
    }

    private static void backtracking(int N, int startY) {
        if (N == 3) {
            clone = cloneArr();
            for (int[] coor : list) {
                // dfs(coor[0], coor[1]);
                bfs(coor[0], coor[1]);
            }
            int count = count();
            answer = Math.max(answer, count);
        } else {
            for (int y = startY; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    if (map[y][x] != 0) continue;
                    map[y][x] = 1;
                    backtracking(N + 1, y);
                    map[y][x] = 0;
                }
            }
        }
    }

    private static int[][] cloneArr() {
        int[][] arr = new int[Y][X];
        for (int y = 0; y< Y; y++) {
            arr[y] = map[y].clone();
        }
        return arr;
    }

    private static int count() {
        int count = 0;
        for (int[] row : clone) {
            for (int col : row) {
                if (col == 0) count++;
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        for (int[] xy : dxy) {
            int nx = x + xy[0];
            int ny = y + xy[1];

            if (isOut(nx, ny) || clone[ny][nx] != 0) continue;
            clone[ny][nx] = 2;
            dfs(nx, ny);
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});


        while(!q.isEmpty()) {
            int[] now = q.poll();

            for (int[] xy : dxy) {
                int nx = now[0] + xy[0];
                int ny = now[1] + xy[1];
                if (isOut(nx, ny) || clone[ny][nx] != 0) continue;
                q.add(new int[]{nx, ny});
                clone[ny][nx] = 2;
            }
        }
    }

    private static boolean isOut(int x, int y) {
        return check(x, X) || check(y, Y);
    }

    private static boolean check(int p, int l) {
        return p < 0 || p > l - 1;
    }

    private static class Coordinate{
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\연구소_14502\\input.txt");
        Y = r.nextInt(); X = r.nextInt();
        map = new int[Y][X];

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                map[y][x] = r.nextInt();
                if (map[y][x] == 2) {
                    list.add(new int[] { x, y });
                    // list.add(new Coordinate(x, y));
                }
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

