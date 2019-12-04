package sort;

import java.util.Arrays;

/**
 * ѡ������
 * @author FNMES
 *
 */
public class SelectSort {

	/**
	 * ѡ������
	 * 
	 * ��һ�ˣ���n����¼���ҳ��ؼ�����С�ļ�¼�͵�һ����¼������
	 * �ڶ��ˣ��ӵڶ�����¼��ʼ��n-1����¼����ѡ���ؼ�����С�ļ�¼��ڶ�����¼����
	 * �Դ�����......
	 * ��i�ˣ���ӵ�i����¼��ʼ��n-i+1����¼��ѡ���ؼ�����С�ļ�¼���i����¼������ֱ���������а��ؼ�������
	 * @param sourceArray
	 * @return
	 */
	public static int[] simpleSelectSort(int[] sourceArray){
		// ��arr���п��������ı��������
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		for (int i = 0; i < arr.length; i++) {
			int temp;
			int index = i;
			
			for (int j = i+1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
