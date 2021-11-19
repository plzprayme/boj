package 벽부수고이동하기4_16946;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int X, Y;
    static int[][] map;

    static int groupKey = 1;
    static int[][] group;

    static Map<Integer, Integer> groupMap = new HashMap<>();

    static int[][] dxy = {
        // x y
        {0, -1},
        {1, 0},
        {0, 1},
        {-1, 0}
    };

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {

                // 벽 건너뛰기
                if (group[y][x] > 0 || map[y][x] == -1) continue;

                int count = dfs(x, y); // 벽 아닌데 연속된 공간 세어놓기
                groupMap.put(groupKey, count);
                groupKey++;

            }
        }

        // 정답 구하기
        for (int y = 0; y < Y; y++) {
            for (int x = 0; x < X; x++) {
                if (map[y][x] == -1) sb.append(move(x, y));
                else sb.append(0);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int move(int x, int y) {
        Set<Integer> g = new HashSet<>();

        int count = 1;
        for (int[] xy : dxy) {
            int nx = x + xy[0];
            int ny = y + xy[1];
            if (isOut(nx, ny) || map[ny][nx] == -1 || g.contains(group[ny][nx])) continue;
            g.add(group[ny][nx]);
            count += groupMap.get(group[ny][nx]);
        }
        return count % 10;
    }

    private static int dfs(int x, int y) {
        if (group[y][x] > 0) return 0;
        group[y][x] = groupKey;

        int count = 0;
        for (int[] xy : dxy) {
            int nx = x + xy[0];
            int ny = y + xy[1];
            if (isOut(nx, ny) || group[ny][nx] > 0 || map[ny][nx] == -1) continue;
            count += dfs(nx, ny);
        }

        if (map[y][x] == 0) return count + 1;
        else return count;
    }

    private static boolean isOut(int x, int y) {
        return check(x, X) || check(y, Y);
    }

    private static boolean check(int p, int l) {
        return p < 0 || p > l - 1;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\벽부수고이동하기4_16946\\input.txt");
        Y = r.nextInt(); X = r.nextInt();
        map = new int[Y][X];
        group = new int[Y][X];

        for (int i = 0; i < Y; i++) {
            char[] arr = r.nextCharArr();
            for (int j = 0; j < X; j++) {
                if (arr[j] == '1') map[i][j] = -1;
                else map[i][j] = 0;
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

