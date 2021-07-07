import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        try (
            MyReader reader = new MyReader();
            Answer answer = new Answer()
        ) {

            int N = reader.readIterNum();

            for (int i = 0; i < N; i++) {
                int sum = reader.readSum();
                answer.write(sum);
            }

            answer.submit();
        }
    }

    private static class MyReader implements Closeable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public int readIterNum() throws IOException {
            return parse(br.readLine());
        }

        public int readSum() throws IOException {
            String[] input = split(br.readLine());
            return sum(input);
        }

        private String[] split(String s) {
            StringTokenizer st = new StringTokenizer(s);
            return new String[] {st.nextToken(), st.nextToken()};
        }

        private int sum(String[] input) {
            return parse(input[0]) + parse(input[1]);
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
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        public void write(int sum) throws IOException {
            w.write(sum + "\n");
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
