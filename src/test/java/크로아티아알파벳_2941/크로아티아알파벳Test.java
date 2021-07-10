package 크로아티아알파벳_2941;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class 크로아티아알파벳Test {
    @Test
    public void 예제() throws Exception {

        try(
            MyReader r = new MyReader();
            Answer answer = new Answer()
            ) {
            Line line = new Line(r.read());
            answer.write(line.read());
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
        String alphabetStub;
        String[] a = {
            "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="
        };

        public Line(String line) {
            this.alphabetStub = line;
        }

        public int read() {
            int cnt = 0;

            for (String b : a) {

                while (alphabetStub.contains(b)) {
                    alphabetStub = alphabetStub.replaceFirst(b, "X");
                    cnt += 1;
                }

            }

            alphabetStub = alphabetStub.replace("X", "");
            return cnt + alphabetStub.length();
        }
    }

    private static class Answer implements Closeable {
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(int i) throws Exception {
            w.write(String.valueOf(i));
        }

        public void submit() throws Exception {
            w.flush();
        }

        @Override
        public void close() throws IOException {
            w.close();
        }
    }

}
