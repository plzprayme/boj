package 하노이탑이동순서_11729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 하노이탑이동순서 {
    private static BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\하노이탑이동순서_11729\\input.txt"));

        int N = Integer.parseInt(r.readLine());
        String count = String.format("%d\n", (int) Math.pow(2, N) - 1);
        w.write(count);

        hanoi(N, 1, 2, 3);
        w.flush();
        w.close();
    }

    private static void hanoi(int N, int start, int mid, int to) throws IOException {
        String s = String.format("%d %d\n", start, to);
        if (N == 1) {
            w.write(s);
            return;
        }

        hanoi(N-1, start, to, mid);

        w.write(s);

        hanoi(N-1, mid, start, to);
    }
}
