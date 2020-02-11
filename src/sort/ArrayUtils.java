package sort;

import java.util.Arrays;

/**
 * 数组工具类
 *
 * @Author jack
 * @Since 1.0 2020/2/7 21:49
 */
public class ArrayUtils {

    /**
     * 生成随机数组
     * @param size
     * @param value
     * @return
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size+1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value+1) * Math.random()) - (int)((value) * Math.random());
        }
        return arr;
    }

    /**
     * 拷贝数组
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) && (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
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

    /**
     * 绝对正确的方法
     * @param arr
     */
    public static void rightMathod(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}
