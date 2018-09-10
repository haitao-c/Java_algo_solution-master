package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class ZhaoHang19_1 {

    public void run(){
        Scanner scan = new Scanner(System.in);
        String[] s = scan.nextLine().split(" ");
        int n = s.length;
        int[] p = new int[n];
        for (int i = 0; i <s.length ; i++) {
            p[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxProfit(p));

    }


        public int maxProfit(int[] prices) {
            // write your code here
            int result = 0;
            if( prices == null || prices.length == 0)
                return 0;
            int minbuy = prices[0];
            for(int i = 1;i< prices.length ;i++){
                // 最小的购买，最大的卖
                result = Math.max(result,prices[i] - minbuy);
                minbuy = Math.min(minbuy,prices[i]);
            }
            return result;
        }




    public static void main(String[] args) {
        new ZhaoHang19_1().run();
    }
}
