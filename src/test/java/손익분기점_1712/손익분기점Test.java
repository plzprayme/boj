package 손익분기점_1712;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import org.junit.jupiter.api.Test;

public class 손익분기점Test {
    @Test
    public void 예제() {

        String s = "1000 70 170";
        // String s = "2100000000 9 10";
        String[] ss = s.split(" ");
        int A = parse(ss[0]);
        int B = parse(ss[1]);
        int C = parse(ss[2]);
        int D = C - B;
        if (D <= 0) {
            System.out.println("-1");
            return;
        }

        System.out.println((A / D) + 1);

    }

    private int parse(String s) {
        return Integer.parseInt(s);
    }

}
