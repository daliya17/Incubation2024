package ProblemSolving.Trees;

public class CheckIfValidBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));
        // invalid BST
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        System.out.println(isValidBST(root1));
    }

    public static boolean isValidBST(TreeNode root){
        if(root==null)
            return true;
        if(root.left !=null && root.left.val>root.val)
            return false;
        if(root.right != null && root.right.val<root.val)
            return false;
        return true;
    }
}
