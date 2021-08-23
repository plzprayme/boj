package 작업;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 작업 {

    static BufferedReader r;

    @Test
    public static void main(String[] args) throws IOException {
        r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\작업\\input.txt"));

        int N = parse(r.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int time = parse(st.nextToken());
            int pre = parse(st.nextToken());

            if (pre == 0) {
                dp[i] = time;
            } else {
                int longest = 0;
                for (int j = 0; j < pre; j++) {
                    int index = parse(st.nextToken());
                    longest = Math.max(longest, dp[index]);
                }
                dp[i] = longest + time;
            }

        }

        System.out.println(dp[N]);
    }

    @Test
    public void 사전작업_없음() throws IOException {
        r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\작업\\전부다사전작업없음.txt"));

        int N = parse(r.readLine());
        int[] dp = new int[N + 1];

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int time = parse(st.nextToken());
            int pre = parse(st.nextToken());

            if (pre == 0) {
                dp[i] = time;
                max = Math.max(time, max);
            } else {
                int longest = 0;
                for (int j = 0; j < pre; j++) {
                    int index = parse(st.nextToken());
                    longest = Math.max(longest, dp[index]);
                }
                dp[i] = longest + time;
            }

        }

        System.out.println(Math.max(max, dp[N]));
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
