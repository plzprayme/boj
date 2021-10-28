package 두수의합_3273;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 두수의합 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\두수의합_3273\\input.txt"));

        int N = Integer.parseInt(r.readLine());
        StringTokenizer st = new StringTokenizer(r.readLine());
        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        int X = Integer.parseInt(r.readLine());

        int count = 0;
        for (int i = 1; i <= N; i++) count += bSearch(nums, i + 1, N, X - nums[i]);
        System.out.println(count);
    }

    static int bSearch(int[] A, int L, int R, int X) {
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (X > A[M]) L = M + 1;
            else if (X < A[M]) R = M - 1;
            else return 1;
        }
        return 0;
    }
}
