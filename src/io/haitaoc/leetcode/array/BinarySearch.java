package io.haitaoc.leetcode.array;

public class BinarySearch {
    public int binarySearch(int arr[], int n, int target){
        // 给左右边界值赋予实际的意义
        int l = 0, r= n;        //在[l...r)的范围里寻找target
        while(l<r){                     // 当l==r时,区间[l...r)是无效的 如[42,42) 是无效的[42,43)才返回42
            int mid = l+(r-l)/2;        // 防止整型溢出
            if(arr[mid]==target)
                return mid;
            if(target>arr[mid])
                l=mid+1;
            else
                r=mid;                  // 在区间在[l...r)范围相当于[l...r-1]
        }
        return -1;
        /*int l = 0, r=n-1;       //左右两个边界, 在[l...r]的范围里寻找target (循环不变量)
        while(l <=r ){           // 当l ==r 时, 区间[l...r]依然是有效的
             int mid = (l+r)/2;
             if(arr[mid]==target)
                 return mid;
             if(target>arr[mid]) {
                 l=mid+1;       // target在[mid...r]中
             }
             else
                 r = mid-1;
        }
        return -1;*/
    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5};
        int target = 3;
        System.out.println(new BinarySearch().binarySearch(arr,5,target));
    }
}
