package 민겸수_21314;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static String MK;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        // 10^N 은 N + 1 개의 M으로

        // 5 * 10^N 은 N개의 M 뒤에 1개의 K

        // 한개 이상의 민겸수를 이어붙일 수 있다.

        // 민겸 수의 최댓값과 최솟값을 구하라

        // 최솟값: MM은 K를 무조건 떼버린다. K는 무조건 5로 바꾼다. MMK -> 105
        // 최댓값: MMK를 다 센다.

        // 최댓값

        // MMMMMM
        // KKKKKK
        // MMKK
        // MKMK

        // 최솟값 K 만나면 무조건 5
        // 첫 M은 1 그 이후는 0
        StringBuilder min = new StringBuilder();
        boolean preIsM = false;
        for (int i = 0; i < MK.length(); i++) {
            if (MK.charAt(i) == 'M') {
                if (preIsM) {
                    min.append(0);
                } else {
                    min.append(1);
                    preIsM = true;
                }
            } else {
                min.append(5);
                preIsM = false;
            }
        }

        StringBuilder max = new StringBuilder();
        int firstMIndex = -1;
        for (int i = 0; i < MK.length(); i++) {
            if (MK.charAt(i) == 'M') {
                if (firstMIndex == -1) {
                    firstMIndex = i;
                    max.append(1);
                } else {
                    max.append(0);
                }
            } else {
                if (firstMIndex != -1) {
                    max.replace(firstMIndex, firstMIndex + 1, "5");
                    firstMIndex = -1;
                    max.append(0);
                } else {
                    max.append(5);
                }
            }
        }


        if (firstMIndex != -1) {
            for (int i = firstMIndex; i < MK.length(); i++) {
                max.replace(i, i + 1, "1");
            }
        }

        System.out.println(max.append('\n').append(min));

    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\민겸수_21314\\input.txt");

        MK = r.nextLine();
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
