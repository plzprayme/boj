package 팰린드롬_10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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

        isPalindrome = new boolean[N][N];
        for (int i = 1; i < N; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 1; i < N - 1; i += 2) {
            isPalindrome[i][i+1] = numbers[i] == numbers[i+1];
        }

        for (int i = 2; i < N - 1; i++) { // 몇 칸 뛸지 결정
            for (int j = 1; j < N - i; j++) { // 기준 숫자
                isPalindrome[j][j+i] = isPalindrome[j + 1][j + i - 1] && numbers[j] == numbers[j + i];
            }
        }



        N = parse(r.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(r.readLine());
            int start = parse(st.nextToken());
            int end = parse(st.nextToken());
        }


        w.flush();
    }



    private static int parse(String s) {
        return Integer.parseInt(s);
    }

}
