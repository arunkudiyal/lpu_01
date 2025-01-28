public class BinaryTree {
    Node root;
    static class Node {
        int data;
        Node left, right;
        Node(int element) {
            this.data = element;
            this.left = this.right = null;
        }
    }
    BinaryTree() { this.root = null; }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();                     // root = null;
        // Level - 0
        tree.root = new Node(10);
        // Level - 1
        tree.root.right = new Node(30);
        tree.root.left = new Node(20);
        // level - 2
        tree.root.right.left = new Node(60);
        tree.root.left.left = new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.right = new Node(70);
    }
}
