import java.util.Deque;
import java.util.LinkedList;

public class DequeNewApi {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        // offer(E e); 默认是从尾部进
//        deque.offerFirst("a");
//        deque.offerFirst("b");
//        deque.offerFirst("c");
        System.out.println(deque);

        // 这里虽然没有指定取First还是Last, 但是按照队列的特性 先进先出, 默认是peekFirst()
        // String str = deque.peek();
        // String str = deque.getFirst();
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            // deque.removeFirst()
            // System.out.println(deque.pop());
            // 双端队列的pop()默认是弹出列队头第一个元素
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
