import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List implementation of the Deque funtion
 *
 * Created by tadamski on 11/9/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;

    /** construct an empty deque */
    public Deque() {
        throw new UnsupportedOperationException();
    }

    /** is the deque empty? */
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }
    
    /** return the number of items on the deque */
    public int size() {
        throw new UnsupportedOperationException();
    }
    
    /** add the item to the front */
    public void addFirst(Item item) {
        throw new UnsupportedOperationException();
    }
    
    /** add the item to the end */
    public void addLast(Item item) {
        throw new UnsupportedOperationException();
    }
    
    /** remove and return the item from the front */
    public Item removeFirst() {
        throw new UnsupportedOperationException();
    }
    
    /** remove and return the item from the end */
    public Item removeLast() {
        throw new UnsupportedOperationException();
    }
    
    /** return an iterator over items in order from front to end */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /** unit testing */
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    /** Internal reference class for Linked List implementation */
    private class Node {
        private final Item item;
        private final Node next;
        private Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() { return current.next != null; }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
