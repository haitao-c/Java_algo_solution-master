package io.haitaoc.leetcode.dp;

import java.util.*;


public class Leet_120_Triangle {
    //1.递归方法
    public int minimumTotal1(List<List<Integer>> triangle) {
        return minimumTotal1(triangle,0,0);
    }
    private int minimumTotal1(List<List<Integer>> triangle, int i,int j){
        int res = 0;
        if(i==triangle.size()) return 0;
        res+=triangle.get(i).get(j)+Math.min(minimumTotal1(triangle,i+1,j),minimumTotal1(triangle,i+1,j+1));
        return res;
    }
    //2.记忆化搜索方法  自顶向下解决问题
    public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] memo=new int[size][size];
        for (int i = 0; i <size ; i++) {
            for (int j = 0; j <size ; j++) {
                memo[i][j]=-1;
            }
        }
        return minimumTotal2(triangle,0,0,memo);
    }
    private int minimumTotal2(List<List<Integer>> triangle, int i,int j,int[][] memo){
        if(i==triangle.size()) return 0;
        if(memo[i][j]==-1)
            memo[i][j]=triangle.get(i).get(j)+Math.min(minimumTotal2(triangle,i+1,j,memo),minimumTotal2(triangle,i+1,j+1,memo));
        return memo[i][j];
    }
    //3.动态规划方法   自底向上解决问题
    public int minimumTotal3(List<List<Integer>> triangle) {
        int row = triangle.size();
        List<Integer> lastList = triangle.get(row-1);
        int last = lastList.size()-1;
        // dp[i][j] 表示到第i行第j个元素为止的最小和
        int[][] dp = new int[row][last+1];
        dp[0][0] = triangle.get(0).get(0);
        // 初始化dp表
        for (int i = 0; i < row; i++) {
            List<Integer> temp =triangle.get(i);
            int size = temp.size();
            if(size<last){
                for (int k = size; k <= last; k++) {
                    dp[i][k]=0;
                }
            }

        }
        // 自底向上计算
        for (int i = 1; i < row; i++) {
            List<Integer> temp =triangle.get(i);
            int size = temp.size();
            for (int j = 0; j <= last; j++) {
                if(j<size) {
                    int val = temp.get(j);
                    if (j == 0) {                           // 到第i行0位置处的最小和为上一行的最小和+此处val值
                        dp[i][j] = dp[i - 1][j] + val;
                    }
                    if (j == (size - 1)) {                  // 到第i行最后一个位置处最小和为上一行的最小和+此处val值
                        dp[i][j] = dp[i - 1][j - 1] + val;
                    }
                    if (j > 0 && j < size - 1) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] , dp[i - 1][j] )+ val;
                    }
                }

            }
        }
        /* // 打印dp表中数据
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        // dp表中最后一行的每一个数字表示到到当前位置处的最小和
        // 取出最后一行中最小的元素就是最小和
        // lambda写法
        OptionalInt res= Arrays.stream(dp[row - 1]).reduce(Integer::min);
        if(res.isPresent())
            return res.getAsInt();
        else return 0;

        /*int k= row-1;
        int min = dp[k][0];
        for (int i = 0; i < dp[k].length; i++) {
            if(dp[k][i]<=min)
                min=dp[k][i];
        }
        return min;*/




    }


    public static void main(String[] args){
        List list1=new ArrayList();
        list1.add(2);
        List list2=new ArrayList();
        list2.add(3);
        list2.add(4);
        List list3=new ArrayList();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List list4=new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List list = new ArrayList();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        long startTime=System.currentTimeMillis();   //获取开始时间
        int res = new Leet_120_Triangle().minimumTotal3(list);
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+" ms");
        System.out.println(res);

    }
}

