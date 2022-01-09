package 통계학_2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static int[] num;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        Arrays.sort(num);
        int sum = sum();
        int mid = num[N / 2];
        int common = common();
        int range = Math.abs(num[1]) + Math.abs(num[N]);

        System.out.printf("%d\n%d\n%d\n%d", sum / N, mid, common, range);
    }

    private static int common() {
        int[] counter = new int[8_001];

        for (int i = 1; i <= N; i++) {
            counter[num[i] + 4000] += 1;
        }

        int max = -1;
        int num = -1;

        for (int i = 0; i < 8001; i++) {
            if (counter[i] == max && num != i) {
                num = i;
                break;
            }

            if (counter[i] > max) {
                max = counter[i];
                num = i;
            }
        }

        return num - 4000;
    }

    private static int sum() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += i;
        }
        return sum;
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\통계학_2108\\input.txt");
        // 산술평균 N개의 수들의 합을 N으로 나눈 값
        // 중앙값 N개의 수들을 증가하는 순서로 나열 했을 경우 그 중앙에 위치하는 값
        // 최빈값 N개의 수들 중 가장 많이 나타나는 값
        // 범위: N개의 수들 중 최대값과 최솟값의 차이

        // N = 500_000

        N = r.nextInt();
        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = r.nextInt();
        }
        num[0] = -400_001;
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}

