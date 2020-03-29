package classes1;

public class Code_03_HeapSort extends Logarithm {

    @Override
    protected void algorithmToTest(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        heapSort(arr);
    }

    public void heapSort(int[] arr){
        //建堆
        int fatherNode = arr.length / 2 - 1;
        while (fatherNode >= 0){
            heapify(arr, fatherNode, arr.length);
            fatherNode--;
        }

        for (int size = arr.length; size > 1; size--){
            getMaxAndShift(arr, size);
        }

    }

    private void heapify(int[] arr, int index, int size) {
        if (arr == null || size < 2) {
            return;
        }
        while (index * 2 + 1 < size) {
            int childToComp =
                (index + 1) * 2 < size
                    ? ((arr[index * 2 + 1] > arr[index * 2 + 2])
                        ? index * 2 + 1
                        : index * 2 + 2)
                    : index * 2 + 1;

            if (arr[index] < arr[childToComp]){
                swap(arr, index, childToComp);
                index = childToComp;
            }else {
                break;
            }
        }
    }

    private void getMaxAndShift(int[] arr, int length){
        if (arr == null || length < 1){
            return;
        }
        swap(arr, 0, length -1 );
        heapify(arr, 0, length - 1);
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
        Code_03_HeapSort sort = new Code_03_HeapSort();
        sort.startToTest();
    }
}
