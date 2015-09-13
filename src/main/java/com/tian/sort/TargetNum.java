package com.tian.sort;

public class TargetNum {

	public void getTargetNum(int[] a, int nums) {
		qsort(a, 0, a.length - 1);
		for (int i = 0; i < a.length - 1; i++) {
			if ((i + nums - 1 < a.length - 1) && (a[i] == a[i + nums - 1])) {
				System.out.println(a[i]);
			}
		}
	}
	//  对目标数组进行快排
	private void qsort(int arr[],int l,int r) {
		int i = l,j = r;//,k=arr[(l+r)>>1];
		int k = arr[l];
		while (i<j) {
			while (arr[i] < k) i++;
			while (arr[j] > k) j--;
			if (i <= j) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		if (l<j) qsort(arr,l,j);
		if (i<r) qsort(arr,i,r);
	}
	
	volatile int i = 0;
	
	public static void main(String[] args) {

	}

}
