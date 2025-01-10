package ProblemSolving.Trees;

public class TreeTraversals {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Preorder Traversal:");
        preorderTraversal(root);
        System.out.println("\nInorder Traversal:");
        inorderTraversal(root);
        System.out.println("\nPostorder Traversal:");
        postorderTraversal(root);
    }

    public static void preorderTraversal(TreeNode node){
        if(node==null)
            return;
        System.out.println(node.val);
        preorderTraversal(node.left);
        preorderTraversal(node.right);

    }

    public static void inorderTraversal(TreeNode node){
        if(node==null)
            return;
        inorderTraversal(node.left);
        System.out.println(node.val);
        inorderTraversal(node.right);
    }

    public static void postorderTraversal(TreeNode node){
        if(node==null)
            return;
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.println(node.val);
    }
}
