package 기타레슨_2343;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 기타레슨 {
    static int N, M;
    static int[] nums;

    @Test
    public static void main(String[] args) throws IOException {

        input();
        solution();

    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\기타레슨_2343\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solution() {
        int min = 0; int max = 10_000 * 100_000;
        for (int i : nums) min = Math.max(min, i);

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (validate(mid)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min);
    }

    private static boolean validate(int mid) {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (sum + nums[i] > mid) {
                sum = nums[i];
                count++;
            } else {
                sum += nums[i];
            }
        }

        return count >= M;
    }

}
