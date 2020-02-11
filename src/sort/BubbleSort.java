package sort;

/**
 * 冒泡排序
 * 复杂度 O(N2)
 * @Author jack
 * @Since 1.0 2020/2/6 23:09
 */
public class BubbleSort {
    public static void bubbortSort(int[] arr) {
        if (arr ==null || arr.length <2) {
            return;
        }
        for (int end = arr.length-1; end >0 ; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[ i + 1]) {
                    swap(arr, i, i+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 对数器测试
    public static void main(String[] args) {
        int testTime = 500000;
        int size = 10;
        int value = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = ArrayUtils.generateRandomArray(size,value);
            int[] arr2 = ArrayUtils.copyArray(arr1);
            int[] arr3 = ArrayUtils.copyArray(arr1);
            bubbortSort(arr1);
            ArrayUtils.rightMathod(arr2);
            if (!ArrayUtils.isEqual(arr1, arr2)) {
                succeed = false;
                ArrayUtils.printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "succeed" : "you failed");
    }
}
