import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    public static void main(String[] args) {}

    private final Node<T> sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node<>(null, null, null);
        this.sentinel.next = this.sentinel;
        this.sentinel.prev = this.sentinel;
        this.size = 0;
    }

    private static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data, Node<T> next, Node<T> prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void addFirst(T x) {

        if (this.size == 0){

            this.sentinel.next = new Node<>(x, this.sentinel, this.sentinel);
            this.sentinel.prev = this.sentinel.next;

        } else {

            this.sentinel.next = new Node<>(x, this.sentinel.next, this.sentinel);
            this.sentinel.next.next.prev = this.sentinel.next;

        }
        this.size++;
    }

    @Override
    public void addLast(T x) {

        if (this.size == 0){

            this.addFirst(x);

        } else {

            this.sentinel.prev.next = new Node<>(x, this.sentinel, this.sentinel.prev);
            this.sentinel.prev = this.sentinel.prev.next;
            this.size++;
        }
    }

    @Override
    public List<T> toList() {

        if (this.size == 0){
            return null;
        }

        List<T> returnList = new ArrayList<>();

        Node<T> ptr = this.sentinel;

        for (int i = 0; i < this.size; i++){
            returnList.add(ptr.next.data);
            ptr = ptr.next;
        }

        return returnList;
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
        if (this.size == 0) {
            return null;
        }

        Node<T> ptr = this.sentinel.next;
        T returnValue = ptr.data;

        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = this.sentinel;
        this.size--;

        return returnValue;
    }

    @Override
    public T removeLast() {
        if (this.size == 0) {
            return null;
        }

        Node<T> ptr = this.sentinel.prev;
        T returnValue = ptr.data;


        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = this.sentinel;
        this.size--;

        return returnValue;
    }

    @Override
    public T get(int index) {
        if (index >= this.size || this.size == 0 || index < 0) {
            return null;
        }

        Node<T> ptr = this.sentinel;

        for (int i = 0; i <= index; i++){
            ptr = ptr.next;
        }

        return ptr.data;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
