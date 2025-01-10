package ProblemSolving.Trees;

import java.util.AbstractMap;
import java.util.Stack;

public class SumOfPathsToAllLeafNodes {
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(100);
        System.out.println(sumOfPathsToAllLeafNodes(root));
    }

    public static int sumOfPathsToAllLeafNodes(TreeNode root){
        if(root==null)
            return 0;
        Stack<AbstractMap.SimpleEntry<TreeNode,Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root,0));
        int ans=0;
        while(!stack.empty()){
            AbstractMap.SimpleEntry<TreeNode,Integer> current = stack.pop();
            TreeNode key = current.getKey();
            int val = current.getValue();
            val = (val*10)+(key.val);
            if(key.right==null && key.left==null){
                ans+=val;
                continue;
            }
            if(key.right!=null){
                stack.push(new AbstractMap.SimpleEntry<>(key.right,val));
            }
            if(key.left!=null){
                stack.push(new AbstractMap.SimpleEntry<>(key.left,val));
            }
        }
        return ans;
    }
}
