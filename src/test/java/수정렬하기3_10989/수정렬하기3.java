package 수정렬하기3_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 수정렬하기3 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수정렬하기3_10989\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] count = new int[10001];
        int N = parse(r.readLine());
        for (int i = 0; i < N; i++) {
            count[parse(r.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < count[i]; j++) {
                w.write(String.format("%d\n", i));
            }
        }
        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }
}
