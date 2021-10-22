package 공유기설치_2110;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 공유기설치 {
    static int N, C;
    static int[] nums;
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\공유기설치_2110\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int max = 0;
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(r.readLine());
            max = Math.max(nums[i], max);
        }
        Arrays.sort(nums);

        System.out.println(solution(1, max) - 1);
    }

    private static int solution(int min, int max) {
        while (min < max) {
            int mid = min + (max - min) / 2;

            if (go(mid)) min = mid + 1;
            else max = mid;
        }
        return min;
    }

    private static boolean go(int mid) {
        int count = 1;
        int pre = nums[1];
        for (int i = 2; i <= N; i++) {
            int now = nums[i];
            if (now - pre >= mid) {
                count++;
                pre = now;
            }
        }

        return count >= C;
    }

}
