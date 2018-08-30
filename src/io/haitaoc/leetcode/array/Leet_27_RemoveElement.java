package io.haitaoc.leetcode.array;

public class Leet_27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;   // nums[0...k)元素为!val的值
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]!=val) {
                if(i!=k)
                    swap(nums,i,k++);
                else
                    k++;
            }

        }
        return k;
    }
    private void swap (int[] nums,int i ,int j){        // 注意对于数组中元素的交换不能写成 swap(int a,int b)这样的交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums={3,2,2,3};
        int val = 3;
        System.out.println(new Leet_27_RemoveElement().removeElement(nums,val));
        for(int a:nums)
            System.out.print(a+" ");

    }
}
