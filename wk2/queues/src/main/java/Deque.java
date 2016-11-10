/**
 * Linked List implementation of the Deque funtion
 *
 * Created by tadamski on 11/9/16.
 */
public class Deque<Item> implements Iterable<Item> {

    private

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
        throw new UnsupportedOperationException();
    }

    /** unit testing */
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    /** Internal reference class for Linked List implementation */
    private class Node {
        private final String item;
        private final Node next;
        private Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
