//Downloaded from: https://ide.geeksforgeeks.org/index.php
// GeeksforGeeks (2018)
//A computer science portal for geeks

/*
 * The ShellSort class holds methods printArray, and sort to order data
 * in ascending order through Shell Sort methods
 */
public class ShellSort {
    
    
    // Java implementation of ShellSort
    /* An utility function to print array of size n */
    void printArray(int arr[])
    {
        WriteFile write = new WriteFile();
        System.out.print("[");
        write.writeFile( HeapSort.outputLocation, "[");
        int n = arr.length;
        for (int i = 0; i < n; ++i)
        {
            System.out.print(arr[i] + " ");
            write.writeFile( HeapSort.outputLocation, arr[i] + " ");
        }
        System.out.println("]");
        write.writeFile( HeapSort.outputLocation, "]");
        write.writeLine(HeapSort.outputLocation );
    }

    /* function to sort arr using shellSort */
    /*
     * This method accepts the gap values and original data and sorts it
     * into asceding order through Shell Sort methods.
     * 
     * @input: int gaps[] is the array that holds the gap values to be used
     * Not all values will be used
     * @input: int arr[] is the array that holds the initial data from input
     * file
     * @precondition: arr[] and gaps[] must not be empty
     * @postcondition: arr[] will be in asc sorted order
     */
    int sort(int gaps[], int arr[])
    {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        int index = gaps.length - 1;
        for (; index > 0; index--) {
            if (gaps[index] >= arr.length && gaps[index - 1] < arr.length) {
                index--;
                index--;
                while (index >= 0) {
                    // Do a gapped insertion sort for this gap size.
                    // The first gap elements a[0..gap-1] are already
                    // in gapped order keep adding one more element
                    // until the entire array is gap sorted
//                    System.out.print("Gap width: " + gaps[index] + "\t");
//                    write.writeFile( HeapSort.outputLocation, 
//                                ("Gap width in use: " + gaps[index] + "\t"));
                    for (int i = gaps[index]; i < n; i += gaps[index]) {
                        // add a[i] to the elements that have been gap
                        // sorted save a[i] in temp and make a hole at
                        // position i
                        int temp = arr[i];

                        // shift earlier gap-sorted elements up until
                        // the correct location for a[i] is found
                        int j;
                        for (j = i; j >= gaps[index] && arr[j
                                        - gaps[index]] > temp; j -= gaps[index])
                            arr[j] = arr[j - gaps[index]];

                        // put temp (the original a[i]) in its correct
                        // location
                        arr[j] = temp;
                    }
                    index--;
                }
            }
        }
        return 0;
    }
}
/* This code is contributed by Rajat Mishra */
