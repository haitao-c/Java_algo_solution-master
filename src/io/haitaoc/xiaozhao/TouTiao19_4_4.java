package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class TouTiao19_4_4 {

    public void run(){
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = scan.nextLine();
        }
        for (int i = 0; i <N ; i++) {
            for (int j = 1; j <words[i].length() ; j++) {
                String tmp = words[i].substring(0,j);
                boolean f = false;
                for (int k = 0; k <N ; k++) {
                    if(i!=k){
                        if(words[k].substring(0,j).equals(tmp)){
                            f = true;
                            break;
                        }
                    }
                    if(!f){
                        System.out.println(tmp);
                    }
                    if(j==words.length)
                        System.out.println(words[i]);
                }
            }
        }




    }

    class A{
        String s,ans;
        boolean finish;
        A() {finish=false;s=ans="";}
    }



    public static void main(String[] args) {
        new TouTiao19_4_4().run();
    }
}
