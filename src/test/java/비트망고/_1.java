package 비트망고;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class _1 {

    public int[][] solution(int n, boolean horiz) {


        // if (horiz) 수평 else 수직

        // 수평 또는 수직으로만 이동 가능

        // 로봇의 초기 위치는 1행 1열
        // 1. 맨 처음 어느 방향으로 움직일지 설정
        // 2. 가장 최근 설정한 방향으로 1칸 이동
        // 3. i = max(현재 행, 현재 열) 에 대해 1 ~ i행 x 1 ~i 열 중 청소되지 않은 부분을 로봇의 현재위치로부터 시작하여 일렬로 청소
        // 4. 로봇의 방향이 수평이면 수직으로, 수직이면 수평으로 변경
        // 5. 모든 칸이 청소되었으면 종료
        // 6. 청소 칸 남아있으면 2 반복

        int[][] answer = new int[n][n];
        answer[0][0] = 1;

        int up = -1;
        int left = 1;
        if (!horiz) {
            up = 1;
            left = -1;
        }

        // 중앙 값 채우기
        for (int y = 1; y < n; y++) {
            answer[y][y] = 2 * y + answer[y - 1][y - 1];

            for (int i = 1; i < y + 1; i++) {
                // true일 때
                // 위로 간다. y가 줄어든다.
                answer[y-i][y] = answer[y - i + 1][y] + up;
                answer[y][y-i] = answer[y][y - i + 1] + left;
            }
            up *= -1; left *= -1;
        }


        return answer;
    }

    @Test
    public void main() {
        solution(
            4, true
        );

        solution(
            5, false
        );
    }

}

