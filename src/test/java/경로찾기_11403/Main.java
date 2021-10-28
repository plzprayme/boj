package 경로찾기_11403;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\경로찾기_11403\\input.txt"));
        StringBuilder sb = new StringBuilder();

        int N = parse(r.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            for (int j = 0; j < N; j++) {
                 map[i][j] = parse(st.nextToken());
            }
        }

        for (int mid = 0; mid < N; mid++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if (map[start][mid] + map[mid][end] < map[start][end]) {
                        map[start][end] = map[start][mid] + map[mid][end];
                        System.out.printf("%d %d %d\n", mid, start, end);
                        // System.out.println(map[start][end]);
                    }
                }
            }
        }

        System.out.println("");

    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }
}
