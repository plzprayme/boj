package 로또_2758;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 로또 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\로또_2758\\input.txt"));

        int C = parse(r.readLine());
        for (int K = 0; K < C; K++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int N = parse(st.nextToken());
            int M = parse(st.nextToken());

            int[][] dp = new int[N+1][M+1];

            int weight = pow(N - 1);
            for (int i = 1; i * weight <= M; i++) {
                dp[1][i]++;
            }

            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= M; j++) {
                    int currentValue = dp[i][j];
                    int next = j * 2;
                    if (currentValue > 0 && next <= M) {
                        for (int k = next; k * pow(N - i - 1) <= M; k++) {
                            dp[i+1][k] += currentValue;
                        }
                    }
                }
            }
            int sum = 0;
            for (int i = M / 2; i <= M; i++) {
                sum += dp[N][i];
            }
            System.out.println(sum);

        }

    }

    private static int pow(int N) {
        return (int)Math.pow(2, N);
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static class State {
        int num;
        int N;

        public State(int num, int n) {
            this.num = num;
            N = n;
        }

        public int nextNumber() {
            return num * 2;
            // return numbers.peek() * 2;
        }

        public State get(int next) {
            num = next;
            return new State(num, N - 1);
        }

        @Override
        public String toString() {
            return "State{" +
                "num=" + num +
                ", N=" + N +
                '}';
        }
    }
}
