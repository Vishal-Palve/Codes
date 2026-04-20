package Trees;

class AVL {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
            this.height = 0; // Initialize height for new node
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public AVL() {
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            // Duplicate values - handle according to your needs
            // Option 1: Ignore (current behavior)
            // Option 2: Update count/frequency if you add that field
            return node;
        }

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Rebalance if needed
        return rotate(node);
    }

    private Node rotate(Node node) {
        int balance = getBalance(node);

        // Left Heavy
        if (balance > 1) {
            if (getBalance(node.left) >= 0) {
                // Left Left Case
                return rightRotate(node);
            } else {
                // Left Right Case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        // Right Heavy
        if (balance < -1) {
            if (getBalance(node.right) <= 0) {
                // Right Right Case
                return leftRotate(node);
            } else {
                // Right Left Case (was incorrectly commented as "left right case")
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        // Perform rotation
        c.right = p;
        p.left = t;

        // Update heights - FIXED: parentheses around max, then +1
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return c;
    }

    private Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        // Perform rotation
        p.left = c;
        c.right = t;

        // Update heights - FIXED: parentheses around max, then +1
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        return p;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Node found - handle 3 cases

            // Case 1: Leaf node
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children - find inorder successor (smallest in right subtree)
            Node successor = findMin(node.right);
            node.value = successor.value;
            node.right = delete(node.right, successor.value);
        }

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Rebalance if needed
        return rotate(node);
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void populate(int[] nums) {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value + " (Height: " + node.height + ")");
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1
                && balanced(node.left)
                && balanced(node.right);
    }

    // Utility method to get root value (for testing)
    public Integer getRootValue() {
        return root != null ? root.value : null;
    }
}