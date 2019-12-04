package sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {4,5,8,1,7,6,3,9,5,7};
		System.err.println("原来的数组"+Arrays.toString(arr));
		System.out.println("排序后的数组:"+Arrays.toString(shellSort(arr)));
	}
	
	/**
	 * 插入排序（数据量小于47，小数据排序高效，稳定）
	 * 
	 * 参考链接（https://blog.csdn.net/riemann_/article/details/103153894）
	 * 
	 * 从第一个元素开始，该元素可以认为已经被排序；
	 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
	 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
	 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
	 * 将新元素插入到该位置后；
	 * 重复步骤2~5。
	 * @param arr
	 */
	public static int[] insertSort(int[] sourceArray){
		// 对arr进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		
		int preIndex,current;
		for (int i = 1; i < arr.length; i++) {
			preIndex = i-1;
			current = arr[i];
			// 如果前一个值比当前大，就将前值往后移,直到找到合适位置
			while(preIndex >= 0 && arr[preIndex] > current){
				arr[preIndex+1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex+1] = current;
		}
		return arr;
	}
	
	/**
	 * 希尔排序（增量排序，更高效的插入排序，不稳定）
	 * 参考链接（https://www.imooc.com/article/25556）
	 * 
	 * @param sourceArray
	 * @return
	 */
	public static int[] shellSort(int[] sourceArray){
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
