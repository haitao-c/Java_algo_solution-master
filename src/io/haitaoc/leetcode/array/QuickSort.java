package io.haitaoc.leetcode.array;

public class QuickSort {
    // 对有重复键值的数组进行快速排序
    // 将arr[l...r]分为<v,==v,>v 三部分
    // 之后递归对<v, >v, 两部分进行三路快速排序
    public void quickSort3Ways(int[] arr, int n) {
        quickSort3Ways(arr, 0, n - 1);
    }

    private void quickSort3Ways(int[] arr, int l, int r) {
        if (l >= r)
            return;

        // partition
        int v = arr[l];

        int lt = l;   // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;  // arr[lt+1...i) == v

        while (i < gt){
            if(arr[i]<v){
                swap(arr,i,lt+1);
                lt++;
                i++;
            }
            else if(arr[i]>v){
                swap(arr,i,gt-1);
                gt--;
            }else{
                i++;
            }

        }
        swap(arr,l,lt);
        quickSort3Ways(arr,l,lt-1);
        quickSort3Ways(arr,gt,r);

    }

    // 对arr[l...r]部分进行快速排序
    public void quickSort(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
    }


    private void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p,使得arr[l...p-1]<arr[p]; arr[p+1...r]>arr[p]
    private int partition(int[] arr, int l, int r) {
        int v = arr[l];         // 快速排序的标志位

        // arr[l+1...j]<v; arr[j+1...i)>v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);

        return j;

    }

    private void swap(int[] nums, int i, int j) {        // 注意对于数组中元素的交换不能写成 swap(int a,int b)这样的交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 2, 2, 3};
        //new QuickSort().quickSort(arr, arr.length);
        new QuickSort().quickSort3Ways(arr,arr.length);
        for (int a : arr)
            System.out.print(a + " ");
    }

}
