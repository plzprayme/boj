package 수열정렬_1015;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 수열정렬 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수열정렬_1015\\input.txt"));

        int N = Integer.parseInt(r.readLine());

        E[] A = new E[N];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A[i] = new E(num, i);
        }

        E[] B = A.clone();
        Arrays.sort(B);

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                if (B[j].num.equals(A[i].num)) {
                    P[i] = A[j].idx;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(P[i]).append(' ');
        }
        System.out.println(sb);
    }

    static class E implements Comparable<E> {
        Integer num, idx;

        public E(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(E o) {
            return num.compareTo(o.num);
        }
    }
}
