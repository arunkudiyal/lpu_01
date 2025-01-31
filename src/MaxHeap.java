public class MaxHeap {
    // data members
    int[] heap; int size; int maxSize;
    MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        this.size = 0;
    }
    // helper functions
    public int left(int index) { return (2*index) + 1; }
    public int right(int index) { return (2*index) + 2; }
    public int parent(int index) { return (index-1) / 2; }
    public boolean isLeaf(int pos) {
        if(pos >= size/2 ) return true;
        else return false;
    }
    public void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }
    public void insert(int element) {
        int pos = size;
        heap[pos] = element;
        while(heap[pos] > heap[parent(pos)]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
        size += 1;
    }
    public int extractMax() {
        int deleted = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return deleted;
    }
    public void heapify(int pos) {
        if( isLeaf(pos) ) return;
        if( heap[pos] < heap[left(pos)] || heap[pos] < heap[right(pos)] ) {
            if(heap[left(pos)] < heap[right(pos)]) {
                swap(pos, right(pos));
                heapify(right(pos));
            } else {
                swap(pos, left(pos));
                heapify(left(pos));
            }
        }
    }
    public void display() {
        for(int i=0; i < size/2; i++) {
            System.out.print("Parent - " + heap[i] + " | ");
            System.out.print("Left - " + heap[left(i)] + " | ");
            System.out.print("Right - " + heap[right(i)] + " | ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(100);    // maxSize = 100, heap[100], size = 0;
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
        heap.insert(50);
        heap.insert(60);
        // topmost element = 60
        heap.display();

        System.out.println();

        System.out.println("Deleted Value - " + heap.extractMax());             // 60

        heap.display();                                                         // topmost - 50
    }
}
