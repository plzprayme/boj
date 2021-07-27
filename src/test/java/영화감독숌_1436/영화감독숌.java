package 영화감독숌_1436;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;

public class 영화감독숌 {
    @Test
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\영화감독숌_1436\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(r.readLine());
        w.write(bruteForce(N));
        w.flush();

    }

    private static String bruteForce(int N) {
        int num = 666;
        int count = 1;
        while (count != N) {
            num++;
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }
        return String.valueOf(num);
    }



}
