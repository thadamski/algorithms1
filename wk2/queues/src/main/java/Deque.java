import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List implementation of the Deque function
 *
 * Created by tadamski on 11/9/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private int n; // size of the stack
    private Node first; // top of stack
    private Node last; // bottom of stack

    /** Internal reference class for Linked List implementation */
    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    /** construct an empty deque */
    public Deque() {
        first = null;
        last = null;
        n = 0;

        assert check();
    }

    /** is the deque empty? */
    public boolean isEmpty() {
        return this.n == 0;
    }
    
    /** return the number of items on the deque */
    public int size() {
        return this.n;
    }
    
    /** add the item to the front */
    public void addFirst(Item item) {
        Node oldFirst = this.first;

        this.first = new Node();
        this.first.item = item;

        if (this.isEmpty()) {
            this.first.prev = null;
            this.first.next = null;

            this.last = this.first;
        } else if (this.n == 1) {
            this.first.next = oldFirst;
            this.first.prev = null;

            this.last.prev = this.first;
            this.last.next = null;
        } else {
            oldFirst.prev = this.first;
            this.first.next = oldFirst;
        }

        this.n++;
    }
    
    /** add the item to the end */
    public void addLast(Item item) {
        Node oldLast = this.last;

        this.last = new Node();
        this.last.item = item;

        if (this.isEmpty()) {
            this.last.next = null;
            this.last.prev = null;

            this.first = this.last;
        } else if (this.n == 1) {
            this.last.prev = oldLast;
            this.last.next = null;

            this.first.next = this.last;
            this.first.prev = null;
        } else {
            oldLast.next = this.last;
            this.last.prev = oldLast;
        }

        n++;
    }
    
    /** remove and return the item from the front */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");

        Item oldFirst = this.first.item;

        if (this.n == 1) {
            this.first = null;
            this.last = null;
        } else if (this.n == 2) {
            this.first = this.first.next;
            this.first.prev = null;

            this.last.prev = null;
        } else {
            this.first = this.first.next;
            this.first.prev = null;
        }

        n--;

        return oldFirst;
    }
    
    /** remove and return the item from the end */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");

        Item oldLast = this.last.item;

        if (this.n == 1) {
            this.first = null;
            this.last = null;
        } else if (this.n == 2) {
            this.last = this.last.prev;
            this.last.next = null;

            this.first.next = null;
        } else {
            this.last = this.last.prev;
            this.last.next = null;
        }

        n--;
        return oldLast;
    }
    
    /** return an iterator over items in order from front to end */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /** unit testing */
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    // check internal invariants
    private boolean check() {
        if (n < 0) return false;

        if (n == 0) {
            if (first != null && last != null) return false;
        } else if (n == 1) {
            if (first == null || last == null) return false;
            if (first.next != null || first.prev != null || last.next != null || last.prev != null) return false;
        } else {
            if (first == null || last == null) return false;
            if (first.next == null || first.prev != null || last.next != null || last.prev == null) return false;
        }

        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        numberOfNodes = 0;
        for (Node x = last; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        public void remove() { throw new UnsupportedOperationException(); }
        public boolean hasNext() { return current != null; }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }
}
