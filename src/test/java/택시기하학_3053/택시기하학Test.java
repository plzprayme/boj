package 택시기하학_3053;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 택시기하학Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(
            new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\택시기하학_3053\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            double R = Double.parseDouble(r.readLine());
            w.write(String.format("%5f", R * R * Math.PI));
            w.newLine();
            w.write(String.format("%5f", R * R * 2));
            w.flush();
        }
    }

}
