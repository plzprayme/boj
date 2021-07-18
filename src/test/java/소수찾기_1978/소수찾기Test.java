package 소수찾기_1978;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 소수찾기Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\소수찾기_1978\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isPrime = new boolean[10001];

        for (int i = 2; i <= 10000; i++) {
            if (isPrime[i]) continue;

            for (int j = i * 2; j <= 10000; j = j + i) {
                isPrime[j] = true;
            }
        }

        int count = 0;
        r.readLine();
        for (String s : r.readLine().split(" ")) {
            int n = parse(s);
            if (n == 1) continue;;
            if (!isPrime[n]) count++;
        }
        w.write(String.valueOf(count));
        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
