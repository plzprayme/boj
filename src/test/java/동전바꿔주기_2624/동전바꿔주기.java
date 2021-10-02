package 동전바꿔주기_2624;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 동전바꿔주기 {

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\동전바꿔주기_2624\\input.txt"));

        int T, K;
        int[] money = new int[1_001], count = new int[1_001];
        int[] dp = new int[10_001];
        dp[0] = 1;

        T = Integer.parseInt(r.readLine());
        K = Integer.parseInt(r.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            count[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) { // 동전만큼 반복

            for (int j = T; j >= 1; j--) { // 금액부터 시작
                int sum = 0;
                for (int k = 0; k < count[i]; k++) { // 해당 동전의 개수만큼 반복
                    sum += money[i];

                    if (j - sum >= 0 && dp[j - sum] > 0) dp[j] += dp[j - sum];
                }
            }

        }
        System.out.printf("%d", dp[T]);

    }
}
