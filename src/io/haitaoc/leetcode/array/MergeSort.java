package io.haitaoc.leetcode.array;

// 归并排序 时间复杂度: O(nlogn)
public class MergeSort {
    public void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n - 1);
    }



    // 递归使用归并排序, 对arr[l...r]的范围进行排序
    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;
        // 分别对两边进行给归并排序
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 将两侧已经排好序的数组进行归并
        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];  // aux 范围: [0...r]

        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];      // aux是从0开始的, 而i从l开始的, 所以要取i-l的偏移量
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {              // 左边已经遍历完
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {           // 右边已经遍历完
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 8, 6, 3};
        new MergeSort().mergeSort(arr, arr.length);
        for (int a : arr)
            System.out.print(a + " ");
    }
}
