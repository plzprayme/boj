package 베르트랑공준_4948;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 베르트랑공준Test {
    @Test
    public void main() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\베르트랑공준_4948\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 123456 * 2;
        boolean[] isNotPrime = new boolean[max + 1];
        isNotPrime[1] = true;

        for (int i = 2; i <= max; i++) {
            if (isNotPrime[i]) continue;;

            for (int j = i * 2; j <= max; j = j + i) {
                isNotPrime[j] = true;
            }
        }

        int n;
        while ((n = parseInt(r.readLine())) != 0) {
            int n2 = n * 2;

            int count = 0;
            for (int i = n+1; i <= n2; i++) {
                if (!isNotPrime[i]) count++;
            }
            w.write(parseString(count));
            w.newLine();
        }
        w.flush();
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static String parseString(int i) {
        return String.valueOf(i);
    }
}
