import java.util.Iterator;

/**
 * Resizing array implementations of a RandomizedQueue
 *
 * Created by tadamski on 11/12/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] master;

    /** construct an empty randomized queue */
    public RandomizedQueue() {
        this.master = (Item[]) new Object[1];
    }

    /** is the queue empty? */
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    /** return the number of items on the queue */
    public int size() {
        return master.length;
    }

    /** add the item */
    public void enqueue(Item item) {
        throw new UnsupportedOperationException();
    }

    /** remove and return a random item */
    public Item dequeue() {
        throw new UnsupportedOperationException();
    }

    /** return (but do not remove) a random item */
    public Item sample() {
        throw new UnsupportedOperationException();
    }

    /** return an independent iterator over items in random order */
    public Iterator<Item> iterator() {
        throw new UnsupportedOperationException();
    }

    /** unit testing */
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }
}