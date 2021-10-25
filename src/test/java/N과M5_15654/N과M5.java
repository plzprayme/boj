package N과M5_15654;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class N과M5 {
    static int N, M;
    static int[] nums;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    private static void solution(int m) {
        if (m == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                selected[m] = nums[i];
                visited[i] = true;
                solution(m + 1);
                visited[i] = false;
            }

        }
    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\N과M5_15654\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        nums = new int[N + 1];
        selected = new int[M + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution(1);
    }

}

