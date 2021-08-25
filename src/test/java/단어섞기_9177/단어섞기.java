package 단어섞기_9177;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 단어섞기 {

    @Test
    public void main() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\단어섞기_9177\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(r.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            String s3 = st.nextToken();

            w.write(String.format("Data set %d: %s", i, validate(s1, s2, s3)));
            w.newLine();
        }
        w.flush();
    }

    private static String validate(String s1, String s2, String s3) {

        Stack<State> s = new Stack<>();
        s.push(new State(0, 0));

        for (char c : s3.toCharArray()) {
            if (s.empty())
                return "no";

            State now = s.pop();
            int i1 = now.i1;
            int i2 = now.i2;
            if (i1 < s1.length() && i2 < s2.length() &&  c == s1.charAt(i1) && c == s2.charAt(i2)) {
                s.push(new State(i1 + 1, i2));
                s.push(new State(i1, i2 + 1));
            } else if (i1 < s1.length() && c == s1.charAt(i1)) {
                s.push(new State(i1 + 1, i2));
            } else if (i2 < s2.length() && c == s2.charAt(i2)) {
                s.push(new State(i1, i2 + 1));
            } else {
                return "no";
            }
        }

        return "yes";
    }

    private static class State {
        int i1, i2;

        public State(int i1, int i2) {
            this.i1 = i1;
            this.i2 = i2;
        }
    }
}

