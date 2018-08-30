package io.haitaoc.leetcode.array;

public class Leet_283_MoveZeros {
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    public void moveZeroes2(int[] nums) {
        int k =0;       //nums中, [0...k)的元素均为非0元素 初始值为0表示一开始没有非0元素
        // 遍历到第 i个元素后, 保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        // 同时, [k...i]为0
        for (int i = 0; i <nums.length ; i++)
            if(nums[i]!=0)
                if(i!=k)
                    swap(nums, k++ ,i);
                else    // i==k
                    k++;
        }

        private void swap (int[] nums,int i ,int j){        // 注意对于数组中元素的交换不能写成 swap(int a,int b)这样的交换
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
        }

        public void moveZeroes(int[] nums) {
        int k =0;       //nums中, [0...k)的元素均为非0元素 初始值为0表示一开始没有非0元素
        // 遍历到第 i个元素后, 保证[0...i]中所有非0元素
        // 都按照顺序排列在[0...k)中
        for (int i = 0; i <nums.length ; i++)
            if(nums[i]!=0)
                nums[k++] = nums[i];

        // 将nums剩余的位置放置为0
        for (int i = k; i < nums.length ; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args){
        int[] nums={0,1,0,3,12};
        new Leet_283_MoveZeros().moveZeroes2(nums);
        for(int a: nums)
            System.out.print(a+" ");
    }
}
