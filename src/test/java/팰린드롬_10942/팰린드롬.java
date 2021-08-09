package 팰린드롬_10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 팰린드롬 {

    static int[] numbers;
    static boolean[][] isPalindrome;

    @Test
    public void main() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\팰린드롬_10942\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = parse(r.readLine()) + 1;
        StringTokenizer st = new StringTokenizer(r.readLine());

        numbers = new int[N];
        for (int i = 1; i < N; i++) {
            numbers[i] = parse(st.nextToken());
        }

        // 한번만 순회하면서 구간별 palindrome을 체크한다. 큰 리스트에서 작은 리스트로 좁아지도록
        // 어떻게..??

        // 구간 별 기억하기
        isPalindrome = new boolean[N][N];
        validate();

        int M = parse(r.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(r.readLine());
            int start = parse(st.nextToken());
            int end = parse(st.nextToken());

            if (isPalindrome[start][end]) {
                w.write("1");
            } else {
                w.write("0");
            }

            w.newLine();
        }

        w.flush();
    }

    private static void validate() {
        int N = numbers.length;
        for (int i = 1; i < N; i++) isPalindrome[i][i] = true;

        for (int i = 1; i < N - 1; i++)  {
            if (numbers[i] == numbers[i+1]) isPalindrome[i][i+1] = true;
        }

        for (int i = 2; i < N - 1; i++) {
            for (int j = 1; j < N - i; j++) {
                if (isPalindrome[j + 1][j + i - 1] && numbers[j] == numbers[j+i]) isPalindrome[j][j+i] = true;

            }
        }
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

}
