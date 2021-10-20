package 랜선자르기_1654;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 랜선자르기 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\나무자르기_1654\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long min = 0;
        long max = 0;
        int[] lines = new int[K + 1];
        for (int i = 1; i <= K; i++) {
            lines[i] = Integer.parseInt(r.readLine());
            max = Math.max(lines[i], max);
        }

        min = bSearch(K, N, min, max + 1, lines);

        System.out.println(min - 1);

    }

    private static long bSearch(int K, int N, long min, long max, int[] lines) {
        while (min < max) {
            long mid = min + (max - min) / 2;

            long sum = sum(K, lines, mid);

            if (sum < N) max = mid;
            else min = mid + 1;
        }
        return min;
    }

    private static long sum(int K, int[] lines, long mid) {
        long sum = 0;
        for (int i = 1; i <= K; i++) sum += lines[i] / mid;
        return sum;
    }
}
