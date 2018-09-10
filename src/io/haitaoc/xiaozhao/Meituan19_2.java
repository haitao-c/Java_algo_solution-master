package io.haitaoc.xiaozhao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Meituan19_2 {

    Map<Integer,Integer> map = new HashMap<>();

    public void run(){
        Scanner scan = new Scanner(System.in);
        String[] first = scan.nextLine().split(" ");
        int n = Integer.parseInt(first[0]), k=Integer.parseInt(first[1]), t=Integer.parseInt(first[2]);
        int[] num = new int[n];
        for (int i = 0; i <n ; i++) {
            num[i] = scan.nextInt();
        }

        System.out.println(count(num,k,t));
    }

    private int count(int[] num,int k,int t){
        int res = 0;
        int l = 0;
        int r = k-1+l;
        for (; r<num.length;l++,r=k-1+l) {
            int number;
            for (int i = l; i <= r; i++) {
                if(!map.containsKey(num[i])){
                    map.put(num[i],1);
                    number = 1;
                }else{
                    number = map.get(num[i]);
                    map.put(num[i],++number);
                }
                if(number >=t)
                {
                    res++;
                    map.clear();
                    break;
                }
            }
            map.clear();


        }

        return res;
    }

    public static void main(String[] args) {
        new Meituan19_2().run();
    }
}
