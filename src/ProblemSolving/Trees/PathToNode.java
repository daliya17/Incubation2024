package ProblemSolving.Trees;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);  // Left child of left subtree
        root.left.right = new TreeNode(5); // Right child of left subtree

        root.right.right = new TreeNode(6); // Right child of right subtree

        List<TreeNode> list = new ArrayList<>();
        // System.out.println(pathToNode(root, root.left.right, list));
      //  System.out.println(pathToNode(root, root.left,list));
        System.out.println(pathToNode(root, root.right.right,list));
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).val);
    }

    public static boolean pathToNode(TreeNode root, TreeNode node, List<TreeNode> list){
        if(root==null)
            return false;
        if(root.val==node.val) {
            list.add(node);
            return true;
        }
       if(pathToNode(root.left, node, list)|| pathToNode(root.right, node, list)){
           list.add(root);
                   return true;
       }

        return false;
    }
}
