package 넥슨;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class 문제2 {

    public long paperCuttings(int textLength, List<Integer> starting, List<Integer> ending) {

        long answer = 0L;
        Set<Node> set = new HashSet<>();
        for (int i = 0; i < starting.size(); i++) {
            set.add(new Node(starting.get(i), ending.get(i)));
        }

        List<Node> arr = new ArrayList<>(set);
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                Node left = arr.get(i);
                Node right = arr.get(j);
                if (left.ok(right) && right.ok(left)) answer++;
            }
        }

        return answer;
    }

    static class Node {
        int s, e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public boolean ok(Node n) {
            if (s <= n.e && n.e <= e)
                return false;
            if (s <= n.s && n.s <= e)
                return false;
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Node))
                return false;
            Node node = (Node)o;
            return s == node.s && e == node.e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, e);
        }
    }

    @Test
    public void main() {
        // System.out.println(paperCuttings(
        //     8,
        //     Arrays.asList(3, 4, 5, 6, 8),
        //     Arrays.asList(4, 5, 6, 7, 8)
        // ));

        System.out.println(paperCuttings(
            10,
            Arrays.asList(3, 1, 2, 8, 8),
            Arrays.asList(5, 3, 7, 10, 10)
        ));
    }
}
