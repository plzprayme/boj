package 거스름돈_14916;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {

        // 2원짜리와 5원짜리로만 거스름돈

        // 동전의 개수가 최소가 되도록 거슬러 준다.

        // 거스름돈이 n인 경우 최소 동전의 개수가 몇개?

        // 액수가 100_000


        if (N == 1 || N == 3) {
            System.out.println(-1);
            return;
        }

        if (N == 2 || N == 4) {
            System.out.println(N / 2);
            return;
        }




        // five의 최대값 = N / 5;
        // two = (N % 5) / 2
        // remain = N % 2;
        int five = N / 5;
        int remain = N % 5;
        int two = remain / 2;
        remain %= 2;
        if (remain == 0) {
            System.out.println(five + two);
            return;
        }

        while (five > 0) {
            five -= 1;
            remain = N - five * 5;
            two = remain / 2;
            remain %= 2;
            if (remain == 0) {
                System.out.println(five + two);
                return;
            }
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader();

        N = r.nextInt();
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
