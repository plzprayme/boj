package A더하기B8_11022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class A더하기B11022TEST {
    @Test
    public void 예제() throws Exception {

        try (
            MyReader reader = new MyReader();
            Answer answer = new Answer()
        ) {
            int N = reader.readN();
            for (int i = 1; i <= N; i++) {
                Line line = new Line(i, reader.readLine());
                answer.write(line);
            }
            answer.submit();
        }
    }

    private static class MyReader implements Closeable {
        private final BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\A더하기B_8\\case1.txt"));
        // private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        private MyReader() throws FileNotFoundException {
        }

        public int readN() throws Exception {
            return parse(br.readLine());
        }

        public String readLine() throws Exception {
            return br.readLine();
        }

        private int parse(String N) {
            return Integer.parseInt(N);
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }

    private static class Line {
        private final int index;
        private final int first;
        private final int second;

        public Line(int index, String line) {
            this(index, new StringTokenizer(line));
        }

        private Line(int index, StringTokenizer st) {
            this(index, parse(st.nextToken()), parse(st.nextToken()));
        }

        private Line(int index, int first, int second) {
            this.index = index;
            this.first = first;
            this.second = second;
        }

        private static int parse(String s) {
            return Integer.parseInt(s);
        }

        public String read() {
            return String.format("Case %d: %d + %d = %d\n", index, first, second, first + second);
        }
    }

    private static class Answer implements Closeable {
        private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(Line line) throws Exception {
            bw.write(line.read());
        }

        public void submit() throws Exception {
            bw.flush();
        }

        @Override
        public void close() throws IOException {
            bw.close();
        }
    }

}
