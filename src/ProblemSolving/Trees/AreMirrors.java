package ProblemSolving.Trees;

public class AreMirrors {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);  // Left child of left subtree
        root.left.right = new TreeNode(5); // Right child of left subtree

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);  // Left child
        root1.right = new TreeNode(2); // Right child
        root1.left.left = new TreeNode(5);  // Left child of left subtree
        root1.left.right = new TreeNode(4); // Right child of left subtree

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);  // Left child
        root2.right = new TreeNode(2); // Right child
        root2.right.left = new TreeNode(5);  // Left child of left subtree
        root2.right.right = new TreeNode(4); // Right child of left subtree

        System.out.println(IsMirror(root,root1));
        System.out.println(IsMirror(root,root2));
    }

    public static boolean IsMirror(TreeNode A, TreeNode B)
    {
        if(A==null && B==null)
            return true;
        if(A == null || B == null)
            return false;
        if(A.val!=B.val)
            return false;
        return IsMirror(A.left, B.right) && IsMirror(A.right, B.left);

    }
}
