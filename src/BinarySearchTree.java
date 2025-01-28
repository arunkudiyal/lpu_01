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

    public void insert(int data) { root = insertData(root, data); }
    public void inOrder() {
        inOrderTraversal(root);
        System.out.println();
    }
    public boolean search(int key) {
        Node searchRef = searchKey(root, key);
        if(searchRef == null) return false;
        else return true;
    }

    public Node insertData(Node temp, int element) {
        if(temp == null) return new Node(element);
        else if(element < temp.data) temp.left = insertData(temp.left, element);
        else if(element > temp.data) temp.right = insertData(temp.right, element);
        return temp;
    }
    public void inOrderTraversal(Node temp) {
        if(temp != null) {
            inOrderTraversal(temp.left);
            System.out.print(temp.data + " ");
            inOrderTraversal(temp.right);
        }
    }
    public Node searchKey(Node temp, int key) {
        if(temp == null || temp.data == key) return temp;
        else if(key < temp.data) return searchKey(temp.left, key);
        else if(key > temp.data) return searchKey(temp.right, key);
        return temp;
    }
    public void display(Node temp) {
        if(temp != null) {
            display(temp.right);
            System.out.print(temp.data + " ");
            display(temp.left);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();                      // root = null;
        bst.insert(60);
        bst.insert(30);
        bst.insert(10);
        bst.insert(20);
        bst.insert(100);
        bst.insert(120);
        bst.insert(80);
        bst.insert(70);
        bst.inOrder();

        System.out.println(bst.search(5));                              // false
        System.out.println(bst.search(100));                            // true
    }
}
