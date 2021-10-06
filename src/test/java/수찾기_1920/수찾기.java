package 수찾기_1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 수찾기 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수찾기_1920\\input.txt"));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(r.readLine());
        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        int M = Integer.parseInt(r.readLine());
        int[] B = new int[M + 1];
        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) B[i] = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= M; i++) sb.append(bSearch(A, 1, N, B[i])).append('\n');
        System.out.println(sb);
    }

    static int bSearch(int[] B, int L, int R, int X) {
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (X > B[M]) L = M + 1;
            else if (X < B[M]) R = M - 1;
            else return 1;
        }
        return 0;
    }
}
