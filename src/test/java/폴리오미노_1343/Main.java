package 폴리오미노_1343;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static String board;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        board = board.replaceAll("XXXX", "AAAA");
        board = board.replaceAll("XX", "BB");

        if (board.contains("X")) {
            System.out.println(-1);
        } else {
            System.out.println(board);
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader();
        board = new String(r.nextCharArr());
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
