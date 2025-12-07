package Trees;

import java.util.Scanner;

public class DynamicBinaryTree {


    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;
    Scanner sc = new Scanner(System.in);


    Node buildTree() {
        System.out.print("Enter data (-1 for no node): ");
        int data = sc.nextInt();


        if (data == -1) {
            return null;
        }


        Node newNode = new Node(data);

        System.out.println("Enter left child of " + data + ":");
        newNode.left = buildTree();

        System.out.println("Enter right child of " + data + ":");
        newNode.right = buildTree();

        return newNode;
    }


    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        DynamicBinaryTree tree = new DynamicBinaryTree();

        System.out.println("Build your binary tree:");
        tree.root = tree.buildTree();

        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);
    }
}

