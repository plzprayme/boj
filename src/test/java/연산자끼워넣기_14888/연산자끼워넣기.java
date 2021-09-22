package 연산자끼워넣기_14888;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 연산자끼워넣기 {
    static int N;
    static int[] nums;
    static int[] operations;
    static int[] selected;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\연산자끼워넣기_14888\\input.txt"));

        N = parse(r.readLine());
        nums = new int[N];
        operations = new int[N - 1];
        selected = new int[N - 1];
        visited = new boolean[N - 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = parse(st.nextToken());
        }

        int count = 0;
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < 4; i++) {
            int tmp = parse(st.nextToken());
            for (int j = 1; j <= tmp; j++) {
                operations[count++] = i;
            }
        }


        rec(0);

        System.out.println(max);
        System.out.println(min);
    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }

    static void rec(int o) {
        if (o == N - 1) {
            int left = nums[0];
            for (int i = 0; i < N - 1; i++) {
                left = go(left, nums[i + 1], selected[i]);
            }

            max = Math.max(max, left);
            min = Math.min(min, left);
        } else {
            for (int i = 0; i < N - 1; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    selected[o] = operations[i];
                    rec( o + 1);
                    visited[i] = false;
                }
            }
        }
    }
    static int go(int left, int right, int op) {
        int sum = 0;
        switch (op) {
            case 0: sum = left + right; break;
            case 1: sum = left - right; break;
            case 2: sum = left * right; break;
            case 3: sum = left / right; break;
        }
        return sum;
    }
}
