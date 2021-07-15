package 부녀회장이될테야_2775;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 부녀회장이될테야_2775 {
    @Test
    public void 예제() {
        int k = 1;
        int n = 3;

        int[][] apt = new int[15][15];
        for (int i = 1; i <= n; i++) {
            apt[0][i] = i;
        }

        for (int floor = 1; floor <= 14; floor++) {
            for (int house = 1; house <= 14; house++) {
                if (house == 1) {
                    apt[floor][house] = house;
                    continue;
                }

                apt[floor][house] = apt[floor][house-1] + apt[floor-1][house];
            }
        }

        System.out.printf("%d\n", apt[k][n]);
    }

    private static int MAX = 15;

    private int[][] solution() {
        int[][] apt = new int[MAX][MAX];
        for (int i = 1; i < MAX; i++) apt[0][i] = i;

        for (int floor = 1; floor < MAX; floor++) {
            for (int house = 1; house < MAX; house++) {
                if (house == 1) {
                    apt[floor][house] = house;
                    continue;
                }

                apt[floor][house] = apt[floor][house-1] + apt[floor-1][house];
            }
        }

        return apt;
    }


    @Test
    public void 예제2() {
        int k = 2;
        int n = 3;

        int[][] apt = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            apt[0][i] = i;
        }

        for (int floor = 1; floor <= k; floor++) {
            for (int house = 1; house <= n; house++) {
                if (house == 1) {
                    apt[floor][house] = house;
                    continue;
                }

                apt[floor][house] = apt[floor][house-1] + apt[floor-1][house];
            }
        }

        System.out.printf("%d\n", apt[k][n]);
    }
}
