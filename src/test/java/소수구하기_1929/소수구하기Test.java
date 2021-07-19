package 소수구하기_1929;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 소수구하기Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\소수구하기_1929\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] xy = r.readLine().split(" ");
        int x = parse(xy[0]);
        int y = parse(xy[1]);

        boolean[] isNotPrime = new boolean[y+1];
        isNotPrime[1] = true;
        for (int i = 2; i <= y; i++) {
            if (isNotPrime[i]) continue;

            for (int j = i * 2; j <= y; j = j + i) {
                isNotPrime[j] = true;
            }
        }

        for (int i = x; i <= y; i++) {
            if (!isNotPrime[i]) {
                w.write(String.valueOf(i));
                w.newLine();
            }
        }
        w.flush();
    }

    private int parse(String s) {
        return Integer.parseInt(s);
    }
}
