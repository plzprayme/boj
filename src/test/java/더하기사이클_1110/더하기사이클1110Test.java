package 더하기사이클_1110;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 더하기사이클1110Test {
    @Test
    public void 예제() throws Exception {

        try (
            MyReader reader = new MyReader();
            Answer answer = new Answer();
        ) {
            // int N = reader.read();
            // Line sum = new Line(N);
            Line sum = new Line(26);

            do {
                sum.cycle();
            } while (!sum.isEquals());

            answer.submit(sum);
        }


    }

    private static class MyReader implements Closeable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public int read() throws Exception {
            return parse(br.readLine());
        }

        private int parse(String s) {
            return Integer.parseInt(s);
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }

    private static class Answer implements Closeable {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public void submit(Line line) throws Exception {
            bw.write(line.read());
            bw.flush();
        }

        @Override
        public void close() throws IOException {
            bw.close();
        }
    }

    private static class Line {
        int count;
        int sum;
        final int N;

        public Line(int N) {
            this.count = 0;
            this.sum = N;
            this.N = N;
        }

        public void cycle() {
            int ten = this.sum / 10;
            int one = this.sum % 10;
            int sum = ten + one;
            this.sum = one * 10 + sum % 10;
            this.count++;
        }

        public boolean isEquals() {
            return sum == N;
        }

        public String read() {
            return String.valueOf(count);
        }
    }
}
