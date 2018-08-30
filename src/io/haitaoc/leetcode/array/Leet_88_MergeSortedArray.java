package io.haitaoc.leetcode.array;

public class Leet_88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = new int[m];
        for (int i = 0; i < m; i++) {
            aux[i] = nums1[i];          // 先将nums1中的元素放入到aux辅助数组中
        }
        int j = 0, k = 0;
        for (int i = 0; i < m + n; i++) { // 将结果数组保存在nums1中
            // 分别移动两个指向aux和nums2的指针
            if (j >= m)
                nums1[i] = nums2[k++];
            else if (k >= n)
                nums1[i] = aux[j++];
            else if (aux[j] <= nums2[k])
                nums1[i] = aux[j++];
            else
                nums1[i] = nums2[k++];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3, n = 3;
        new Leet_88_MergeSortedArray().merge(nums1, m, nums2, n);
        for (int a : nums1)
            System.out.print(a + " ");

    }
}
