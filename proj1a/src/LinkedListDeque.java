import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class LinkedListDeque<T> implements Deque<T> {
    public static void main(String[] args) {
        Deque<Integer> lld = new LinkedListDeque<>();
    }

    private Node<Integer> sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new Node<>(42, null, null);
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

//        this.sentinel.next = new Node<>(x, this.sentinel.next, this.sentinel);
//        this.size++;
//
//        if (this.size == 1){
//            this.sentinel.prev = this.sentinel.next;
//            this.sentinel.next.next = this.sentinel;
//        }
        if (this.size == 0){
            this.sentinel.next = new Node<>(x, this.sentinel, this.sentinel);
            this.sentinel.prev = this.sentinel.next;
            this.size++;
        } else {
            this.sentinel.next = new Node<>(x, this.sentinel.next, this.sentinel);
            this.size++;
        }
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

        Node ptr = this.sentinel;

        for (int i = 0; i < this.size; i++){
            returnList.add((T) ptr.next.data);
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
