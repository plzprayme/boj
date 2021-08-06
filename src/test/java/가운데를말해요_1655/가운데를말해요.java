package 가운데를말해요_1655;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.jupiter.api.Test;

public class 가운데를말해요 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\가운데를말해요_1655\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int N = parse(r.readLine());
        for (int i = 0; i < N; i++) {
            heap.add(parse(r.readLine()));

            System.out.println(heap);

            int size = heap.size();
            Object[] o = heap.toArray();
            if (size == 2) {
                int a = (int) o[0];
                int b = (int) o[1];
                String mid = String.valueOf(Math.min(a, b));
                w.write(mid);
                w.newLine();
                continue;
            }

            if (isEven(size)) {
                int a = (int) o[size / 2 - 1];
                int b = (int) o[size / 2];
                String mid = String.valueOf(Math.min(a, b));
                w.write(mid);
            }

            else {
                int a = (int) o[size / 2];
                String mid = String.valueOf(a);
                w.write(mid);
            }

            w.newLine();
        }
        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }
}
