package lesson_22_execution_service.lecture.fork_join;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {
    public static void main(String[] args) {

        // Custom input array elements
        int arr[] = {50, 32, 61, 50, 49, 50, 16, 71, 50, 94, 10, 90, 12, 50, 78, 98, 88, 99};

        // the element that is to
        // be searched in the arr
        int searchElement = 50;

        // assigning values to the
        // starting and ending indices
        int s = 0;
        int e = arr.length - 1;

        // Creating an object of the ForkJoinPool class
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        // Now creating an object of the SearchWork class
        SearchWork searchWork = new SearchWork(arr, s, e, searchElement);

        // submitting the task to the ForkJoinPool
        int freq = forkJoinPool.invoke(searchWork);

        // printing the result
        System.out.println("The number " + searchElement + " is found " + freq + " times.");
    }
}
