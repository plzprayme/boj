package N과M6_15655;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class N과M6 {

    static int N, M;
    static int[] nums, selected;
    static StringBuilder sb = new StringBuilder();

    private static void solution(int m, int idx) {
        if (m == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {

            for (int i = idx; i <= N; i++) {
                selected[m] = nums[i];
                solution(m + 1, i + 1);
            }

        }
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N과M6_15655\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1]; selected = new int[M + 1];

        st = new StringTokenizer(r.readLine());
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution(1, 1);
        System.out.println(sb);
    }

}

