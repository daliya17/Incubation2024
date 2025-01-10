package ProblemSolving.Trees;

public class CountNodesInGivenRange {
    public static void main(String[] args ){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(100);
//        root.right.left.left = new TreeNode(30);
//        root.right.left.right = new TreeNode(45);
        int l=5;
        int h=100;
        System.out.println(countNodes(root,l,h));
    }

    public static int countNodes(TreeNode root, int l, int h){
        if(root==null)
            return 0;
        if(root.val>=l && root.val<=h)
            return 1+countNodes(root.left,l,h)+countNodes(root.right,l,h);
        else if(root.val<l)
            return countNodes(root.right,l,h);
        else
            return countNodes(root.left,l,h);
    }
}
