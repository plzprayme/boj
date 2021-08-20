package 내리막길_1520;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 내리막길 {
    private static int M;
    private static int N;
    private static int count = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int[][] map;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\내리막길_1520\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        M = parse(st.nextToken());
        N = parse(st.nextToken());

        map = new int[M][N];
        for (int y = 0; y < M; y++) {
            st = new StringTokenizer(r.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = parse(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[M][N];
        dfs(0, 1, visited.clone()); // 오른쪽
        dfs(1, 0, visited.clone()); // 아래

        System.out.println(count);
    }

    private static void dfs(int y, int x, boolean[][] visited) {
        visited[y][x] = true;
        if (x == N - 1 && y == M - 1) { count++; return; }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ( ny < 0 || nx < 0 || ny >= M || nx >= N || visited[ny][nx]) continue;
            if (map[y][x] > map[ny][nx]) {
                dfs(ny, nx, visited.clone());
            }

        }
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
