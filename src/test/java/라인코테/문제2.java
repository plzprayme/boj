package 라인코테;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class 문제2 {
    public String solution(String[] research, int n, int k) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";


        for (int i = 0; i <= research.length - n; i ++) {


            Map<Character, Integer> counter = new HashMap<>();
            for (char c : alphabet.toCharArray()) {
                counter.put(c, 0);
            }
            for (int j = i; j < i + n; j++) {
                Map<Character, Integer> small = new HashMap<>();
                for (char c : alphabet.toCharArray()) {
                    small.put(c, 0);
                }

                for (char searched : research[j].toCharArray()) {
                    small.put(searched, counter.get(searched) + 1);

                    counter.put(searched, counter.get(searched) + 1);
                }

                for (Map.Entry<Character, Integer> s : small.entrySet()) {
                    if (s.getValue() >= k) {
                        counter.put(s.getKey(), counter.get(s.getKey()) + s.getValue());
                    }
                }
            }

            System.out.println(counter);


        }

        String answer = "";
        return answer;
    }

    class Node {
        char alphabet;
        int count;

        public Node(char alphabet, int count) {
            this.alphabet = alphabet;
            this.count = count;
        }
    }

    @Test
    public void main() {
        System.out.println(
            solution(
                new String[] {
                    "abaaaa",
                    "aaa",
                    "abaaaaaa",
                    "fzfffffffa"
                }, 2, 2
            )
        );

        System.out.println(
            solution(
                new String[] {
                    "yxxy",
                    "xxyyy"
                }, 2, 1
            )
        );

        System.out.println(
            solution(
                new String[] {
                    "yxxy",
                    "xxyyy",
                    "yz"
                }, 2, 1
            )
        );

        System.out.println(
            solution(
                new String[] {
                    "xy",
                    "xy"
                }, 1, 1
            )
        );
    }
}
