package classes1;

public class Code_01_InsertionSort extends Logarithm {


    @Override
    protected void algorithmToTest(int[] arr) {
        if (arr != null && arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        if (arr != null) {
            arr[a] = arr[a] ^ arr[b];
            arr[b] = arr[a] ^ arr[b];
            arr[a] = arr[a] ^ arr[b];
        }
    }

    public static final void main(String[] args) {
        Code_01_InsertionSort sorting = new Code_01_InsertionSort();
        sorting.startToTest();
    }
}
