package sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
		int[] arr = {4,5,8,1,7,6,3,9,5,7};
		System.err.println("ԭ��������"+Arrays.toString(arr));
		System.out.println("����������:"+Arrays.toString(shellSort(arr)));
	}
	
	/**
	 * ��������������С��47��С���������Ч���ȶ���
	 * 
	 * �ο����ӣ�https://blog.csdn.net/riemann_/article/details/103153894��
	 * 
	 * �ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������
	 * ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ�裻
	 * �����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ�ã�
	 * �ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ�ã�
	 * ����Ԫ�ز��뵽��λ�ú�
	 * �ظ�����2~5��
	 * @param arr
	 */
	public static int[] insertSort(int[] sourceArray){
		// ��arr���п��������ı��������
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		
		int preIndex,current;
		for (int i = 1; i < arr.length; i++) {
			preIndex = i-1;
			current = arr[i];
			// ���ǰһ��ֵ�ȵ�ǰ�󣬾ͽ�ǰֵ������,ֱ���ҵ�����λ��
			while(preIndex >= 0 && arr[preIndex] > current){
				arr[preIndex+1] = arr[preIndex];
				preIndex--;
			}
			arr[preIndex+1] = current;
		}
		return arr;
	}
	
	/**
	 * ϣ�������������򣬸���Ч�Ĳ������򣬲��ȶ���
	 * �ο����ӣ�https://www.imooc.com/article/25556��
	 * 
	 * @param sourceArray
	 * @return
	 */
	public static int[] shellSort(int[] sourceArray){
		// ��arr���п��������ı��������
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        //����ÿ�ζ�/2
        for (int step = arr.length / 2; step > 0; step /= 2) {

            //���������鿪ʼ���в�������ֱ�����
            for (int i = step; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];

                // j - step ���Ǵ�������ͬ����ڵ�Ԫ��
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
