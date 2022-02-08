package 달리기_2517;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N;
    static Num[] arr, sorted;
    static int[] ans;

    @Test
    public static void main(String[] args) throws IOException {
//        input();
        solution();
    }
    
    class Num {
        int i, n;

        public Num(int i, int n) {
            this.i = i;
            this.n = n;
        }
    }

    private static void solution() {
        merge(1, N);
    }

    private static void merge(int l, int r) {
        if (l == r) return;

        int m = (l + r) / 2;
        merge(l, m);
        merge(m, r);
    }

    static void mergeSort(int l, int r) {
        if (l == r) return;
    }



//    private static void input() throws IOException {
//
//        InputReader r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\달리기_2517\\dummy.txt");
//
//        N = r.nextInt();
//
//        nums = new int[N + 1];
//        sorted = new int[N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            nums[i] = r.nextInt();
//        }
//    }

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

