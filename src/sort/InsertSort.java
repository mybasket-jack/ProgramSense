package sort;

import java.util.Arrays;

public class InsertSort {
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
            insertSort(arr1);
            ArrayUtils.rightMathod(arr2);
            if (!ArrayUtils.isEqual(arr1, arr2)) {
                succeed = false;
                ArrayUtils.printArray(arr3);
                break;
            }
        }
        System.out.println(succeed ? "succeed" : "you failed");
    }

    /**
     * 插入排序（数据量小于47，小数据排序高效，稳定）
     * <p>
     * 参考链接（https://blog.csdn.net/riemann_/article/details/103153894）
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     */
    public static void insertSort(int[] arr) {
        if (arr ==null || arr.length <2) {
            return ;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 希尔排序（增量排序，更高效的插入排序，不稳定）
     * 参考链接（https://www.imooc.com/article/25556）
     *
     * @param sourceArray
     * @return
     */
    public static int[] shellSort(int[] sourceArray) {
        // 对arr进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //增量每次都/2
        for (int step = arr.length / 2; step > 0; step /= 2) {

            //从增量那组开始进行插入排序，直至完毕
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                // j - step 就是代表与它同组隔壁的元素
                while (j - step >= 0 && arr[j - step] > temp) {
                    arr[j] = arr[j - step];
                    j = j - step;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }


}
