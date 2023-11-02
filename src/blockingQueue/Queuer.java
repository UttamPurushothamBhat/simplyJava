package blockingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Queuer {
    int capacity;
    Queue<Integer> q;
    int count;

    Queuer(int capacity){
        this.capacity=capacity;
        q =new LinkedList<>();
        count=capacity;
    }

    boolean add(int val){
        synchronized (q) {
            System.out.println("trying to add "+ val);
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(val);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("added "+ val);
            q.notifyAll();
            return true;
        }
    }

    int remove() {
        synchronized (q) {
            System.out.println( "trying to remove ");
            while (q.size() == 0) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int val =  q.poll();
            System.out.println( "removed " + val);
            q.notifyAll();
            return val;
        }
    }

    int sum (){
        System.out.println(" sum = "+ count);
        return count++;
    }
}
