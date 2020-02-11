package sort;

/**
 * 递归学习
 * 递归是系统在压栈
 * 时间复杂度 T(N) = a*T(N/b) + O(N^d) N为夫问题的样本量 N/b子问题的样本量 a为发送的次数  O(N^d) 为除子过程调用之外剩下的时间复杂度
 * master公式（适应范围： 划分的子过程规模一样）
 *     log(b,a) > d -> 复杂度为O（N^log(b,a)
 *     log(b,a) = d -> 复杂度为O(N^d*logN)
 *     log(b,a) < d -> 复杂度为O(N^d)
 *
 * @Author jack
 * @Since 1.0 2020/2/7 22:52
 */
public class RecursiveLearn {

    /**
     * 判断最大的流程
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int getMax(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int mid = (L+R)/2;
        int maxLeft = getMax(arr,L,mid);
        int maxRight = getMax(arr,mid+1, R);
        return Math.max(maxLeft,maxRight);
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        System.out.println(getMax(arr,0,arr.length-1));
    }
}
