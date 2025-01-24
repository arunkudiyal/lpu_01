import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Stack;
import java.util.Queue;
public class Stacks {
    Node top;
    static class Node {
        int data;
        Node next;
    }
    Stacks() { this.top = null; }
    public void push(int element) {
        Node newNode = new Node();
        if(newNode == null) {
            System.out.println("Stack Overflow");
            return;
        }
        newNode.data = element;
        newNode.next = top;
        top = newNode;
    }
    public int peek() { return this.top.data; }
    public void pop() {
        if(top == null) {
            System.out.println("Stack Underflow");
            return;
        }
        top = top.next;
    }
    public void display() {
        Node temp = top;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        /* Stacks stacks = new Stacks();                       // top = null
        stacks.pop();                                       // Stack Underflow
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.display();                                   // 3 2 1

        stacks.pop();
        stacks.display();                                   // 2 1
        System.out.println( stacks.peek() );
         */

        /* int[] arr = new int[4];
        Stacks stacks = new Stacks();
        System.out.println(stacks);                                 // reference
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();

        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        al.remove(1);
        System.out.println(al);

        Iterator<Integer> itr = al.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
         */

        /* Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack);
         */

        Queue<Integer> queue = new LinkedList<>();

    }
}
