package 팰린드롬_10942;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.Test;

public class 팰린드롬 {
    @Test
    public void main() throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("C:\\Users\\prayme\\workspace\\boj\\src\\test\\java\\팰린드롬_10942\\input.txt"));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));

        r.readLine();

        List<Integer> numbers = new ArrayList<>(1_000_000);
        for (String number : r.readLine().split(" ")) {
            numbers.add(parse(number));
        }

        int M = parse(r.readLine());
        for (int i = 0; i < M; i++) {
            String[] indexes = r.readLine().split(" ");

            List<Integer> splited = numbers.subList(parse(indexes[0]) - 1, parse(indexes[1]));
            if (isPalindrome(splited)) {
                w.write("1");
            } else {
                w.write("0");
            }

            w.newLine();
        }

        w.flush();
    }

    private static int parse(String s) {
        return Integer.parseInt(s);
    }

    private static boolean isPalindrome(List<Integer> splited) {
        Deque<Integer> numbers = new ArrayDeque<>(splited);

        while (!numbers.isEmpty()) {
            if (numbers.size() == 1) return true;

            if (numbers.pollFirst() != numbers.pollLast()) return false;
        }

        return true;
    }
}
