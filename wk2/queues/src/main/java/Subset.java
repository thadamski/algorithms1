import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by tadamski on 11/13/16.
 */
public class Subset {

    public static void main(String[] args) {
        if (args.length < 0) throw new IllegalArgumentException("Arguments required.");

        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> q = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            q.enqueue(item);
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(q.dequeue());
        }
    }

}
