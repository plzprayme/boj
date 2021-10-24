package cafe24;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class _1 {
    @Test
    public void 케이스() {
        System.out.println(
            solution(
                new String[]{"aaaa", "abd", "abc", "abb", "q", "b", "c"}
            )


        );
    }

    public String[] solution(String[] args) {
        return Arrays.stream(args)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .sorted(Comparator.comparingInt(String::length))
            .toArray(String[]::new);
    }

    // class Wrapper implements Comparable<Wrapper> {
    //     String s;
    //
    //     @Override
    //     public int compareTo(String o) {
    //         if (Integer.compare(s.length(), o.length()))
    //         return 0;
    //     }
    // }
}
