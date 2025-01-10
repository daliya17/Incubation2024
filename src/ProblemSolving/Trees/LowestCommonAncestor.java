package ProblemSolving.Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);  // Left child of left subtree
        root.left.right = new TreeNode(5); // Right child of left subtree

        root.right.right = new TreeNode(6); // Right child of right subtree
        root.left.left.left=new TreeNode(7);
        root.left.left.right=new TreeNode(8);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(10);
        System.out.println(lowestCommonAncestor(root, root.left.left.left, root.left.right.right));// answer should be 2
        System.out.println(lowestCommonAncestor(root, root.left.left.left, root.left.left.right));// answer should be 4

       System.out.println(lowestCommonAncestor(root, root.left.left, root.left.right));
       // answer should be 2


    }

    public static int lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        List<Integer> APath = new ArrayList<>();
        pathToNode(root,A,APath);
        List<Integer> BPath = new ArrayList<>();
        pathToNode(root,B,BPath);
        HashSet<Integer> set = new HashSet<>(APath);
        for(int i=0;i<APath.size();i++){
            if(set.contains(BPath.get(i)))
                return BPath.get(i);
        }

        return 0;
    }

    public static boolean pathToNode(TreeNode root, TreeNode node, List<Integer> list){
        if(root==null)
            return false;
        if(root.val==node.val){
            list.add(root.val);
            return true;
        }
        if(pathToNode(root.left, node, list)|| pathToNode(root.right, node,list)){
            list.add(root.val);
            return true;
        }
        return false;
    }
}
