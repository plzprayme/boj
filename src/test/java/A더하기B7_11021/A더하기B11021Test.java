package A더하기B7_11021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class A더하기B11021Test {
    @Test
    public void 예제() throws Exception {
        try (
            MyReader reader = new MyReader();
            Answer answer = new Answer()
        ) {
            int N = reader.readN();

            for (int i = 1; i <= N; i++) {
                int sum = reader.readSum();
                answer.write(i, sum);
            }

            answer.submit();
        }
    }

    private static class MyReader implements Closeable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public int readN() throws IOException {
            return parse(br.readLine());
        }

        public int readSum() throws IOException {
            String[] input = split(br.readLine());
            return sum(input);
        }

        private int sum(String[] input) {
            return parse(input[0]) + parse(input[1]);
        }

        private String[] split(String s) {
            StringTokenizer st = new StringTokenizer(s);
            int size = st.countTokens();
            String[] splited = new String[size];

            for (int i = 0; i < size; i++) {
                splited[i] = st.nextToken();
            }

            return splited;
        }

        private int parse(String n) {
            return Integer.parseInt(n);
        }

        @Override
        public void close() throws IOException {
            br.close();
        }
    }

    private static class Answer implements Closeable {
        private static final String NEW_LINE = "\n";
        private static final String WHITE_SPACE = " ";

        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(int i, int sum) throws IOException {
            w.write(
                String.format("Case #%d: %d\n", i, sum)
            );
            //w.write(sum + NEW_LINE);
            //w.write(sum + WHITE_SPACE);
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
