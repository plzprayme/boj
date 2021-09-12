package 넥슨;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class 문제3 {

    static Map<Integer, Stack<Integer>> map = new HashMap<>();

    public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {


        Stack<Integer> answer = new Stack<>();

        for (int i = 0; i < queryType.size(); i++) {
            String s = queryType.get(i);
            Integer left = students1.get(i);
            Integer right = students2.get(i);

            if (s.equals("Friend")) {
                Stack<Integer> ll = map.getOrDefault(left, new Stack<>());
                ll.add(right);
                map.put(left, ll);

                Stack<Integer> rl = map.getOrDefault(right, new Stack<>());
                rl.add(left);
                map.put(right, rl);
            }

            if (s.equals("Total")) {
                answer.add(dfs(left), dfs(right));
            }
        }

        return answer;
    }

    static int dfs(int node) {
        int count = 0;

        Stack<Integer> ll = map.getOrDefault(node, new Stack<>());
        while (!ll.isEmpty()) {
            dfs(ll.pop());
        }

        return ++count;
    }

    @Test
    public void main() {


        System.out.println(
            getTheGroups(
                5,
                Arrays.asList("Friend", "Friend", "Total"),
                Arrays.asList(4, 2, 2),
                Arrays.asList(1, 4, 3)
            )
        );

    }
}
