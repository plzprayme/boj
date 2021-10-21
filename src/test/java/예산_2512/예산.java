package 예산_2512;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 예산 {
    static int[] nums;
    static int N;
    static int M;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\예산_2512\\input.txt"));

        N = Integer.parseInt(r.readLine());

        StringTokenizer st = new StringTokenizer(r.readLine());
        nums = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            max = Math.max(nums[i], max);
        }

        M = Integer.parseInt(r.readLine());


        int answer = solution(0, max);
        if (answer == max) System.out.println(answer);
        else System.out.println(answer - 1);
    }

    private static int solution(int min, int max) {
        while (min < max) {
            int mid = min + (max - min) / 2;
            int sum = sum(mid);
            if (sum > M) max = mid;
            else min = mid + 1;
        }
        return min;
    }

    private static int sum(int mid) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (nums[i] > mid) sum += mid;
            else sum += nums[i];
        }
        return sum;
    }

}
