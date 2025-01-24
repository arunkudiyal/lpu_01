public class StackUsingArrays {
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX]; // Maximum size of Stack is MAX (1000)
    boolean isEmpty() { return (top < 0); }
    StackUsingArrays() { top = -1; }
    boolean push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }
    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else return a[top--];
    }
    int peek() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        } else return a[top];
    }
    void print() {
        for(int i = top;i>-1;i--) System.out.print(" "+ a[i]);
    }
    public static void main(String[] args) {
        StackUsingArrays stack = new StackUsingArrays();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop() + " Popped from stack");
        System.out.println("Top element is :" + stack.peek());
        System.out.print("Elements present in stack :");
        stack.print();
    }
}
