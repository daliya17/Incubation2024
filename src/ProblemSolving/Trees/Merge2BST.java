package ProblemSolving.Trees;

import java.util.List;
import java.util.Stack;

public class Merge2BST {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(100);
        root1.left = new TreeNode(50);
        root1.right = new TreeNode(300);
        root1.left.left = new TreeNode(20);
        root1.left.right = new TreeNode(70);

        TreeNode root2 = new TreeNode(80);
        root2.left = new TreeNode(40);
        root2.right = new TreeNode(120);

        merge(root1, root2);
    }

    public static void merge(TreeNode root1, TreeNode root2){

        List<Integer> res = new java.util.ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode current1 = root1;
        TreeNode current2 = root2;
        // insert all elements of tree1 in stack1 left to right
        // insert all elements of tree2 in stack2 left to right
        // pop elements from stack1 and stack2 and compare

        while(current1!=null || current2!=null || !stack1.empty()|| !stack2.empty()){
            while(current1!=null){
                stack1.push(current1);
                current1 = current1.left;
            }
            while (current2!=null){
                stack2.push(current2);
                current2 = current2.left;
            }
            if(stack2.empty() || (!stack1.empty() && stack1.peek().val<=stack2.peek().val)) {
                current1 = stack1.pop();
                res.add(current1.val);
                current1 = current1.right;
            }else{
                current2 = stack2.pop();
                res.add(current2.val);
                current2 = current2.right;
            }
        }
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }





    public static void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
