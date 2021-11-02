package zum;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.Test;

class Main1 {
    private static void solution(long n) {
        long answer = 0;
        for (int i = 1; i < n; i++) {
            answer += i * n + i;
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {

    }

    @Test
    public static void main(String[] args) throws IOException {
        input();


    }

}

