import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int length;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.size = 0;
        this.length = 8;
        this.items = (T[]) new Object[this.length];
        this.nextFirst = this.size + 1;
        this.nextLast = this.size + 2;
    }

    @Override
    public void addFirst(T x) {
        this.items[nextFirst] = x;
        this.size++;
        if (nextFirst == 0){
            nextFirst = this.length - 1;
        } else {
            nextFirst--;
        }
    }

    @Override
    public void addLast(T x) {
        this.items[nextLast] = x;
        this.size++;
        if (nextLast == this.length - 1){
            nextLast = 0;
        } else {
            nextLast++;
        }
    }

    @Override
    public List<T> toList() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
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
}
