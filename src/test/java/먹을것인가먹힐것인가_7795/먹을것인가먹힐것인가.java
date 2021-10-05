package 먹을것인가먹힐것인가_7795;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 먹을것인가먹힐것인가 {
    static int[] B;
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\먹을것인가먹힐것인가_7795\\input.txt"));

        int T = Integer.parseInt(r.readLine());
        for (int _T = 0; _T < T; _T++) {

            StringTokenizer st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(r.readLine());
            int[] A = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(r.readLine());
            B = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            int answer = 0;
            for (int i = 1; i <= N; i++) {
                int key = A[i];
                answer += bSearch(B, 1, M, key);
            }

            System.out.println(answer);
        }
    }


    static int bSearch(int[] A, int L, int R, int X) {
        int result = L - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] < X) {
                result = mid;
                L = mid + 1;
            } else if (A[mid] >= X) {
                R = mid - 1;
            }
        }
        return result;
    }
}
