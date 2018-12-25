import java.util.*;

public class Tester {

    public static void main(String [] args){

        //MaxHeap

        Heap.MaxHeap maxHeap = new Heap.MaxHeap();

        maxHeap.add(3);
        maxHeap.add(-3);
        maxHeap.add(0);
        maxHeap.add(2);
        maxHeap.add(15);


        System.out.println("MaxHeap");
        maxHeap.displayHeap();
        System.out.println("\n");

        //MinHeap

        Heap.MinHeap minHeap = new Heap.MinHeap();

        minHeap.add(3);
        minHeap.add(-3);
        minHeap.add(0);
        minHeap.add(2);
        minHeap.add(15);

        System.out.println("MinHeap");
        minHeap.displayHeap();
    }
}
