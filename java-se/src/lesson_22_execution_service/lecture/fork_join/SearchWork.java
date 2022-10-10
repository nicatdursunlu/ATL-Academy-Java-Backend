package lesson_22_execution_service.lecture.fork_join;

import java.util.concurrent.RecursiveTask;

public class SearchWork extends RecursiveTask<Integer> {
    int[] arr;
    int s, e;
    int searchElement;

    public SearchWork(int[] arr, int s, int e, int searchElement) {
        this.arr = arr;
        this.s = s;
        this.e = e;
        this.searchElement = searchElement;
    }

    @Override
    protected Integer compute() {
        // Returns the frequency computed by countFreq
        return countFrequency();
    }

    private Integer countFrequency() {
        // At the beginning
        // the c is set to 0
        int c = 0;

        // iterating using the for loop
        for (int j = s; j <= e; j++) {
            // if element is present in array
            if (arr[j] == searchElement) {
                // Increment the c by 1
                c = c + 1;
            }
        }

        // return the number of times the searched element
        // has occurred
        return c;

    }
}

