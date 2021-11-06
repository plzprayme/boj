package uteco;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class _5 {
    @Test
    public void main() {
        // solution(
        //     3, 4
        // );

        solution(
            3, 3
        );
    }

    static int[][] answer;

    public int[][] solution(int rows, int columns) {
        answer = new int[rows][columns];
        int zeroCount = rows * columns;

        run(rows, columns, zeroCount);

        return answer;
    }

    private void run(int rows, int columns, int zeroCount) {
        int y = 0;
        int x = 0;
        int lastNum = 0;
        while (zeroCount > 0) {
            int now = answer[y][x];

            if (isOdd(now) && !isOdd(lastNum)) {
                break;
            }

            if (isZero(now)) {
                zeroCount--;
            }

            answer[y][x] = ++lastNum;

            if (isOdd(lastNum)) {
                x = getNext(x, columns);
            } else {
                y = getNext(y, rows);
            }

        }
    }

    private int getNext(int i, int limit) {
        int nx = i + 1;
        if (nx >= limit) {
            return 0;
        }
        return nx;
    }

    private boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private boolean isZero(int i) {
        return i == 0;
    }

}
