package xyz.zao123.algorithm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

// 如下二叉树，补充中序遍历方法，最后打印出结果： [B, A, D, C, E]
//        A
//       / \
//      B   C
//         / \
//        D   E

public class TreeTraversal {

    public static void main(String[] args) {

        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeC = new TreeNode('C', nodeD, nodeE);

        TreeNode nodeB = new TreeNode('B');
        TreeNode root = new TreeNode('A', nodeB, nodeC);

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversalWithStack(root));
        System.out.println(inorderTraversal(root));
        System.out.println(inorderTraversalWithStack(root));
        System.out.println(afterorderTraversal(root));
        System.out.println(afterorderTraversalWithStack(root));

    }

    private static List<Character> afterorderTraversalWithStack(TreeNode root) {

        List<Character> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        Stack<TreeNode>  stack = new Stack<>();
        afterOrderStack(stack,root);

        while (!stack.isEmpty()){
            list.add(stack.pop().getValue());
        }

        return list;
    }

    private static void afterOrderStack(Stack<TreeNode> stack, TreeNode root) {

        if(root == null){
            return;
        }

        stack.push(root);

        if(root.getRight()!=null){
            afterOrderStack(stack,root.getRight());
        }

        if(root.getLeft()!=null){
            afterOrderStack(stack,root.getLeft());
        }

    }

    private static List<Character> inorderTraversalWithStack(TreeNode root) {
        List<Character> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        Stack<TreeNode>  stack = new Stack<>();
        inOrderStack(stack,root);

        while (!stack.isEmpty()){
            list.add(stack.pop().getValue());
        }

        return list;
    }

    private static void inOrderStack(Stack<TreeNode> stack, TreeNode root) {
        if(root == null){
            return;
        }

        if(root.getRight()!=null){
            inOrderStack(stack,root.getRight());
        }

        stack.push(root);

        if(root.getLeft()!=null){
            inOrderStack(stack,root.getLeft());
        }
    }

    private static List<Character> preorderTraversalWithStack(TreeNode root){

        List<Character> list = new ArrayList<>();

        if(root==null){
            return list;
        }

        Stack<TreeNode>  stack = new Stack<>();
        preOrderStack(stack,root);

        while (!stack.isEmpty()){
            list.add(stack.pop().getValue());
        }

        return list;
    }

    private static void preOrderStack(Stack<TreeNode> stack, TreeNode root) {
        if(root == null){
            return;
        }
        if(root.getRight()!=null){
            preOrderStack(stack,root.getRight());
        }
        if(root.getLeft()!=null){
            preOrderStack(stack,root.getLeft());
        }
        stack.push(root);
    }


    private static List<Character> preorderTraversal(TreeNode root) {
        List<Character> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        list.add(root.getValue());

        if (root.getLeft() != null) {
            list.addAll(preorderTraversal(root.getLeft()));
        }

        if (root.getRight() != null) {
            list.addAll(preorderTraversal(root.getRight()));
        }

        return list;
    }



    private static List<Character> afterorderTraversal(TreeNode root) {
        List<Character> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.getLeft() != null) {
            list.addAll(afterorderTraversal(root.getLeft()));
        }

        if (root.getRight() != null) {
            list.addAll(afterorderTraversal(root.getRight()));
        }

        list.add(root.getValue());

        return  list;
    }

    public static List<Character> inorderTraversal(TreeNode root) {
        List<Character> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        if (root.getLeft() != null) {
            list.addAll(inorderTraversal(root.getLeft()));
        }
        list.add(root.getValue());

        if (root.getRight() != null) {
            list.addAll(inorderTraversal(root.getRight()));
        }

        return list;
    }
}

class TreeNode {
    Character value;
    TreeNode left;
    TreeNode right;

    TreeNode(Character val) {
        value = val;
    }

    TreeNode(Character val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
