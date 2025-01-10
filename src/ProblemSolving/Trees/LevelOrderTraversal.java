package ProblemSolving.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);  // Left child of left subtree
        root.left.right = new TreeNode(5); // Right child of left subtree

        root.right.right = new TreeNode(6); // Right child of right subtree
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(11);
        root.right.right.right = new TreeNode(12);
        root.right.right.right.right = new TreeNode(13);
        root.right.right.right.left = new TreeNode(15);
        root.left.left.left.left = new TreeNode(16);
        root.right.right.right.right.right = new TreeNode(14);
        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front != null) {
                System.out.println(front.val);

                if (front.left != null)
                    queue.add(front.left);
                if (front.right != null)
                    queue.add(front.right);
            }
        }
    }
}
