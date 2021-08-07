package leet.august;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class NaryTreeLevelOrderTraversal_8th {

    private static class Solution {
        private List<List<Integer>> answer = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) return answer;
            search(Arrays.asList(root));
            return answer;
        }

        private void search(List<Node> level) {
            if (level.isEmpty()) return;

            List<Integer> currentLevel = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();
            for (Node current : level) {

                for (Node next : current.children) {
                    nextLevel.add(next);
                }

                currentLevel.add(current.val);
            }
            answer.add(currentLevel);

            search(nextLevel);
        }

        private static class Node {
            public int val;
            public List<Node> children;

            public Node() {
            }

            public Node(int _val) {
                val = _val;
            }

            public Node(int _val, List<Node> _children) {
                val = _val;
                children = _children;
            }
        }
    }

    @Test
    public static void main(String[] args) {
        List<Solution.Node> empty = new ArrayList<>();

        Solution.Node n1 = new Solution.Node(5, empty);
        Solution.Node n2 = new Solution.Node(6, empty);

        Solution.Node n3 = new Solution.Node(3, new ArrayList<>(Arrays.asList(n1, n2)));
        Solution.Node n4 = new Solution.Node(2, empty);
        Solution.Node n5 = new Solution.Node(4, empty);

        Solution.Node n6 = new Solution.Node(1,
            new ArrayList<>(
                Arrays.asList(n3, n4, n5)
            )
        );

        new Solution().levelOrder(n6);
    }
}
