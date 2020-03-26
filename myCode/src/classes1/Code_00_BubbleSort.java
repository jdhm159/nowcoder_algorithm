package classes1;

import java.util.Arrays;

public class Code_00_BubbleSort {

    private static void bubbleSorting(int[] arr) {
        if (arr == null){
            return;
        }
        boolean isSwapped = false;
        for (int i = 0; i < arr.length - 1 ; i++){
            for (int j = 1; j < arr.length - i; j++){
                if (arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                    isSwapped = true;
                }
            }
            if (!isSwapped){    //可以将最好情况时间复杂度优化成O(n)
                break;
            }
        }
    }

    private static void swap(int[] arr, int a, int b){
        if (arr == null){
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    //辅助的测试算法，一般是实现非常简单且绝对正确的
    private static void comparator(int[] arr) {
        if (arr == null){
            return;
        }
        Arrays.sort(arr);     //可以直接使用jdk提供的排序方法，十分简单，jdk1.7后的排序原理是 快排的优化版，Dual-Pivot双轴快排
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null || arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());     //元素大小范围在 -maxValue+1 ~ maxValue，包含边界
        }
        return arr;
    }

    private static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        return Arrays.copyOf(arr,arr.length);
    }

    private static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static final void main(String[] args) {
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            bubbleSorting(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arrH = copyArray(arr);
        printArray(arr);
        bubbleSorting(arr);
        printArray(arr);

        printArray(arrH);
        comparator(arrH);
        printArray(arrH);
    }

}
