package classes1;

import java.util.LinkedList;
import java.util.Queue;

public class Code_05_MergeSort extends Logarithm {

    @Override
    protected void algorithmToTest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public void mergeSort(int[] arr, int from, int to) {
        int dist = to - from;
        if (dist <= 1) {
            if (dist == 1) {
                if (arr[from] > arr[to]) {
                    swap(arr, from, to);
                }
            }
            return;
        }
        int mid = from + dist >> 1;
        mergeSort(arr, from, mid -1);
        mergeSort(arr, mid, to);
        merge(arr, from, to);
    }

    private void merge(int[] arr, int from, int to) {
//        int mid = (from + to) / 2;
        int mid = from + (to - from) >> 1;    //防止溢出
        int j = from;
        int k = mid;
        Queue<Integer> queue = new LinkedList<>();
        while (j < mid && k <= to) {
            queue.add(arr[j] < arr[k] ? arr[j++] : arr[k++]);
        }
        while (j < mid) {
            queue.add(arr[j++]);
        }
        while (k <= to) {
            queue.add(arr[k++]);
        }
        for (int i = from; i <= to; i++) {
            arr[i] = queue.poll();
        }
    }

    private void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        Code_05_MergeSort sort = new Code_05_MergeSort();
        sort.startToTest();

    }
}
