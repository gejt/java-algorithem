package xyz.zao123.algorithm;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println(inorderTraversal(root));
        System.out.println(afterorderTraversal(root));

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
