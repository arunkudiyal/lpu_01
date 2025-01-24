public class Queue {
    static class Node {
        int data;
        Node next;
        Node(int new_data) {
            this.data = new_data;
            this.next = null;
        }
    }
    Node front, rear;
    // Constructor to initialize the front and rear to null when the Queue is created for the first time
    Queue() { front = rear = null; }
    boolean isEmpty() {
        return front == null && rear == null;
    }
    void enqueue(int new_data) {
        Node new_node = new Node(new_data);
        if (rear == null) {
            front = rear = new_node;
            return;
        }
        // Add the new node at the end of the queue and change rear
        rear.next = new_node;
        rear = new_node;
    }
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        // Store previous front and move front one node ahead
        Node temp = front;
        front = front.next;
        // If front becomes null, then change rear also to null
        if (front == null) rear = null;
    }
    int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }
    int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return rear.data;
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Queue Front: " + q.getFront());
        System.out.println("Queue Rear: " + q.getRear());
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front: " + q.getFront());
        System.out.println("Queue Rear: " + q.getRear());
    }
}
