package classes1;

public class Code_04_QuickSort extends Logarithm {

    @Override
    protected void algorithmToTest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int from, int to) {
        int size = to - from + 1;
        if (size <= 2) {
            if (size == 2 && arr[from] > arr[to]) {
                swap(arr, from, to);
            }
            return;
        }
        int less = from - 1;
        int great = to + 1;
        swap(arr, from, from + (int) (Math.random() * (size)));
        int st = arr[from];        //随机选定的一个值
        int p = from + 1;
        while (p < great) {
            if (arr[p] == st) {
                p++;
            }else if (arr[p] < st) {
                swap(arr, ++less, p++);
            }else if (arr[p] > st) {
                swap(arr, --great, p);
            }
        }
        quickSort(arr, from, less);
        quickSort(arr, great, to);
    }

    private void swap(int[] arr, int a, int b) {
        if (arr == null || a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        Code_04_QuickSort sort = new Code_04_QuickSort();
        sort.startToTest();
    }
}
