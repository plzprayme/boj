package 단어의개수;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {
    static String s;

    private static void solution() {
        String[] arr = s.split(" ");

        int count = 0;
        for (String s1 : arr) {
            if (!s1.equals("")) count++;
        }

        System.out.println(count);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        s = r.readLine();
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }

        public String readLine() throws IOException {
            return r.readLine();
        }
    }

}

