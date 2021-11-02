package zum;

import java.io.*;

import org.junit.jupiter.api.Test;

class Main3 {

    private static int solution(int[] histogram) {
        int answer = Integer.MIN_VALUE;
        for (int left = 0; left < histogram.length; left++) {
            for (int right = left + 2; right < histogram.length; right++) {
                int height = Math.min(histogram[left], histogram[right]);
                int width = right - left - 1;
                int area = width * height;
                answer = Math.max(answer, area);
            }
        }
        return answer;
    }

    private static void input() throws IOException { }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solution(
            new int[] {
                2, 2, 2, 3
            }
        ));
    }

}

