import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizing array implementations of a RandomizedQueue
 *
 * Created by tadamski on 11/12/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] master;
    private int head, tail = 0;

    /** construct an empty randomized queue */
    public RandomizedQueue() {
        this.master = (Item[]) new Object[1];
    }

    /** is the queue empty? */
    public boolean isEmpty() { return this.head == this.tail; }

    /** return the number of items on the queue */
    public int size() { return this.tail - this.head; }

    /** add the item */
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException("Enqueue does not accept null values");

        if (this.tail == this.master.length) {
            this.resize(2 * this.master.length);
        }

        this.master[this.tail++] = item;

        if (this.size() > 1) {
            StdRandom.shuffle(this.master, this.head, this.tail - 1);
        }
    }

    /** remove and return a random item */
    public Item dequeue() {
        // This prohibits head advancing past tail
        if (this.size() == 0) throw new NoSuchElementException("Can't dequeue an empty queue");

        // Get Element and then resize (reduce) if necessary
        Item item = this.master[this.head];
        this.master[this.head] = null;
        this.head++;

        int _size = this.size();
        int masterLength = this.master.length;
        if (_size > 0 && _size == masterLength / 4) {
            this.resize(masterLength / 2);
        }

        // Shuffle and remove nulls on dequeue instead of enqueue
        // so that sample

        return item;
    }

    /** return (but do not remove) a random item */
    public Item sample() {
        if (this.size() == 0) throw new NoSuchElementException("Can't sample an empty queue");
        else {
            int randomIdx = StdRandom.uniform(this.head, this.tail);
            return this.master[randomIdx];
        }
    }

    /** return an independent iterator over items in random order */
    public Iterator<Item> iterator() {
        // Create new array of type size (tail - head) to remove nulls
        Item[] copied = (Item[]) new Object[this.size()];
        this.copy(this.master, copied);
        StdRandom.shuffle(copied);

        return new ListIterator(copied);
    }

    private void resize(int capacity) {
        assert capacity > 0;

        int oldSize = this.size();
        Item[] resized = (Item[]) new Object[capacity];
        this.copy(this.master, resized);

        this.head = 0;
        this.tail = oldSize;
        this.master = resized;
    }

    /** Copies the non-null elements from one array to the other */
    private void copy(Item[] from, Item[] to) {
        // Track where the next entry should go to remove leading nulls
        for (int i = 0, nextIdx = 0; i < from.length; i++) {
            if (from[i] != null) {
                to[nextIdx++] = from[i];
            }
        }
    }

    /** unit testing */
    public static void main(String[] args) { }

    private class ListIterator implements Iterator<Item> {

        private final Item[] randomCopy;
        private final int randomCopyLength;
        private int currentIdx;

        public ListIterator(Item[] randomCopy) {
            this.randomCopyLength = randomCopy.length;
            assert this.randomCopyLength > 0;

            this.randomCopy = randomCopy;
            this.currentIdx = 0;
        }

        public void remove() { throw new UnsupportedOperationException(); }
        public boolean hasNext() { return this.currentIdx < this.randomCopyLength; }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            else {
                Item item = this.randomCopy[this.currentIdx];
                this.randomCopy[this.currentIdx] = null;
                this.currentIdx++;
                return item;
            }
        }
    }

}