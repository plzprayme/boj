package 덩치_7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class 덩치 {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\덩치_7568\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(r.readLine());
        Body[] bodies = new Body[N];
        for (int i = 0; i < N; i++) {
            bodies[i] = new Body(r.readLine().split(" "));
        }

        int[] counts = new int[N];
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (bodies[i].equals(bodies[j])) continue;

                if (bodies[i].isSmaller(bodies[j])) count++;
            }
            counts[i] = count;
        }


        String a = Arrays.stream(counts)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));

        w.write(a);
        w.flush();

    }

    private static class Body {
        int w;
        int h;

        public Body(String[] input) {
            this.w = parse(input[0]);
            this.h = parse(input[1]);
        }

        public boolean isSmaller(Body other) {
             return this.w < other.w && this.h < other.h;
        }
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
