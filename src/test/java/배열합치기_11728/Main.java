package 배열합치기_11728;


import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static int N, M;
    static int[] answer, A, B;

    private static void solution() {
        int c = 0;
        for (int i : A) answer[c++] = i;
        for (int i : B) answer[c++] = i;
        Arrays.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (int i : answer) sb.append(i).append(' ');
        System.out.println(sb);
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\배열합치기_11728\\input.txt");
        r.readLine();
        N = r.nextInt(); A = new int[N];
        M = r.nextInt(); B = new int[M];
        answer = new int[N + M];

        r.readLine();
        for (int i = 0; i < N; i++)  A[i] = r.nextInt();

        r.readLine();
        for (int i = 0; i < M; i++)  B[i] = r.nextInt();
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
        }

        public void readLine() throws IOException {
            st = new StringTokenizer(r.readLine());
        }

        public int nextInt() {
            return Integer.parseInt(st.nextToken());
        }
    }
}

