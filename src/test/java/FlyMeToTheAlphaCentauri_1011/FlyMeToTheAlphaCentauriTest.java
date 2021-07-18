package FlyMeToTheAlphaCentauri_1011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class FlyMeToTheAlphaCentauriTest {
    @Test
    public void 예제() throws Exception {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\FlyMeToTheAlphaCentauri\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = parse(r.readLine());
        for (int i = 0; i < N; i++) {
            String[] xy = r.readLine().split(" ");
            int x = parse(xy[0]);
            int y = parse(xy[1]);

            int step = 0;
            int count = 0;
            while (x != y) {
                ++count;
                int remain = y - x;
                if (remain <= distance(step + 1)) {
                    x += ++step;
                    continue;
                }

                if (remain <= distance(step)) {
                    x += step;
                    continue;
                }

                if (remain <= distance(step - 1)) {
                    x += --step;
                    continue;
                }

            }
            System.out.println(count);
        }

    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static int distance(int step) {
        return step * (step + 1) / 2;
    }
}
