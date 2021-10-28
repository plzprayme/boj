package 카드_11652;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 카드 {

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\카드_11652\\input.txt"));

        int N = Integer.parseInt(r.readLine());
        long[] nums = new long[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(r.readLine());
        }
        Arrays.sort(nums);

        long maxNum = nums[0];
        long maxCount = 1, count = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (maxCount < count) {
                maxNum = nums[i];
                maxCount = count;
            }

        }

        System.out.println(maxNum);
    }

}
