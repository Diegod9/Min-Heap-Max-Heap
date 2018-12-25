import java.util.*;

/**
 * Extra Credit
 */


public  abstract class Heap extends AbstractQueue implements Queue {


    private static Vector<Integer> theData;

    Comparator<Integer> minComparator;
    Comparator<Integer> maxComparator;

    abstract class minHeapSort implements Comparator<Integer>{
    }
    abstract class maxHeapSort implements Comparator<Integer>{
    }


    static class MaxHeap {


        public MaxHeap() {
            theData = new Vector();
        }

        public MaxHeap(maxHeapSort t){

        }



        //return parent
        private int parent(int i) {

            if (i == 0)
                return 0;

            return (i - 1) / 2;
        }

        //return leftChild child
        private int leftChild(int i) {
            return (2 * i + 1);
        }

        //return right child
        private int rightChild(int i) {
            return (2 * i + 2);
        }

        // swap values at two indexes
        private void swap(int x, int y) {
            // swap with child having greater value
            Integer temp = theData.get(x);
            theData.setElementAt(theData.get(y), x);
            theData.setElementAt(temp, y);
        }


        private void compareDown(int i) {
            // get leftChild and right child of node at index i
            int left = leftChild(i);
            int right = rightChild(i);

            int largest = i;

            // compare theData.get(i) with its leftChild and right child
            // and find largest value
            if (left < size() && theData.get(left) > theData.get(i))
                largest = left;

            if (right < size() && theData.get(right) > theData.get(largest))
                largest = right;

            if (largest != i) {

                swap(i, largest);


                compareDown(largest);
            }
        }


        private void compareUp(int i) {
            if (i > 0 && theData.get(parent(i)) < theData.get(i)) {
                swap(i, parent(i));
                compareUp(parent(i));
            }
        }

        //return size of the heap
        public int size() {
            return theData.size();
        }

        //check if heap is empty or not
        public Boolean isEmpty() {
            return theData.isEmpty();
        }

        //add element to heap
        public void add(Integer key) {
            theData.addElement(key);
            int index = size() - 1;
            compareUp(index);
        }

        //function to remove and return element with highest priority
        public Integer poll() {
                //element with highest priority
                int root = theData.firstElement();
                //replace root of the heap with the last element of the vector
                theData.setElementAt(theData.lastElement(), 0);
                theData.remove(size() - 1);

                //call compareDown on root node
                compareDown(0);

                //return root element
                return root;
            }

        public void displayHeap() {
            System.out.print("Contents of Heap: ");
            while (!theData.isEmpty()) {
                System.out.print(poll() + " ");
            }
            System.out.println();
        }
    }


    static class MinHeap {


        public MinHeap() {
            theData = new Vector();
        }
        public MinHeap(minHeapSort g){

        }

        //return parent
        private int parent(int i) {
            if (i == 0)
                return 0;

            return (i - 1) / 2;
        }

        //return leftChild
        private int leftChild(int i) {
            return (2 * i + 1);
        }

        //return rightChild
        private int rightChild(int i) {
            return (2 * i + 2);
        }

        //swap values at two indexes
        private void swap(int x, int y) {
            // swap with child having greater value
            Integer tempValue = theData.get(x);
            theData.setElementAt(theData.get(y), x);
            theData.setElementAt(tempValue, y);
        }


        private void compareDown(int i) {
            int left = leftChild(i);
            int right = rightChild(i);
            int smallest = i;
            // compare theData.get(i) with its leftChild and rightChild
            // and find smallest value
            if (left < size() && theData.get(left) < theData.get(i))
                smallest = left;

            if (right < size() && theData.get(right) < theData.get(smallest))
                smallest = right;

            if (smallest != i) {
                //swap with child having lesser value
                swap(i, smallest);

                compareDown(smallest);
            }
        }
        private void compareUp(int i) {
            if (i > 0 && theData.get(parent(i)) > theData.get(i)) {
                swap(i, parent(i));
                compareUp(parent(i));
            }
        }

        //return size of the heap
        public int size() {
            return theData.size();
        }

        //check if heap is empty or not
        public Boolean isEmpty() {
            return theData.isEmpty();
        }

        //add key to heap
        public void add(Integer key) {
            theData.addElement(key);
            int index = size() - 1;
            compareUp(index);
        }


        public Integer poll() {
                int root = theData.firstElement();
                theData.setElementAt(theData.lastElement(), 0);
                theData.remove(size() - 1);
                compareDown(0);
                return root;
        }

        //function to remove all elements from priority queue
        public void displayHeap() {
            System.out.print("Contents of Heap: ");
            while (!theData.isEmpty()) {
                System.out.print(poll() + " ");
            }
            System.out.println();
        }

    }
}


