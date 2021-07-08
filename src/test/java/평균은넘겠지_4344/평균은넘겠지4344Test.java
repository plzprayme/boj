package 평균은넘겠지_4344;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 평균은넘겠지4344Test {
    @Test
    public void 예제() throws Exception {
        try (
            MyReader r = new MyReader();
            Answer answer = new Answer();
            ) {
            // int N = r.readN();
            int N = 5;
            String[] input = new String[] {
                "5 50 50 70 80 100",
                "7 100 95 90 80 70 60 50",
                "3 70 90 80",
                "3 70 90 81",
                "9 100 99 98 97 96 95 94 93 91"
            };
            for (int i = 0; i < N; i++) {
                // Line line = new Line(r.read());
                Line line = new Line(input[i]);
                answer.write(line);
            }
            answer.submit();
        } catch (Exception e) {

        }

    }

    private static class MyReader implements Closeable {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        public int readN() throws Exception {
            return parse(r.readLine());
        }

        private int parse(String s) {
            return Integer.parseInt(s);
        }

        public String read() throws Exception {
            return r.readLine();
        }

        @Override
        public void close() throws IOException {
            r.close();
        }
    }

    private static class Answer implements Closeable {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(Line line) throws Exception {
            w.write(line.read());
            w.newLine();
        }

        public void submit() throws Exception {
            w.flush();
        }

        @Override
        public void close() throws IOException {
            w.close();
        }
    }

    private static class Line {
        int N;
        int[] scores;
        int average;

        public Line(String s) {
            this(new StringTokenizer(s));
        }

        private Line(StringTokenizer st) {
            this.N = parse(st.nextToken());
            this.scores = scores(st);
            this.average = average();
        }

        private int average() {
            return average = sum() / N;
        }

        private int parse(String s) {
            return Integer.parseInt(s);
        }

        private int[] scores(StringTokenizer st) {
            int[] scores = new int[N];
            for (int i = 0; i < N; i++) {
                scores[i] = parse(st.nextToken());
            }
            return scores;
        }

        private int sum() {
            int sum = 0;
            for (int i : this.scores) {
                sum += i;
            }
            return sum;
        }

        public String read() {
            float answer = count() / (float) N;
            return String.format("%.3f%%", answer * 100);
        }

        private int count() {
            int count = 0;
            for (int score : this.scores) {
                if (score > average) count++;
            }
            return count;
        }
    }
}
