package 두용액_2470;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 두용액 {

    static int min = Integer.MAX_VALUE;
    static int[] answer = new int[2];

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\두용액_2470\\input.txt"));

        int N = Integer.parseInt(r.readLine());
        int[] nums = new int[N + 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, 1, N);

        go(nums, 1, N);

        System.out.printf("%d %d", answer[0], answer[1]);
    }

    private static void go(int[] A, int L, int R) {
        while (L < R) {

            int num = Math.abs(A[L] + A[R]);
            if (num < min) {
                min = num;
                answer[0] = A[L];
                answer[1] = A[R];
            }

            if (A[L] + A[R] > 0) R--;
            else if (A[L] + A[R] < 0) L++;
            else break;
        }

    }

    // private static void bSearch(int[] A,int L, int R, int X) {
    //     int M = 0;
    //     while (L <= R) {
    //         M = L + (R - L) / 2;
    //         if (A[M] + X > 0) R = M - 1;
    //         else if (A[M] + X < 0) L = M + 1;
    //         else break;
    //     }
    // }
}
