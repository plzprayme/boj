package 소수_2581;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class 소수Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\소수_2581\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 2; i++) {
            int left = parseInt(r.readLine());
            int right = parseInt(r.readLine());

            boolean[] notPrime = new boolean[right+1];
            for (int j = 2; j <= right; j++) {
                if (notPrime[j]) continue;

                for (int k = j * 2; k <= right; k = k + j) {
                    notPrime[k] = true;
                }
            }

            List<Integer> answer = new ArrayList<>();
            for (int j = left; j <= right; j++) {
                if (j == 1) continue;
                if (!notPrime[j]) answer.add(j);
            }

            if (answer.isEmpty()) {
                w.write("-1");
                w.flush();
                return;
            }

            w.write(parseString(answer.stream().reduce(0, Integer::sum)));
            w.newLine();
            w.write(parseString(answer.get(0)));
            w.newLine();
            w.flush();
        }
    }

    private static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    private static String parseString(int i) {
        return String.valueOf(i);
    }
}
