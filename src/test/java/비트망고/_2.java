package 비트망고;

import org.junit.jupiter.api.Test;

public class _2 {
    public int solution(int[][] circles) {
        int answer = -1;

        // x, y, r

        // 2개의 원을 선택 시 한 원이 다른 원에 포함되어 있어야 한다.

        int l = circles.length;
        for (int i = 0; i < l; i++) {
            int count = 1;
            for (int j = 0; j < l; j++) {
                if (i == j) continue;
                int ix = circles[i][0];
                int iy = circles[i][1];
                int ir = circles[i][2];

                int jx = circles[j][0];
                int jy = circles[j][1];
                int jr = circles[j][2];

                long d = (long) Math.sqrt(
                    Math.pow(ix - jx, 2) + Math.pow(iy - jy, 2)
                );

                if (ir - jr >= d) count++;

            }
            answer = Math.max(answer , count);
        }

        return answer;
    }

    @Test
    public void main() {
        int[][] case1 = {
            {-4, 0, 6},
            {-4, 0, 2},
            {-4, 0, 4},
            {2, 0, 8},
        };
        System.out.println(
            solution(case1)
        );

        int[][] case2 = {
            {1, 0, 2},
            {-1, 0, 2},
        };
        System.out.println(
            solution(case2)
        );
    }
}
