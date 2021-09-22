package N과M_15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

class Main {
    static BufferedWriter w;
    static int[] selected;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r  = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N과M_15651\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = parse(st.nextToken());
        M = parse(st.nextToken());
        selected = new int[M + 1];

        rec(1);
        System.out.println(sb.toString());


    }

    static void rec(int m) {
        if (m == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');

        } else {
            for (int i = 1; i <= N; i++) {
                selected[m] = i;
                rec(m + 1);
            }
        }

    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }
}
