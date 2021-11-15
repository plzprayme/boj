package 토마토_7569;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int X, Y, Z;
    static int[][][] map;
    static Queue<Position> queue = new LinkedList<>();

    static int[][] d = {
        // z x y
        {1, 0, 0}, // 윗층
        {-1, 0, 0}, // 아랫층
        {0, 0, 1}, // 위
        {0, 1, 0}, // 오른쪽
        {0, 0, -1}, // 아래
        {0, -1, 0} // 왼쪽
    };

    private static class Position {
        int x, y, z;

        public Position(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static void solution() {
        System.out.println(bfs());
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int[] nd : d) {
                int nz = now.z + nd[0];
                int nx = now.x + nd[1];
                int ny = now.y + nd[2];

                if (isOut(nx, ny, nz) || map[nz][ny][nx] != 0) continue;
                map[nz][ny][nx] = map[now.z][now.y][now.x] + 1;
                queue.add(new Position(nx, ny, nz));
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int[][] floor : map) {
            for (int[] row : floor) {
                for (int col : row) {
                    if (col == 0) return -1;
                    answer = Math.max(answer, col);
                }
            }
        }

        if (answer == 1) return 0;
        return answer - 1;

    }

    private static boolean isOut(int nx, int ny, int nz) {
        return check(nx, X) || check(ny, Y) || check(nz, Z);
    }

    private static boolean check(int p, int l) {
        return p < 0 || p >= l;
    }



    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\토마토_7569\\input.txt");
        X = r.nextInt(); Y = r.nextInt(); Z = r.nextInt();
        map = new int[Z][Y][X];
        for (int z = 0; z < Z; z++) {
            for (int y = 0; y < Y; y++) {
                for (int x = 0; x < X; x++) {
                    map[z][y][x] = r.nextInt();
                    if (map[z][y][x] == 1) queue.add(new Position(x, y, z));
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

