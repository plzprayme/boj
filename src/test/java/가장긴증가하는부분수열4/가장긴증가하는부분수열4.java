package 가장긴증가하는부분수열4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class 가장긴증가하는부분수열4 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\가장긴증가하는부분수열4\\input.txt"));

        int N = parse(r.readLine()) + 1;
        StringTokenizer st = new StringTokenizer(r.readLine());

        int[] nums = new int[N];
        for (int i = 1; i < N; i++) {
            nums[i] = parse(st.nextToken());
        }

        int[] dp = new int[N];
        for (int y = 1; y < N; y++) {
            dp[y] = 1;
            for (int x = 1; x < y; x++) {
                if (nums[y] > nums[x]) dp[y] = Math.max(dp[y], dp[x] + 1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        int max = max(dp);
        System.out.println(max);
        for (int x = N - 1; x > 0; x--) {
            if (dp[x] == max) {
                answer.add(nums[x]);
                max--;
            }
        }
        Collections.reverse(answer);
        System.out.println(answer.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static int max(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }
}
