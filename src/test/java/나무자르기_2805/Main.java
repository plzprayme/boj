package 나무자르기_2805;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\나무자르기_2805\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(r.readLine());
        int[] trees = new int[N + 1];
        for (int i = 1; i <= N; i++) trees[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(trees, 1, trees.length);

        int H = trees[N] - 1;
        int answer = solution(trees, H, M);
        System.out.println(answer);
    }

    private static int solution(int[] trees, int H, int M) {
        while (H >= 0) {
            if (go(trees, H) >= M) return H;

            H--;
        }
        return H;
    }

    private static int go(int[] trees, int h) {

        int now = 0;
        for (int i = trees.length - 1; i >= 0; i--) {
            if (trees[i] < h) return now;

            now += trees[i] - h;
        }
        return now;
    }

}
