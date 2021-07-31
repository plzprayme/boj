package 수정렬하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import 정렬.분할.Merge;

public class 수정렬하기 {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수정렬하기2\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[parse(r.readLine())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = parse(r.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(String.format("%d\n", i));
        }
        w.write(sb.toString());
        w.flush();
    }

    private int parse(String s) {
        return Integer.parseInt(s);
    }

    @Test
    public void 예제2() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\수정렬하기2\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[parse(r.readLine())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = parse(r.readLine());
        }
        System.out.println(new Merge(arr).sort());

    }
}