package 게임_1072;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static long X, Y, Z;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        Z = getPercent(X, Y);
        System.out.println(binarySearch());
    }

    static int binarySearch() {

        int left = 1;
        int right = 1_000_000_000;
        int answer = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int percent = getPercent(X + mid, Y + mid);

            if (Z < percent) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static int getPercent(long x, long y) {
        return (int) ((long) y * 100 / x);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        X = r.nextInt(); Y = r.nextInt();
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