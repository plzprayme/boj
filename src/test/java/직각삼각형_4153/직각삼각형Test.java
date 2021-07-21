package 직각삼각형_4153;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class 직각삼각형Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\직각삼각형_4153\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] input = r.readLine().split(" ");
            if ("0".equals(input[0])) break;

            int[] edges = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
            Arrays.sort(edges);

            if (isRight(edges[2], edges[1], edges[0])) {
                w.write("right\n");
                continue;
            }

            w.write("wrong\n");
        }
        w.flush();
    }

    private static boolean isRight(int a, int b, int c) {
        return pow(a) == pow(b) + pow(c);
    }

    private static int pow(int s) {
        return (int) Math.pow(s, 2);
    }
}
