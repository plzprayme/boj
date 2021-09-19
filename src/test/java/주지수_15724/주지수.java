package 주지수_15724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class 주지수 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\주지수_15724\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int Y = parse(st.nextToken());
        int X = parse(st.nextToken());
        int[][] map = new int[Y + 1][X + 1];
        for (int y = 1; y <= Y; y++) {
            st = new StringTokenizer(r.readLine());
            for (int x = 1; x <= X; x++) {
                map[y][x] = map[y - 1][x] + map[y][x - 1] - map[y - 1][x - 1] + parse(st.nextToken());
            }
        }

        int N = parse(r.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            int y1 = parse(st.nextToken());
            int x1 = parse(st.nextToken());
            int y2 = parse(st.nextToken());
            int x2 = parse(st.nextToken());

            System.out.println(map[y2][x2] - (map[y2][x1-1] + map[y1-1][x2]) + map[y1-1][x1-1]);
        }

    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
