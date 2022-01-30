package 단어수학_1339;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static State[] answer;
    static String[] s;

    static class State implements Comparable<State> {
        char alphabet;
        int num;

        public State(char alphabet, int num) {
            this.alphabet = alphabet;
            this.num = num;
        }

        @Override
        public int compareTo(State o) {
            return Integer.compare(o.num, num);
        }
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 수학 문제는 N개의 단어로 이루어져 있다.
        // 일단 완전탐색?
        // 서로 다른 숫자가 10개
        // 10! = 3_628_800

        // 최대 자릿수 구하기?
        // 어떤 값이 얼마나 앞에 있는가...?

        // 하나의 알파벳이 100의 자리에도 있을 수 있고 1000의 자리에도 있을 수 있다.
        // 즉, 여러 자릿수들에 등장할 수 있다.

        for (String ss : s) {
            for (int j = 0; j < ss.length(); j++) {
                answer[ss.charAt(j) - 'A'].num += Math.pow(10, j);
            }
        }

        Arrays.sort(answer);

        int idx = 0;
        for (int i = 9; i >= 0; i--) {
            State state = answer[idx++];

            for (int j = 0 ; j < N; j++) {
                for (int k = 0; k < s[j].length(); k++) {
                    if (s[j].charAt(k) == state.alphabet) {
                        s[j] = s[j].replaceAll(String.valueOf(state.alphabet), String.valueOf(i));
                    }
                }

            }

        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Integer.parseInt(new StringBuilder(s[i]).reverse().toString());
        }

        System.out.println(ans);
    }


    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\단어수학_1339\\input.txt");
        N = r.nextInt();
        s = new String[N];
        answer = new State[26];

        char a = 'A';
        for (int i = 0 ; i < 26; i++) {
            answer[i] = new State(a++, 0);
        }

        String c = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < c.length(); i++) {
            answer[i] = new State(c.charAt(i), 0);
        }

        for (int i = 0; i < N; i++) {
            s[i] = new StringBuilder(r.nextLine()).reverse().toString();
        }
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

        public String nextLine() throws IOException {
            return r.readLine();
        }
    }


}

