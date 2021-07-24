package 소수구하기_1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 소수구하기Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\소수구하기_1929\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] xy = r.readLine().split(" ");
        int x = parse(xy[0]);
        int y = parse(xy[1]);

        w.write(new Prime(y).sieveOfEratosthenes().allUpFromTo(x, y));
        w.flush();
    }

    private class Prime {
        boolean[] isNotPrime;

        public Prime(int N) {
            this.isNotPrime = new boolean[N+1];
            isNotPrime[1] = true;
        }

        private Prime sieveOfEratosthenes() {
            int N = isNotPrime.length - 1;
            for (int i = 2; i <= N; i++) {
                if (isNotPrime[i]) continue;

                for (int j = i * 2; j <= N; j = j + i) {
                    isNotPrime[j] = true;
                }
            }
            return this;
        }

        public String allUpFromTo(int from, int to) {
            StringBuilder sb = new StringBuilder();

            for (int i = from; i <= to; i++) {
                if (!isNotPrime[i]) sb.append(String.format("%d\n", i));
            }

            return sb.toString();
        }
    }

    private int parse(String s) {
        return Integer.parseInt(s);
    }
}
