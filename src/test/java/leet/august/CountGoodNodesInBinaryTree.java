package leet.august;

public class CountGoodNodesInBinaryTree {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode child, int max) {
        if (child == null)
            return;

        if (max <= child.val) {
            count++;
            max = child.val;
        }
        dfs(child.left, max);
        dfs(child.right, max);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
