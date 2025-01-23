public class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int element) {
            this.data = element;
            this.next = null;
        }
    }
    static class DLLNode {
        int data;
        Node next, prev;
        DLLNode(int element) {
            this.data = element;
            this.next = this.prev = null;
        }
    }
    LinkedList() { this.head = null; }
    public void insertAtEnd(int element) {
        Node node = new Node(element);
        if(head == null) head = node;
        else {
            // step 1 --> searching to the end of the LL
            Node temp = head;
            while(temp.next != null)
                temp = temp.next;
            // last-most node
            temp.next = node;
        }
    }
    public void insertAtStart(int element) {
        Node node = new Node(element);
        if(head == null) head = node;
        else {
            node.next = head;
            head = node;
        }
    }
    public void insertAfter(int data1, int data2) {
        if(head == null) {
            System.out.println("List is Empty");
            return;
        }
        // step 1- search for data1 in list
        Node temp = head;
        while(temp != null && temp.data != data1)
            temp = temp.next;
        // step 2- insert data if found
        if(temp == null) {
            System.out.println(data1 + " does not exist in the list");
        } else {
            // data1 is found
            Node node = new Node(data2);
            Node nextNode = temp.next;
            temp.next = node;
            node.next = nextNode;
        }
    }
    // DELETION
    public void deleteFromEnd() {
        if(head == null) return;
        // iterate to the second-last node
        Node temp = head;
        while(temp.next.next != null)
            temp = temp.next;
        temp.next = null;
    }
    public void deleteFromStart() {
        if(head == null) return;
        head = head.next;
    }
    public void deleteElement(int element) {
        Node temp, slow, fast;
        temp = head; slow = fast = null;
        while(temp != null && temp.data != element) {
            fast = temp.next;
            slow = temp;
            temp = fast;
        }
        if(temp == null) return;
        if(slow == null) head = head.next;
        else slow.next = temp.next;
    }
    /*
    temp = head; slow = null; fast = temp.next
    while(fast!=null) {
        slow = temp;
        temp = fast;
        fast = fast.next.next;
    }
     */
    public void display() {
        if(head == null) System.out.println("List is Empty");
        else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            // temp = null
            System.out.println();
        }
    }
    public void printReverse(Node temp) {
        if(temp == null) return;
        printReverse(temp.next);
        System.out.print(temp.data + " ");
    }
    public static void main(String[] args) {
        // LinkedList is empty
        LinkedList ll = new LinkedList();                   // head = null
        ll.display();                                       // Empty
        ll.insertAfter(100, 200);
        ll.insertAtEnd(100);
        ll.insertAtEnd(200);
        ll.insertAtEnd(300);
        ll.insertAtEnd(400);
        ll.insertAtEnd(500);
        ll.display();                                       // 100 200 300 400 500
        ll.printReverse(ll.head);                           // 500 400 300 200 100

        ll.insertAtStart(10);
        ll.display();                                       // 10 100 200 300 400 500

        ll.insertAfter(200, 250);
        ll.display();                                       // 10 100 200 250 300 400 500

        ll.deleteFromEnd();
        ll.display();                                       // 10 100 200 250 300 400

        ll.deleteFromStart();
        ll.display();                                       // 100 200 250 300 400

        ll.deleteElement(250);
        ll.display();                                       // 100 200 300 400
    }
}