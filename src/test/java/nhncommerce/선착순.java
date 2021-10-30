package nhncommerce;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class 선착순 {

    private static void solution() {

    }

    private static void input() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\nhncommerce\\input.txt"));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());

        Set<String> can = new HashSet<>();

        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < N; i++) {
            String now = st.nextToken();
            if (can.contains(now)) continue;
            can.add(now);
            if (can.size() == M) {
                System.out.println(i + 1);
            }
        }


    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

}
