package 나무자르기_2805;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\나무자르기_2805\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        int[] trees = new int[N + 1];
        int min = 0;
        int max = 0;
        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(trees[i], max);
        }
        Arrays.sort(trees, 1, N + 1);

        min = bSearch(N, M, trees, min, max);
        System.out.println(min - 1);

    }

    private static int bSearch(int N, int M, int[] trees, int min, int max) {
        while (min < max) {
            int mid = min + (max - min) / 2;

            long sum = sum(N, trees, mid);

            if (sum < M) max = mid - 1;
            else min = mid + 1;
        }
        return min;
    }

    private static long sum(int N, int[] trees, int mid) {
        long sum = 0;
        for (int i = N; i >= 0; i--) {
            if (trees[i] - mid <= 0) break;
            sum += trees[i] - mid;
        }
        return sum;
    }

}
