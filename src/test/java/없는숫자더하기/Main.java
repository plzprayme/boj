package 없는숫자더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Main {


    public int solution(int[] numbers) {
        int answer = 45;

        for (int i : numbers) {
            answer -= i;
        }

        return answer;
    }



    @Test
    public void main() {
        solution(
            new int[] {1,2,3,4,6,7,8,0}
        );
    }

}
