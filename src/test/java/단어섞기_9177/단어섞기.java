package 단어섞기_9177;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.PriorityQueue;
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
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.add(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State now = pq.poll();
            int i1 = now.i1;
            int i2 = now.i2;
            int i3 = now.i3;
            if (i3 == s3.length()) return "yes";

            char c = s3.charAt(i3);
            if (i1 < s1.length() && i2 < s2.length() &&  c == s1.charAt(i1) && c == s2.charAt(i2)) {
                pq.add(new State(i1 + 1, i2, i3 + 1));
                pq.add(new State(i1, i2 + 1, i3 + 1));
            } else if (i1 < s1.length() && c == s1.charAt(i1)) {
                pq.add(new State(i1 + 1, i2, i3 + 1));
            } else if (i2 < s2.length() && c == s2.charAt(i2)) {
                pq.add(new State(i1, i2 + 1, i3 + 1));
            }
        }

        return "no";
    }

    private static class State implements Comparable<State> {
        int i1, i2, i3;

        public State(int i1, int i2, int i3) {
            this.i1 = i1;
            this.i2 = i2;
            this.i3 = i3;
        }

        @Override
        public int compareTo(State o) {
            return Integer.compare(o.i3, i3);
        }
    }
}

