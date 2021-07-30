package 피보나치함수_1003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class 피보나치함수 {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\피보나치함수_1003\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Integer, Count> counts = new HashMap<>();
        counts.put(0, new Count(1, 0));

        for (int i = 1; i <= 40; i++) {
            counts.put(i, counts.get(i - 1).next());
        }

        int N = Integer.parseInt(r.readLine());
        for (int i = 0; i < N; i++) {
            w.write(counts.get(Integer.parseInt(r.readLine())).get());
        }
        w.flush();
    }

    private static class Count {
        int zero;
        int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count next() {
            return new Count(one, zero + one);
        }

        public String get() {
            return String.format("%d %d\n", zero, one);
        }
    }

}
