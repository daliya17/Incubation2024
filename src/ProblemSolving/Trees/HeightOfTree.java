package ProblemSolving.Trees;

public class HeightOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);  // Left child of left subtree
        root.left.right = new TreeNode(5); // Right child of left subtree

        root.right.right = new TreeNode(6); // Right child of right subtree


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);  // Left child
        root1.right = new TreeNode(3); // Right child

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.left.left = new TreeNode(4);  // Left child of left subtree
        root2.left.right = new TreeNode(5); // Right child of left subtree

        root2.right.right = new TreeNode(6); // Right child of right subtree
        root2.left.left.left=new TreeNode(7);

        System.out.println(heightOfTree(root));
        System.out.println(heightOfTree(root1));
        System.out.println(heightOfTree(root2));
    }

    public static int heightOfTree(TreeNode node) {
        if (node == null)
            return -1;
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }
}
