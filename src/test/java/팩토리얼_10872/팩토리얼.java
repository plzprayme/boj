package 팩토리얼_10872;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 팩토리얼 {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\팩토리얼_10872\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 2; i++) {
            w.write(String.valueOf(factorial(Integer.parseInt(r.readLine()))));
        }
        w.flush();

    }

    private static int factorial(int i) {
        if (i <= 1) return 1;
        return i * factorial(--i);
    }
}
