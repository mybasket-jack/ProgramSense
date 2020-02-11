package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度
 * @author FNMES
 */
public class SelectSort {

    /**
     * 选择排序
     *
     * 第一趟：从n个记录中找出关键码最小的记录和第一个记录交换；
     * 第二趟：从第二个记录开始的n-1个记录中再选出关键码最小的记录与第二个记录交换
     * 以此类推......
     * 第i趟，则从第i个记录开始的n-i+1个记录中选出关键码最小的记录与第i个记录交换，直到整个序列按关键码有序。
     *
     * @param sourceArray
     * @return
     */
    public static void simpleSelectSort(int[] sourceArray) {
        // 对arr进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
              minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
