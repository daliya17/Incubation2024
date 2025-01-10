package ProblemSolving.Trees;

import java.util.List;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        System.out.println(kthSmallest(root, 5).val);
    }

    public static TreeNode kthSmallest(TreeNode root, int k) {
        if (root == null)
            return null;
        // Inorder traversal of BST gives elements in sorted order
        // So, we can do inorder traversal and keep track of kth element
        // When we reach kth element, return that element
        List<Integer> list = new java.util.ArrayList<>();
        inorder(root, list);
        return new TreeNode(list.get(k - 1));

    }

    public static void inorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);

        inorder(root.right, list);
    }
}
