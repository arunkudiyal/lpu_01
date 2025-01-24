public class QueueUsingArrays {
    int[] arr;
    int size;
    int capacity;
    int front;
    QueueUsingArrays(int qSize) {
        size = 0;
        front = 0;
        capacity = qSize;
        arr = new int[qSize];
    }
    void enqueue(int x) {
        if (size == capacity) return;
        arr[size] = x;
        size++;
    }
    void dequeue() {
        if (size == 0) return;
        // SHIFTING ELEMENTS IN THE ARRAY
        // shifting elements to the left, to clear out space for new elements based on index 'i'
        // as the size of the queue is static
        for (int i = 1; i < size; i++) arr[i-1] = arr[i];
        size--;
    }
    int getFront() {
        if (size == 0) return Integer.MIN_VALUE;
        return arr[front];
    }
    void display() {
        for (int i = front; i < size; i++) System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        QueueUsingArrays q = new QueueUsingArrays(4);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.getFront());
        q.dequeue();
        q.enqueue(4);
        q.display();
    }
}
