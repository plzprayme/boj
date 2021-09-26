package 부분수열의합_1182;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 부분수열의합 {
    static int count, N, S;
    static int[] nums;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\부분수열의합_1182\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        rec(1, 0);

        if (S == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    static void rec(int n, int sum) {
        if (n == N + 1) {

            if (sum == S) {
                count++;
            }

        } else {
            rec(n + 1, sum + nums[n]);
            rec(n + 1, sum);
        }
    }
}

