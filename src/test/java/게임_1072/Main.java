package 게임_1072;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static long X, Y;
    static long origin;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        int divided = getPercent(X, Y);

        // 99퍼, 100퍼일 때는 증가할 수가 없다.
        if (divided == 99 || divided == 100) {
            System.out.println(-1);
            return;
        }

        int newDivided = divided;

        int i = 100_000_000;
        while (newDivided == divided) {
            Y += i;
            X += i;
            newDivided = getPercent(X, Y);
        }

        while (newDivided != divided) {
            Y -= 1;
            X -= 1;
            newDivided = getPercent(X, Y);
        }

        System.out.println(X - origin + 1);
    }

    static int getPercent(long x, long y) {
        return (int) ((long) y * 100 / x);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        X = r.nextInt(); Y = r.nextInt();
        origin = X;
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