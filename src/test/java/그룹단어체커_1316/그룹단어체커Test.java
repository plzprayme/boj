package 그룹단어체커_1316;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class 그룹단어체커Test {
    String[] e1 = {
        "happy", "new", "year"
    };

    String[] e2 = {
        "aba",
        "abab",
        "abcabc",
        "a"
    };

    @Test
    public void 예제() throws IOException {

        try (
            MyReader r = new MyReader();
            Answer answer = new Answer()
        ) {
            Line line = new Line();

            // int N = r.readN();
            // for (int i = 0; i < N; i++) {
                // line.validate(r.read());
            // }

            line.validate("happy");
            line.validate("new");
            line.validate("year");
            System.out.println(line.answer());

            answer.write(line.answer());
            answer.submit();
        }
    }

    private static class MyReader implements Closeable {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        public int readN() throws IOException {
            return parse(r.readLine());
        }

        private int parse(String s) {
            return Integer.parseInt(s);
        }

        public String read() throws IOException {
            return r.readLine();
        }

        @Override
        public void close() throws IOException {
            r.close();
        }
    }

    private static class Answer implements Closeable {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(int count) throws IOException {
            w.write(String.valueOf(count));
        }

        public void submit() throws IOException {
            w.flush();
        }

        @Override
        public void close() throws IOException {
            w.close();
        }
    }

    private static class Line {
        int count = 0;

        public int answer() {
            return count;
        }

        public void validate(String line) {
            Set<Character> characters = ridDuplicate(line);

            for (char c : characters) {
                int start = line.indexOf(c);
                int end = line.lastIndexOf(c);

                for (int i = start; i <= end; i++) {
                    if (line.charAt(i) != c)
                        return;
                }

            }

            count++;
        }

        private Set<Character> ridDuplicate(String line) {
            Set<Character> set = new HashSet<>();
            for (char c : line.toCharArray()) {
                set.add(c);
            }
            return set;
        }
    }

}
