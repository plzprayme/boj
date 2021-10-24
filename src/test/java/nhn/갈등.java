package nhn;

import org.junit.jupiter.api.Test;
import java.util.*;

public class 갈등 {

    @Test
    public static void main() {

    }

    static int count = 0;
    static int[] selected = new int[9];
    static boolean[] dp = new boolean[9];
    static List[] cfList = new List[9];

    private static void solution(int numOfConflict, int[][] conflicts) {
        for (int i = 0; i < 9; i++) cfList[i] = new ArrayList<Integer>();

        for (int[] arr : conflicts) {
            cfList[arr[0]].add(arr[1]);
            cfList[arr[1]].add(arr[0]);
        }

        backTracking(1);
        System.out.println(count);
    }

    private static void backTracking(int N) {
        if (N == 9) {
            count++;
        } else {

            for (int i = 1; i < 9; i++) {

                if (dp[i] || cfList[i].contains(selected[N - 1])) continue;
                selected[N] = i;
                dp[i] = true;
                backTracking(N + 1);
                dp[i] = false;
                selected[N] = 0;

            }

        }
    }
}
