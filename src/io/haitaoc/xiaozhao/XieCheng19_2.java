package io.haitaoc.xiaozhao;


import java.util.*;

public class XieCheng19_2 {

    List<Integer> res = new ArrayList<>();

    public void run(){
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int A = Integer.parseInt(scan.nextLine());
        Record[] records = new Record[n];
        for (int i = 0; i < n; i++) {
            String[] in = scan.nextLine().split(" ");
            int num = Integer.parseInt(in[0]);
            int ru =  Integer.parseInt(in[1]);
            int chu = Integer.parseInt(in[2]);
            records[i] = new Record(num,ru,chu);
        }

        Arrays.sort(records);
        search(records,A);
        Collections.sort(res);
        System.out.println(res);

    }

    private void search(Record[] records, int A){
        int l = 0, h = records.length-1;
        while(l<=h){            //[l...h]
           int mid = l+(h-l)/2;
           if(records[mid].ru<=A){
               for (int i = l; i <=mid ; i++) {
                   if(records[i].chu>=A)
                       res.add(records[i].num);
               }
               l = mid+1;
           }else {
               h = mid-1;
           }
        }
    }

    class Record implements Comparable<Record>{
        int num;
        int ru;
        int chu;
        public Record(){

        }
        public Record(int num,int ru,int chu){
            this.num = num;
            this.ru = ru;
            this.chu = chu;
        }
        @Override
        public int compareTo(Record o) {
            if(this.ru<o.ru)            // 由低到高排序(<时return -1),由高到低排序(>时return -1)
                return -1;
            else if(this.ru>o.ru)
                return 1;
            else {
                if(this.chu<o.chu)
                    return -1;
                else if(this.chu>o.chu)
                    return 1;
                else
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        new XieCheng19_2().run();
    }
}
