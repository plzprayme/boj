package N퀸_9663;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class N퀸 {
    static int N;
    static int[] map;
    static int count;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N퀸_9663\\input.txt"));

        N = Integer.parseInt(r.readLine());
        map = new int[N];
        Arrays.fill(map, -1);

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

                map[y] = x;
                rec(y + 1);
                map[y] = -1;
            }

        }
    }

    private static boolean isAttackable(int y, int x) {
        int l = y - x;
        int r = y + x;
        for (int _y = y; _y >= 0; _y--) {
            if (map[_y] == x) return true;
            if (_y - map[_y] == l) return true;
            if (_y + map[_y] == r) return true;
        }

        return false;
    }

}
