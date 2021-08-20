package 내리막길_1520;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 내리막길 {
    static int Y;
    static int X;

    static int[][] map;
    static int[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\내리막길_1520\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        Y = parse(st.nextToken());
        X = parse(st.nextToken());

        map = new int[Y + 1][X + 1];
        for (int y = 1; y <= Y; y++) {
            st = new StringTokenizer(r.readLine());
            for (int x = 1; x <= X; x++) {
                map[y][x] = parse(st.nextToken());
            }
        }

        visited = new int[Y + 1][X + 1];

        System.out.println(dfs(1, 1));
    }

    // 참고 https://wootool.tistory.com/83
    private static int dfs(int y, int x) {
        if (x == X && y == Y) return 1;
        if (visited[y][x] > 0) return visited[y][x];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 < nx && nx <= X && 0 < ny && ny <= Y && map[y][x] > map[ny][nx]) {
                visited[y][x] += dfs(ny, nx);
            }
        }

        return visited[y][x];
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
