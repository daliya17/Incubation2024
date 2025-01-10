package ProblemSolving.Trees;

public class CheckIfTreeBalanced {
    public static void main(String[] args){
       TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(3); // balanced tree

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);  // Left child
        root1.right = new TreeNode(3); // Right child
        root1.left.left = new TreeNode(4);  // Left child of left subtree
        root1.left.right = new TreeNode(5); // Right child of left subtree
        root1.right.right = new TreeNode(6); // Right child of right subtree
        root1.left.left.left=new TreeNode(7); // balanced tree

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.left.left = new TreeNode(5);

        System.out.println(isBalanced(root));
        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));
    }

    public static boolean isBalanced(TreeNode node){
        if(node==null)
            return true;
        int leftHeight = heightOfTree(node.left);
        int rightHeight = heightOfTree(node.right);
        return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(node.left) && isBalanced(node.right);
    }


    public static int heightOfTree(TreeNode node) {
        if (node == null)
            return -1;
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }


}
