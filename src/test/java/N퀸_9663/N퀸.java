package N퀸_9663;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class N퀸 {
    static int N;
    static boolean[][] map;
    static int count;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N퀸_9663\\input.txt"));

        N = Integer.parseInt(r.readLine());
        map = new boolean[N][N];

        rec(0);

        System.out.println(count);

    }

    static void rec(int y) {
        if (y == N - 1) {

            for (int x = 0; x < N; x++) {
                if (isAttackable(y, x)) continue;
                count++;
            }

        } else {

            for (int x = 0; x < N; x++) {
                if (isAttackable(y, x)) continue;

                map[y][x] = true;
                rec(y + 1);
                map[y][x] = false;
            }

        }
    }

    private static boolean isAttackable(int y, int x) {
        int _y = y - 1;
        int _lx = x - 1;
        int _rx = x + 1;
        while (0 <= _y) {
            if (map[_y][x]) return true;
            if (_lx >= 0 && map[_y][_lx]) return true;
            if (_rx < N && map[_y][_rx]) return true;

            _y--; _lx--; _rx++;
        }

        return false;
    }

}
