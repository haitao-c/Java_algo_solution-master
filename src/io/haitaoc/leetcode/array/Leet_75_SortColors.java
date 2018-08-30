package io.haitaoc.leetcode.array;

public class Leet_75_SortColors {
    /**
     * 计数排序: 统计0,,1,2的个数
     *
     * @param nums
     */

    public void sortColors1(int[] nums) {
        int[] count = new int[3]; // 存放0,1,2三个元素的频率
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i <count[0] ; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i <count[1] ; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i <count[2] ; i++) {
            nums[index++] = 2;
        }
    }

    /**
     *  三路排序
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int zero=-1;              // nums[0...zero] ==0, 区间是前闭后闭的, 初始值不能设为0, 刚开始还没有遍历
        int two =nums.length;     // nums[two...n-1] ==2
        for (int i = 0; i < two; ) {        //注意  不是每次循环结束后都需要i++, 所以循环条件中去除了i++
            if(nums[i]==1)
                i++;
            else if (nums[i]==2){
                two--;           // nums[two]已经是2了, 所以找它的前一个进行交换
                swap(nums,i,two);
            }
            else {               // nums[i] == 0
                assert (nums[i]==0);
                zero++;
                swap(nums,zero,i);
                i++;
            }
        }

    }
    private void swap (int[] nums,int i ,int j){        // 注意对于数组中元素的交换不能写成 swap(int a,int b)这样的交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

    }
}
