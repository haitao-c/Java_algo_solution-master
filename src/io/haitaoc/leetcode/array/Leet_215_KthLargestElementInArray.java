package io.haitaoc.leetcode.array;

public class Leet_215_KthLargestElementInArray {

    // 用快速排序的partition方法, 左边的大, 右边的小 中间数在第几号位就是第几大
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        int rank;
        while (true) {
            rank = partition(nums, l, r);
            if (rank == k - 1)
                break;
            else if (rank > k - 1)
                r = rank;
            else
                l = rank+1;
        }

        return nums[rank];
    }

    private int partition(int[] nums, int l, int r) {  // 传递进来的数组区间为nums[l...r]
        int v = nums[l];
        int j = l;    // nums[l+1...j] > v, nums[j+1...i) < v
        for (int i = l + 1; i < r + 1; i++) {
            if (nums[i] > v) {
                swap(nums, j + 1, i);
                j++;
            }
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {        // 注意对于数组中元素的交换不能写成 swap(int a,int b)这样的交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new Leet_215_KthLargestElementInArray().findKthLargest(nums, k));

    }
}
