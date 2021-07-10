package 다이얼_5622;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class 다이얼Test {
    @Test
    public void 예제() throws Exception {
        try (
            MyReader r = new MyReader();
            Answer answer = new Answer()
        ) {

            Line line = new Line();
            answer.write(line.calculate(r.read()));
            answer.submit();
        }
    }

    private static class MyReader implements Closeable {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        public String read() throws IOException {
            return r.readLine();
        }

        @Override
        public void close() throws IOException {
            r.close();
        }
    }

    private static class Line {
        Map<Character, Integer> dial = new HashMap<>();

        public Line() {
            dial.put('A', 3);
            dial.put('B', 3);
            dial.put('C', 3);
            dial.put('D', 4);
            dial.put('E', 4);
            dial.put('F', 4);
            dial.put('G', 5);
            dial.put('H', 5);
            dial.put('I', 5);
            dial.put('J', 6);
            dial.put('K', 6);
            dial.put('L', 6);
            dial.put('M', 7);
            dial.put('N', 7);
            dial.put('O', 7);
            dial.put('P', 8);
            dial.put('Q', 8);
            dial.put('R', 8);
            dial.put('S', 8);
            dial.put('T', 9);
            dial.put('U', 9);
            dial.put('V', 9);
            dial.put('W', 10);
            dial.put('X', 10);
            dial.put('Y', 10);
            dial.put('Z', 10);
        }

        public int read(String line) {
            return calculate(line);
        }

        private int calculate(String s) {
            int answer = 0;
            for (char c : s.toCharArray()) {
                answer += dial.get(c);
            }
            return answer;
        }
    }

    private static class Answer implements Closeable {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(int answer) throws IOException {
            w.write(String.valueOf(answer));
        }

        public void submit() throws IOException {
            w.flush();
        }

        @Override
        public void close() throws IOException {
            w.close();
        }
    }

}
