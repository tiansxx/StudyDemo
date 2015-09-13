package com.tian.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
//		int[] a = new int[10];
//		for (int i = 0; i < 10; i++) {
//			a[i] = (int) (Math.random() * 100);
//		}
//		int[] a = {41, 42, 52, 89, 68, 73, 38, 73, 35, 15};
		int[] a= {88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262};
		System.out.println(Arrays.toString(a));
//		quickSort(a, 0, a.length - 1);
		qsort(a, 0, a.length - 1);
		getTargetNum(a, 3);
	}
	
	public static void getTargetNum(int[] a, int nums) {
		for (int i = 0; i < a.length - 1; i++) {
			if ((i+nums-1 < a.length-1) && a[i] == a[i + nums - 1]) {
				System.out.println(a[i]);
				return;
			}
		}
	}
	
	public static void quickSort(int[] a, int left, int right) {
		if (left < right) {
			int i = left;
			int j = right;
			int pivot = a[left];
			while (i < j) {
				while (i < j && a[j] > pivot) {
					j--;
				}
				a[i] = a[j];
				while (i < j && a[i] < pivot) {
					i++;
				}
				a[j] = a[i];
			}
			a[i] = pivot;
			System.out.println(Arrays.toString(a));
			quickSort(a, left, i - 1);
			quickSort(a, i + 1, right);
		}
	}
	
	static void qsort(int arr[],int l,int r) {
		int i = l,j = r;//,k=arr[(l+r)>>1];
		int k = arr[l];
		while (i<j) {
			while (arr[i] < k) i++;
			while (arr[j] > k) j--;
			if (i <= j) {
				System.out.println("i = " + i + ", j = " + j);
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		System.out.println(Arrays.toString(arr));
		if (l<j) qsort(arr,l,j);
		if (i<r) qsort(arr,i,r);
	}
	


}
