package 피보나치수_10870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 피보나치수 {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\피보나치수_10870\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int answer = new Fibonacci(20).iteration(Integer.parseInt(r.readLine()));
        // int answer = new Fibonacci(20).recursion(Integer.parseInt(r.readLine()));
        w.write(String.valueOf(answer));
        w.newLine();
        w.flush();
    }

    private static class Fibonacci {
        int[] fibonacci;

        public Fibonacci(int depth) {
            this.fibonacci = new int[depth + 1];
            fibonacci[1] = 1;
        }

        private int iteration(int depth) {
            if (depth < 2) {
                return fibonacci[depth];
            }

            for (int i = 2; i <= depth; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
            return fibonacci[depth];
        }

        private int recursion(int depth) {
            if (depth < 2) {
                return depth;
            }

            return recursion(depth - 1) + recursion(depth - 2);
        }
    }
}
