package io.haitaoc.xiaozhao;

import java.util.*;

public class XieCheng19_3 {

    Queue<Integer> q = new ArrayDeque();
    Map<Integer, Integer> count = new HashMap<>();
    int capacity;
    int size = 0;

    Map<Integer, Integer> map = new HashMap<>();

    public void run(){
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        capacity = n;

        while(scan.hasNextLine()){
            String[] in = scan.nextLine().split(" ");
            int len = in.length;
            if(in.length==3){
                int in1 = Integer.parseInt(in[1]);
                int in2 = Integer.parseInt(in[2]);
            }else if(in.length==2){
                int g1 = Integer.parseInt(in[1]);
                System.out.println(get(g1));
            }
        }

    }
    private int get(int key){
        if(map.containsKey(key))
            return map.get(key);
        else
            return -1;
    }

        public void put(int a, int b) {
            put(a, b);
        }

    public static void main(String[] args) {
        new XieCheng19_3().run();
    }
}