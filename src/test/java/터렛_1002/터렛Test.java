package 터렛_1002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 터렛Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\터렛_1002\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(r.readLine());
        for (int i = 0; i < N; i++) {
            int[] circles = Arrays.stream(r.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            int x1 = circles[0];
            int y1 = circles[1];

            int x2 = circles[3];
            int y2 = circles[4];

            int bigger = Math.max(circles[2], circles[5]);
            int smaller = Math.min(circles[2], circles[5]);

            double d = (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

            if (d == 0 && bigger == smaller) w.write("-1");
            else if (bigger - smaller < d && d < bigger + smaller) w.write("2");
            else if (bigger + smaller == d || d == bigger - smaller) w.write("1");
            else if (bigger + smaller < d || d < bigger - smaller || d == 0) w.write("0");
            w.newLine();
        }
        w.flush();
    }
}
