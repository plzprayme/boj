package 용돈관리_6236;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class 용돈관리 {
    static int N, M;
    static int[] money;
    static int min;

    private static void solution(int min, int max) {

        while (min < max) {
            int mid = min + (max - min) / 2;

            if (validate(mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min);
    }

    private static boolean validate(int mid) {
        int count = 1, sum = 0;

        for (int i : money) {
            if (sum + i > mid) {
                count++;
                sum = i;
            } else {
                sum += i;
            }
        }

        return count <= M;
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\용돈관리_6236\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        money = new int[N + 1];

        min = 0;
        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(r.readLine());
            min = Math.max(min, money[i]);
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution(min, 100_000 * 10_000);
    }

}

