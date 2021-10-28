package 수도배관공사_2073;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int D, P;
    static Pipe[] pipes;
    static long[] dp;

    private static void solution() {
        System.out.println(dp[D]);
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수도배관공사_2073\\input.txt"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        D = Integer.parseInt(st.nextToken()); P = Integer.parseInt(st.nextToken());
        dp = new long[D + 1];
        dp[0] = Integer.MAX_VALUE;

        pipes = new Pipe[P];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(r.readLine());

            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 여기가 솔루션
            for (int j = D; j >= l; j--) {
                dp[j] = Math.max(dp[j], Math.min(c, dp[j - l]));
            }
        }
    }

    private static class Pipe implements Comparable<Pipe> {
        Integer l, c;

        public Pipe(int l, int c) {
            this.l = l;
            this.c = c;
        }

        @Override
        public int compareTo(Pipe o) {
            return l.compareTo(o.l);
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}

