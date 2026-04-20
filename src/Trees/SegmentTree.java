package Trees;

public class SegmentTree {

    private static class Node {
        int data;              // Sum of the interval (or min/max)
        int startInterval;     // Start index of this segment
        int endInterval;       // End index of this segment
        Node left;             // Left child (first half)
        Node right;            // Right child (second half)

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    // Constructor: Build tree from array
    public SegmentTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    // Build tree recursively - O(n)
    private Node constructTree(int[] arr, int start, int end) {
        // Base case: leaf node (single element)
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        // Internal node: create and split interval
        Node node = new Node(start, end);

        // FIXED: Prevent integer overflow
        int mid = start + (end - start) / 2;

        node.left = constructTree(arr, start, mid);
        node.right = constructTree(arr, mid + 1, end);

        // Combine: sum of left and right (change for min/max)
        node.data = node.left.data + node.right.data;
        return node;
    }

    // Public query: Get sum in range [qsi, qei] - O(log n)
    public int query(int qsi, int qei) {
        // Input validation
        if (qsi > qei) {
            throw new IllegalArgumentException("Start index cannot be greater than end index");
        }
        if (qsi < root.startInterval || qei > root.endInterval) {
            throw new IndexOutOfBoundsException("Query range out of bounds");
        }
        return query(root, qsi, qei);
    }

    // Private query helper
    private int query(Node node, int qsi, int qei) {
        // Case 1: Node interval completely INSIDE query range
        // [qsi........[node]........qei]
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }

        // Case 2: Node interval completely OUTSIDE query range
        // [node]........qsi........qei  OR  qsi........qei........[node]
        if (node.endInterval < qsi || node.startInterval > qei) {
            return 0;  // Identity for sum
        }

        // Case 3: Partial overlap - recurse both children
        return query(node.left, qsi, qei) + query(node.right, qsi, qei);
    }

    // Public update: Set arr[index] = value - O(log n)
    public void update(int index, int value) {
        // Input validation
        if (index < root.startInterval || index > root.endInterval) {
            throw new IndexOutOfBoundsException("Index: " + index + " out of range ["
                    + root.startInterval + "-" + root.endInterval + "]");
        }
        update(root, index, value);
    }

    // Private update helper - FIXED: cleaner implementation
    private void update(Node node, int index, int value) {
        // Leaf node found: update it
        if (node.startInterval == node.endInterval) {
            node.data = value;
            return;
        }

        // Decide which child to go to
        int mid = node.startInterval + (node.endInterval - node.startInterval) / 2;

        if (index <= mid) {
            update(node.left, index, value);
        } else {
            update(node.right, index, value);
        }

        // Recalculate current node after child update
        node.data = node.left.data + node.right.data;
    }

    // Display tree structure
    public void display() {
        display(root, 0);
    }

    private void display(Node node, int level) {
        if (node == null) return;

        // Indent based on level
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indent.append("  ");
        }

        System.out.println(indent + "[" + node.startInterval + "-" + node.endInterval
                + "] = " + node.data);

        display(node.left, level + 1);
        display(node.right, level + 1);
    }

    // Get tree height
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // ============ BONUS: Range Minimum Query Version ============

    // Build min segment tree
    public static SegmentTree buildMinTree(int[] arr) {
        SegmentTree tree = new SegmentTree();
        tree.root = tree.constructMinTree(arr, 0, arr.length - 1);
        return tree;
    }

    // Private constructor for factory methods
    private SegmentTree() {}

    private Node constructMinTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }

        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;

        node.left = constructMinTree(arr, start, mid);
        node.right = constructMinTree(arr, mid + 1, end);

        // MIN instead of SUM
        node.data = Math.min(node.left.data, node.right.data);
        return node;
    }

    // Query minimum in range
    public int queryMin(int qsi, int qei) {
        return queryMin(root, qsi, qei);
    }

    private int queryMin(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        }
        if (node.endInterval < qsi || node.startInterval > qei) {
            return Integer.MAX_VALUE;  // Identity for min
        }
        return Math.min(queryMin(node.left, qsi, qei), queryMin(node.right, qsi, qei));
    }
}