package 소트인사이드_1427;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static char[] num;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        Arrays.sort(num);
        StringBuilder sb = new StringBuilder();
        for (char c : num) sb.append(c);
        System.out.println(sb.reverse());
    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        num = r.nextCharArr();
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
    }


}

