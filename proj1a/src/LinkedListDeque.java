import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node(42, this.sentinel, this.sentinel);
        this.size = 0;
    }

    private class Node<T> {
        public T data;
        public Node next;
        public Node prev;

        public Node(T data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void addFirst(T x) {
        this.sentinel.next = new Node(x, this.sentinel.next, this.sentinel.prev);
        this.size++;
    }

    @Override
    public void addLast(T x) {
        this.sentinel.prev = new Node(x, this.sentinel.next, this.sentinel.prev);
        this.size++;
    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
