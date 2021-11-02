package 수열_2559;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static int N, K;
    static int[] nums;

    private static void solution() {
        int l = 1, r = 1, max = 0;

        int sum = 0;
        while (r - l + 1 < K) {
            sum += nums[r];
            r++;
        }


        System.out.println(sum);
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수열_2559\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}

