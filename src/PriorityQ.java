import java.util.PriorityQueue;
public class PriorityQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(25);
        pq.add(20);
        pq.add(15);
        pq.add(10);
        pq.add(5);

        System.out.println(pq.peek());          // 5
        System.out.println(pq);

        pq.remove(20);
        System.out.println(pq);

        System.out.println( pq.poll() );
        System.out.println(pq);
    }
}
