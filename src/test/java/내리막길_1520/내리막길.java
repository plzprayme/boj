package 내리막길_1520;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
        BufferedWriter w  =new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(r.readLine());
        Y = parse(st.nextToken());
        X = parse(st.nextToken());

        visited = new int[Y+1][X+1];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

        map = new int[Y+1][X+1];
        for (int y = 1; y <= Y; y++) {
            st = new StringTokenizer(r.readLine());
            for (int x = 1; x <= X; x++) {
                map[y][x] = parse(st.nextToken());
            }
        }

        w.write(String.valueOf(dfs(1,1)));
        w.flush();
    }

    private static int dfs(int x, int y) {
        if (x == X && y == Y) return 1;
        else if (visited[y][x] >= 0) return visited[y][x];

        // -1: 안와봤다 0: 와봤다
        visited[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 < nx && nx <= X && 0 < ny && ny <= Y && map[y][x] > map[ny][nx]) {
                visited[y][x] += dfs(nx, ny);
            }

        }

        return visited[y][x];
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
