package sort;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr = {4,5,8,1,7,6,3,9,5,7};
		System.err.println("ԭ��������:"+Arrays.toString(arr));
		System.out.println("����������:"+Arrays.toString(sort(arr)));
	}
	
	/**
	 * �ο����ӣ�https://www.jianshu.com/p/0d383d294a80��
	 * 1������һ���� H[0����n-1]��
	 * 2���Ѷ��ף����ֵ���Ͷ�β������
	 * 3���Ѷѵĳߴ���С 1�������� shift_down(0)��Ŀ���ǰ��µ����鶥�����ݵ�������Ӧλ�ã�
	 * 4���ظ����� 2��ֱ���ѵĳߴ�Ϊ 1��
	 * 
	 * @param sourceArray
	 * @return
	 */
	public static int[]  sort(int[] sourceArray) {
		// ��������
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		int len = arr.length;
		// ������
		buildMaxMap(arr, len);
		System.err.println("�����Ѻ�"+Arrays.toString(arr));
		for (int i = len-1; i >0 ; i--) {
			swap(arr, 0, i);
			len--;
			heapify(arr, 0, len);
		}
		return arr;
	}
	
	/**
	 * �����󶥶�
	 * ÿ���ڵ��ֵ�����ڻ�������ӽڵ��ֵ���ڶ������㷨��������������
	 * @param arr
	 * @param len
	 */
	private static  void buildMaxMap(int[] arr,int len){
		int i = (int) Math.floor(len/2);
		for (; i >= 0; i--) {
			heapify(arr,i,len);
			System.out.println();
		}
	}
	
	private static void heapify(int[] arr,int i, int len){
		int left = 2 * i +1;
		int right = 2 * i +2;
		int largest = i;
		if (left < len && arr[left] > arr[largest]) {
			largest = left;
		}
		
		if (right < len && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if (largest != i) {
			swap(arr,i,largest);
			heapify(arr, largest, len);
		}
	}
	
	private static void swap(int[] arr,int i,int j ){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
