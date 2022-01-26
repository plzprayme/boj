package 암호만들기_1759;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int L, C;
    static char[] alphabet;
    static char[] num;

    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 암호는 서로 다른 L 개의 알파벳 소문자로 구성
        // 최소 한 개의 모음 과 두 개의 자음으로 구성
        // 암호가 증가하는 순서로 배열되어 있다.


        // 암호는 서로 다른 L개의 알파벳
        // 최소 한 개의 모음 (a, e, i, o, u)과 두 개의 자음
        // 백트래킹

        Arrays.sort(alphabet);
        backtracking(0,0, 0, 0);

        System.out.println(sb);
    }

    private static void backtracking(int l, int consonant, int vowel, int start) {
        if (l == L) {
            if (consonant >= 1 && vowel >= 2) {
                for (char c : num) {
                    sb.append(c);
                }
                sb.append('\n');
            }
        } else {
            for (int i = start; i < C; i++) {
                if (isConsonant(alphabet[i])) {
                    consonant++;
                } else {
                    vowel++;
                }
                num[l] = alphabet[i];
                backtracking(l + 1, consonant, vowel, i + 1);
                num[l] = ' ';
                if (isConsonant(alphabet[i])) {
                    consonant--;
                } else {
                    vowel--;
                }
            }
        }

    }

    private static boolean isConsonant(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\암호만들기_1759\\input.txt");
        L = r.nextInt(); C = r.nextInt();

        alphabet = new char[C];
        for (int i = 0; i < C; i++) {
            alphabet[i] = r.nextChar();
        }
        num = new char[L];
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

        public char nextChar() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return st.nextToken().charAt(0);
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }


}


