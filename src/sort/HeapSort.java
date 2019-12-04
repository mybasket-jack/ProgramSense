package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 1, 7, 6, 3, 9, 5, 7};
        System.err.println("原来的数组:" + Arrays.toString(arr));
        System.out.println("排序后的数组:" + Arrays.toString(sort(arr)));
    }

    /**
     * 参考链接（https://www.jianshu.com/p/0d383d294a80）
     * 1、创建一个堆 H[0……n-1]；
     * 2、把堆首（最大值）和堆尾互换；
     * 3、把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
     * 4、重复步骤 2，直到堆的尺寸为 1。
     *
     * @param sourceArray
     * @return
     */
    public static int[] sort(int[] sourceArray) {
        // 拷贝数组
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        // 建立堆
        buildMaxMap(arr, len);
        System.err.println("建立堆后" + Arrays.toString(arr));
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    /**
     * 建立大顶堆
     * 每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列
     *
     * @param arr
     * @param len
     */
    private static void buildMaxMap(int[] arr, int len) {
        int i = (int) Math.floor(len / 2);
        for (; i >= 0; i--) {
            heapify(arr, i, len);
            System.out.println();
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
