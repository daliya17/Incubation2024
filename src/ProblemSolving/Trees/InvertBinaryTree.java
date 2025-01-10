package ProblemSolving.Trees;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        inOrder(root1);
        invertTree(root1);
        inOrder(root1);

      //  inOrder(root);
        TreeNode invertedRoot = invertTree(root);
      //  inOrder(invertedRoot);

        // inverted tree
        // 4
        // 7
        //
    }

    public static TreeNode invertTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }
}
