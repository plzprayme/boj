package 골드바흐의추측_9020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 골드바흐의추측9020Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\골드바흐의추측_9020\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 10000;
        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[1] = true;
        for (int i = 2; i <= max; i++) {
            if (isNotPrime[i]) continue;

            for (int j = i * 2; j <= max; j = j + i) {
                isNotPrime[j] = true;
            }
        }

        int N = parseInt(r.readLine());
        for (int k = 0; k < N; k++) {

            int n = parseInt(r.readLine());
            for (int i = n / 2; i >= 2; i--) {
                if (!isNotPrime[i] && !isNotPrime[n - i]) {
                    w.write(parseString(i, n - i));
                    break;
                }
            }

        }

        w.flush();
    }

    private String parseString(int i, int j) {
        return String.format("%d %d\n", i, j);
    }

    private int parseInt(String s) {
        return Integer.parseInt(s);
    }


}
