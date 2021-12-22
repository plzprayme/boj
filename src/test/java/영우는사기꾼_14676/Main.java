package 영우는사기꾼_14676;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main {

    static InputReader r;

    static int[] build;

    static List<Integer>[] in;
    static List<Integer>[] out;

    static boolean[] canBuild;

    static int N, M, K;

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() throws IOException {
        for (int i = 1; i <= N; i++) {
            if (in[i].isEmpty()) canBuild[i] = true;
        }

        for (int k = 0; k < K; k++) {
            int behavior = r.nextInt();
            int node = r.nextInt();

            if (behavior == 1) {
                // 건설 가능한지 체크하자
                if (canBuild[node]) {
                    // 건설하자
                    build[node]++;

                } else {
                    System.out.println("Lier!");
                    return;
                }
            } else {
                // 파괴한다.
                // 파괴 가능한가??
                if (build[node] == 0) {
                    System.out.println("Lier!");
                    return;
                } else {
                    for (int next : in[node]) {
                        if (--build[next] == 0) canBuild[next] = true;
                    }
                }
            }
        }

        System.out.println("King-God-Emperor");
    }

    private static void input() throws IOException {
        r = new InputReader("C:\\Users\\workspace\\boj\\src\\test\\java\\영우는사기꾼_14676\\input.txt");

        N = r.nextInt(); M = r.nextInt(); K = r.nextInt();

        canBuild = new boolean[N + 1];
        build = new int[N + 1];
        in = new List[N + 1];
        out = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int left = r.nextInt();
            int right = r.nextInt();
            in[right].add(left);
            out[left].add(right);
            build[right]++;
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
    }


}

