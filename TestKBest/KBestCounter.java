import java.util.PriorityQueue;
import java.util.*;
import java.io.*;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {

    PriorityQueue<T> heap;
    int k;

    public KBestCounter(int ks) {
        k = ks;
        heap = new PriorityQueue<T>();
    }

    public void count(T x) {
        //todo
        if(heap.size() < k){
            heap.add(x);
        }else{
            if(heap.peek().compareTo(x) < 0){
                heap.poll();
                heap.add(x); //insert is worst case Ologk
            }
        }
        
    }

    public List<T> kbest() {
        LinkedList<T> toreturn = new LinkedList<T>();
        while(heap.size() != 0){
            toreturn.add(0, heap.poll()); //k removes- so klogk
        }
        heap = new PriorityQueue<T>(toreturn); //should be O(k) so doesn't affect run time as much
        return toreturn;
    }
}
