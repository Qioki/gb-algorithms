import java.util.NoSuchElementException;

public class Deque {

    private int[] deque;

    private int capacity;
    private int head;
    private int tail;
    private int items;

    public Deque(int capacity) {
        this.capacity = capacity;
        deque = new int[capacity];
        head = 0;
        tail = -1;
        items = 0;
    } public boolean isEmpty() {
        return items == 0;
    }

    public boolean isFull() {
        return items == capacity;
    }

    public int size() {
        return items;
    }
 
    
    public void addLast(int value) {
        if (isFull()) {
            resize();
        }
        if (tail == capacity - 1)
            tail = -1;
        deque[++tail] = value;
        items++;
    }
    public void addFirst(int value) {
        if (isFull()) {
            resize();
        }
        if (head == 0)
            head = capacity;
        deque[--head] = value;
        items++;
    }


    private void resize() {
        capacity *= 2;
        int[] newQ = new int[capacity];
        if (tail >= head) {
            System.arraycopy(deque, 0, newQ, 0, deque.length);
        } else {
            System.arraycopy(deque, 0, newQ, 0, tail + 1);
            System.arraycopy(deque, head,
                    newQ, capacity - (deque.length - head),
                    deque.length - head - 1);
        }
        deque = newQ;
    }

    public int pollFirst() {
        if (isEmpty())
            throw new NoSuchElementException("deque is empty");
        int temp = deque[head++];
        head %= capacity;
        items--;
        return temp;
    }
    public int pollLast() {
        if (isEmpty())
            throw new NoSuchElementException("deque is empty");
        int temp = deque[tail--];
        tail = (tail + capacity) % capacity;
        items--;
        return temp;
    }
    public int peekFirst() {
        return deque[head];
    }

    public int peekLast() {
        return deque[tail];
    }

}
