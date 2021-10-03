package 손익분기점_1712;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;

public class 손익분기점Test {
    @Test
    public void 예제() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\손익분기점_1712\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int A = parse(st.nextToken());
        int B = parse(st.nextToken());
        int C = parse(st.nextToken());

        int D = C - B;
        if (D <= 0) System.out.println(-1);
        else System.out.println(A / D + 1);
    }

    private int parse(String s) {
        return Integer.parseInt(s);
    }

}
