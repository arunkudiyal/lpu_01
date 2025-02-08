import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree {
    Node root;
    static class Node {
        int data;
        Node left, right;
        Node(int element) {
            this.data = element;
            this.left = this.right = null;
        }
    }
    BinarySearchTree() { this.root = null; }
    public void insert(int data) { root = insertIterative(root, data); }
    public void delete(int key) { root = deleteKey(root, key); }
    public int height() { return getHeight(root); }
    public void inOrder() {
        inOrderTraversal(root);
        System.out.println();
    }
    public void bfs() { BFS(root); }
    public int getHeight(Node root) {
        if(root == null) return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        return Math.max(lHeight, rHeight) + 1;
    }
    public boolean search(int key) {
        Node searchRef = searchKey(root, key);
        if(searchRef == null) return false;
        else return true;
    }
    public Node searchKey(Node temp, int key) {
        if(temp == null || temp.data == key) return temp;
        else if(key < temp.data) return searchKey(temp.left, key);
        else if(key > temp.data) return searchKey(temp.right, key);
        return temp;
    }
    public Node insertData(Node temp, int element) {
        if(temp == null) return new Node(element);
        else if(element < temp.data) temp.left = insertData(temp.left, element);
        else if(element > temp.data) temp.right = insertData(temp.right, element);
        return temp;
    }
    public Node insertIterative(Node root, int element) {
        if(root == null) return new Node(element);
        Node current = root;
        while(true) {
            if(element < current.data) {
                if(current.left == null) {
                    current.left = new Node(element);
                    break;
                }
                current = current.left;
            } else {
                if(current.right == null) {
                    current.right = new Node(element);
                    break;
                }
                current = current.right;
            }
        }
        return root;
    }
    public int findMin(Node root) {
        Node temp = root; int min = root.data;
        while(temp.left != null) {
            temp = temp.left;
            min = temp.data;
        }
        return min;
    }
    public int findMax(Node root) {
        Node temp = root; int max = root.data;
        while(temp.right != null) {
            temp = temp.right;
            max = temp.data;
        }
        return max;
    }
    public Node deleteKey(Node root, int key) {
        if(root == null) return root;
        else {
            // phase 1 - BST is available | Searching
            if(key < root.data) root.left = deleteKey(root.left, key);
            else if(key > root.data) root.right = deleteKey(root.right, key);
            else {
                // phase 2 - data is found | Deletion
                if(root.left == null) return root.right;
                else if(root.right == null) return root.left;
                else {
                    // node which contains exactly 2 children
                    root.data = findMin(root.right);
                    // int deleted = findMax(root.left);
                    root.right = deleteKey(root.right, root.data);
                }
            }
        }
        return root;
    }
    public void inOrderTraversal(Node temp) {
        if(temp != null) {
            inOrderTraversal(temp.left);
            System.out.print(temp.data + " ");
            inOrderTraversal(temp.right);
        }
    }
    public void BFS(Node root) {
        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node deleted = queue.poll();
            System.out.print(deleted.data + " ");
            if(deleted.left != null) queue.add(deleted.left);
            if(deleted.right != null) queue.add(deleted.right);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();                      // root = null;
        System.out.println(bst);                                            // #reference
        bst.insert(60);
        bst.insert(30);
        bst.insert(10);
        bst.insert(20);
        bst.insert(100);
        bst.insert(120);
        bst.insert(80);
        bst.insert(70);
        System.out.println("Height - " + bst.height());

        bst.bfs();                                                          // 60 30 100 10 80 120 20 70
        bst.inOrder();                                                      // 10 20 30 60 70 80 100 120

        System.out.println(bst.search(5));                              // false
        System.out.println(bst.search(100));                            // true

        bst.delete(60);
        bst.inOrder();                                                      // 10 20 30 70 80 100 120

        bst.delete(1);
        bst.inOrder();                                                      // 10 20 30 70 80 100 120
    }
}
