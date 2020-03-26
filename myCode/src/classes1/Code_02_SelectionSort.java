package classes1;

public class Code_02_SelectionSort extends Logarithm {

    @Override
    protected void algorithmToTest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr, i , minIndex);
//            swap(arr, i, getIndexOfMax(arr, i, length - 1));
        }
    }

//    private int getIndexOfMax(int[] arr, int from, int to) {
//        if (arr != null && from < to) {
//            for (int i = from; i < to; i++) {
//                if (arr[from] > arr[i + 1]) {
//                    from = i + 1;
//                }
//            }
//        }
//        return from;    //省掉了一个空间
//    }

    private void swap(int[] arr, int a, int b) {
        if (arr != null && a != b) {
            arr[a] = arr[a] ^ arr[b];
            arr[b] = arr[a] ^ arr[b];
            arr[a] = arr[a] ^ arr[b];
        }
    }

    public static final void main(String[] args) {
        Code_02_SelectionSort sorting = new Code_02_SelectionSort();
        sorting.startToTest();
    }
}
