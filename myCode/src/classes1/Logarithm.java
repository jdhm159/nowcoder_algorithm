package classes1;

import java.util.Arrays;

/**
 * 对数器 可继承版本
 */
public abstract class Logarithm {

    public static final int testTime = 5000;
    public static final int maxSize = 100;
    public static final int maxValue = 100;

    //要进行测试的算法，贪心策略经常使用对数器来进行校验，而不去直接证明正确性
    protected abstract void algorithmToTest(int[] arr);             //implement...
    //只有普通方法才能被重写，static、final和private方法不参与动态绑定

    //辅助的测试算法，一般是实现非常简单且绝对正确的
    private static void comparator(int[] arr) {
        //implement...
        Arrays.sort(arr);     //可以直接使用jdk提供的排序方法，十分简单，
        //jdk1.7后的排序原理是 快排的优化版，Dual-Pivot双轴快排,
        // 且默认排序顺序为从小到大，要求进行排序的数组的元素对象实现了comparable接口

        //而对于实现了List的特殊结构，比如ArrayList也有排序的需求，对其进行排序的如果先转成数组进行排序再转回ArrayList无疑是不可行的，
        //可以通过调用Collections.sort(arrayList)方法来对arrayList进行排序，当然，要求也是元素实现了comparable接口
    }

    private static int computeArrayLength(int[] arr) {
        //使用前判空是个好习惯，虽然这里使用到的地方并不需要到该操作
        if (arr == null) {
            return 0;
        }
        return arr.length;
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null || arr2 == null) {
            return true;
        }
        int size1 = computeArrayLength(arr1);
        int size2 = computeArrayLength(arr2);

        if (size1 != size2) {
            return false;
        }

        for (int i = 0; i < size1; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateRandomArray(int maxSize, int maxValue) {
        int size = (int) ((maxSize + 1) * Math.random());
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());     //元素大小范围在 -maxValue+1 ~ maxValue，包含边界
        }
        return arr;
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        return Arrays.copyOf(arr, arr.length);
    }

    private static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    protected void startToTest() {
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            algorithmToTest(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        int[] arrH = copyArray(arr);
        printArray(arr);
        algorithmToTest(arr);
        printArray(arr);

        printArray(arrH);
        comparator(arrH);
        printArray(arrH);
    }

}
