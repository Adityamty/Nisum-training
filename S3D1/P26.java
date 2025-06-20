import java.util.Arrays;

public class MultiThreadedSort {

    static class SortThread extends Thread {
        private int[] arr;

        public SortThread(int[] arr) {
            this.arr = arr;
        }

        public void run() {
            Arrays.sort(arr);
        }

        public int[] getSortedArray() {
            return arr;
        }
    }

    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            merged[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] array = {9, 4, 7, 3, 2, 6, 1, 8, 5, 0};

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        SortThread leftSorter = new SortThread(left);
        SortThread rightSorter = new SortThread(right);

        leftSorter.start();
        rightSorter.start();

        leftSorter.join();
        rightSorter.join();

        int[] sortedArray = merge(leftSorter.getSortedArray(), rightSorter.getSortedArray());

        System.out.println("Sorted array: " + Arrays.toString(sortedArray));
    }
}
