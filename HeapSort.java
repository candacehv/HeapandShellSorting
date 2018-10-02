
/* 
 * HeapSort.java (2018)
 * Author: Ryan Stansifer
 * Downloaded from: https://cs.fit.edu/~ryan/java/programs/sort/HeapSort.java
 */

/*
 * The HeapSort class holds methods heap_sort, swap, makeHeap, reheapUp, 
 * reheapDown, leftSubtree, rightSubtree, getLargerChild, and printArray
 * 
 * The methods in this class are used together to accept int array arguments
 * and sort input data into asc sorted order.
 */
public class HeapSort {
    static String outputLocation;


    private static void swap(int[] data, int i, int j)
    {
        final int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public void heap_sort(int[] data, int n)
    {
        makeHeap(data, n);

//        heap.printArray(data, n);
        for (int i = n - 1; i > 0; i--) {
            swap(data, 0, i); // data[0] is max
            // System.out.print(i + ": ");
            // printArray(data, n);
            reheapDown(data, i - 1);
        }
    }

    /*
     * This method builds a max heap from the input data
     * 
     * @input: int[] data is the initial input data
     * @input: int n is the size of the array
     * 
     * @precondition: n>0 
     * @precondition: data[] not empty
     * 
     * @postcondition: input data will be sorted in max heap order
     */
    private static void makeHeap(int[] data, int n)
    {
        for (int i = 1; i < n; i++) {
            reheapUp(data, i);
        }
    }

    /*
     * This method finds the left child of the current node
     * @input: int i is the index of the current node
     * @return: index of the left child
     * 
     */
    private static int leftSubtree(int i)
    {
        return 2 * i + 1;
    }

    /*
     * This method finds the right child of the current node
     * @input: int i is the index of the current node
     * @return: index of the right child
     * 
     */
    private static int rightSubtree(int i)
    {
        return 2 * i + 2;
    }

    /*
     * This method finds the parent of the current node
     * @input: int i is the index of the current node
     * @return: index of the parent of current node
     * 
     */
    private static int parent(int i)
    {
        return (i - 1) / 2;
    } // int division
    /*
     * private boolean hasLeftSubtree (int i) { return 2*i+1 < size; } private
     * boolean hasRightSubtree (int i) { return 2*i+2 < size; }
     */

    // Return the index of the root node's child with the larger key.
    // Precondition: root must be the index of an interior node
    private static int largerChild(int[] data, int root, int size)
    {
        final int leftChild = leftSubtree(root);
        final int rightChild = rightSubtree(root);
        if (rightChild < size && data[rightChild] > data[leftChild]) {
            return rightChild;
        }
        else {
            // Either no right subtree or left child is bigger
            return leftChild;
        }
    }

    // Assuming that the root of the heap is the only element out of
    // place, restore the heap property: data[Parent] >= data[Child]
    // O(log n)
    private static void reheapDown(final int[] data, int size)
    {
        int root = 0;
        while (2 * root + 1 < size) {
            // Root is an interior node
            final int maxChild = largerChild(data, root, size);
            final int r = data[root];
            final int max = data[maxChild];

            if (r >= max)
                break;
            // swap
            data[root] = max;
            data[maxChild] = r;
            root = maxChild;
        }
    }

    // Assuming that the last leaf of the heap is the only element out of
    // place, restore the heap property: data[Parent] >= data[Child]
    // O(log n)
    private static void reheapUp(final int[] data, int bottom)
    {
        while (bottom > 0) {
            final int parent = parent(bottom);
            final int b = data[bottom];
            final int p = data[parent];
            if (p >= b)
                break;
            // swap
            data[bottom] = p;
            data[parent] = b;
            bottom = parent;
        }
    }

    /*
     * This method sends arguments to overloaded printArray
     */
    public void printArray(int[] data, int n)
    {
        printArray(data, 0, n);
    }

    /*
     * This method prints the array from the first specified index through
     * index first+n
     * 
     * @input: data[] is array to be printed
     * @input: int first is the index of the first element to be printed
     * @input: int n is number of elements to print
     */
    public void printArray(int[] data, int first, int n)
    {
        WriteFile write = new WriteFile();
        System.out.print("[");
        
        for (int i = first; i < first + n; i++) {
            System.out.print(data[i] + " ");
            write.writeFile( outputLocation, (data[i] + " "));
        }
        System.out.println("]");
        write.writeFile(outputLocation, "]");
        write.writeLine(HeapSort.outputLocation );
    }

    public static void main(String[] args)
    {
        ReadFile read = new ReadFile();
        outputLocation = args[0];

        for (int n = 1; n < args.length; n++) {
            read.readFile(args[n]);
        }
    }
}
