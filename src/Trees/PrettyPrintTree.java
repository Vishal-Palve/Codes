package Trees;

public class PrettyPrintTree {


    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


    static void printTree(Node root, String prefix, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (root.right != null) {
            printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + root.data);

        if (root.left != null) {
            printTree(root.left, prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);


        System.out.println("Binary Tree (Pretty Printed):\n");
        printTree(root, "", true);
    }
}

