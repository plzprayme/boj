package 섬의개수_4963;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static InputReader r;
    static int W = -1, H = -1;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    private static void solution() throws IOException {

        while (W != 0 && H != 0) {
            r.readLine();
            W = r.nextInt();
            H = r.nextInt();
            visit = new boolean[H][W];
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                r.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = r.nextInt();
                }
            }

            int count = 0;
            for (int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    if (map[y][x] == 0 || visit[y][x]) continue;
                    // dfs(x, y);
                    bfs(x, y);
                    count++;
                }
            }
            System.out.println(count);

        }

    }

    private static void dfs(int x, int y) {
        visit[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isOut(nx, ny) || visit[ny][nx] || map[ny][nx] == 0) continue;
            dfs(nx, ny);
        }
    }

    private static void bfs(int x, int y) {
        Stack<XY> stack = new Stack<>();
        stack.add(new XY(x,y));
        visit[y][x] = true;

        while (!stack.isEmpty()) {
            XY now = stack.pop();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (isOut(nx, ny) || visit[ny][nx] || map[ny][nx] == 0) continue;
                visit[ny][nx] = true;
                stack.add(new XY(nx, ny));
            }
        }
    }

    private static class XY {
        int x, y;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x > W - 1 || y > H - 1;
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\섬의개수_4963\\input.txt");
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }

}

