import java.util.Objects;

public class DoublyLinkedList {

    private DoublyLinkedList.Node head;
    private DoublyLinkedList.Node tail;
    private int size;
    LinkedIterator iterator;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
        iterator = new LinkedIterator(this);
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void push(Cat c) {
        DoublyLinkedList.Node n = new DoublyLinkedList.Node(c);

        n.next = head;
        n.prev = tail;

        if(head == null) head = tail = n;
        head.prev = n;
        tail.next = n;

        head = n;
        size++;
    }

    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        head.prev = tail;
        tail.next = head;

        size--;
        return temp;
    }


    public boolean contains(Cat c) {
        while (iterator.hasNext()) {
            Node temp = iterator.next();
            if (temp.c == c)  return true;
            if(temp == tail)  return false;
        }
        return false;
    }


    public boolean delete(Cat c) {
        while (iterator.hasNext()) {
            if(iterator.next().c.equals(c)) {
                iterator.deleteCurrent();
                return true;
            }
        }
        return false;
    }



    private Node find(Cat c) {
        if (isEmpty()) return null;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            else
                current = current.next;
        }
        return current;
    }
    @Override
    public String toString() {
        DoublyLinkedList.Node current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }



    public class LinkedIterator {

        private DoublyLinkedList doublyLinkedList;
        private Node current;

        public LinkedIterator(DoublyLinkedList linkedList) {
            doublyLinkedList = linkedList;

        }

        public boolean insertAfter(Node newNode) {
            if(getCurrent() == null) return false;
            current.next.prev = newNode;
            current.next = newNode;

            return true;
        }
        public boolean insertBefore(Node newNode) {
            if(getCurrent() == null) return false;
            current.prev.next = newNode;
            current.prev = newNode;

            return true;
        }
        public void reset() {
            current = null;
        }
        public Node deleteCurrent() {
            if(getCurrent() == null) return null;
            Node temp = current;
            current.prev.next = current.next;
            current.next.prev = current.prev;

            return temp;
        }

        public Node getCurrent() {
            if(current == null)
                current = doublyLinkedList.head;
            return current;
        }

        public boolean hasNext() {
            if(getCurrent() == null) return false;
            return current.next != null;
        }

        public Node next() {
            if(current == null) {
                current = doublyLinkedList.head;
                return current;
            }
            else if(hasNext()){
                current = current.next;
                return current;
            }
            return null;
        }
    }

    private class Node {
        Cat c;
        DoublyLinkedList.Node next;
        DoublyLinkedList.Node prev;

        public Node(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return c.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DoublyLinkedList.Node node = (DoublyLinkedList.Node) o;
            return c.equals(node.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(c);
        }
    }
}
