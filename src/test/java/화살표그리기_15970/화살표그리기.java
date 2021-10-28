package 화살표그리기_15970;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 화살표그리기 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\화살표그리기_15970\\input.txt"));

        int N = Integer.parseInt(r.readLine());
        P[] xs = new P[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());

            int x = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            xs[i] = new P(x, color);
        }

        Arrays.sort(xs);

        long answer = 0;
        answer += xs[1].x - xs[0].x;
        answer += xs[N - 1].x - xs[N - 2].x;

        for (int i = 1; i < N - 1; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            if (xs[i].color == xs[i-1].color) left = xs[i].x - xs[i-1].x;
            if (xs[i].color == xs[i+1].color) right = xs[i+1].x - xs[i].x;
            answer += Math.min(left, right);
        }

        System.out.println(answer);
    }

    static class P implements Comparable<P> {
        int x, color;

        public P(int x, int color) {
            this.x = x;
            this.color = color;
        }

        @Override
        public int compareTo(P o) {
            if (color != o.color) return color - o.color;
            return x - o.x;
        }
    }
}
