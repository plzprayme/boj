package 단어섞기_9177;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 단어섞기 {

    static Map<String, Set<String>> cache;

    @Test
    public void main() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\단어섞기_9177\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        cache = new HashMap<>();
        int N = Integer.parseInt(r.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            String s3 = st.nextToken();

            String key = s1.concat(s2);
            if (!cache.containsKey(key)) {
                cache.put(key, new HashSet<>());
                go(s1, s2);
            }
            w.write(String.format("Data set %d: %s", i, validate(s3, key)));
            w.newLine();
        }
        w.flush();
    }

    private static String validate(String s3, String key) {
        return cache.get(key).contains(s3) ? "yes" : "no";
    }

    private static void go(String s1, String s2) {
        Stack<State> s = new Stack<>();
        s.push(new State(0, 0, new StringBuilder()));
        String key = s1.concat(s2);

        int length = s1.length() + s2.length();

        while (!s.empty()) {
            State now = s.pop();
            int i1 = now.i1;
            int i2 = now.i2;
            StringBuilder sb = now.s;
            if (sb.length() == length) {
                Set<String> temp = cache.get(key);
                temp.add(sb.toString());
                cache.put(key, temp);
            }

            if (i1 < s1.length() && i2 < s2.length() && s1.charAt(i1) == s2.charAt(i2)) {
                StringBuilder temp = sb.append(s1.charAt(i1));
                s.add(new State(i1 + 1, i2, temp));
                s.add(new State(i1, i2 + 1, temp));
            } else {
                if (i1 < s1.length()) {
                    s.add(new State(i1 + 1, i2, new StringBuilder(sb).append(s1.charAt(i1))));
                }

                if (i2 < s2.length()) {
                    s.add(new State(i1, i2 + 1, new StringBuilder(sb).append(s2.charAt(i2))));
                }
            }
        }
    }

    private static class State {
        int i1, i2;
        StringBuilder s;

        public State(int i1, int i2, StringBuilder sb) {
            this.i1 = i1;
            this.i2 = i2;
            s = sb;
        }
    }
}

