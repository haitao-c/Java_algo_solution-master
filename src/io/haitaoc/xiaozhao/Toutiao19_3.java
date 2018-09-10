package io.haitaoc.xiaozhao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Toutiao19_3 {
    List<String> list;

   public void run(){
       Scanner scan = new Scanner(System.in);
       String in = scan.nextLine();
       restoreIpAddresses(in);
       int count = list.size();
       System.out.println(count);

   }


    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<String>();
        addDot(s,"",3);

        return list;
    }

    private void addDot(String s,String result, int k){

        if(s.length() <= k){
            return;
        }
        if(s.length() > 3*(k+1)){
            return;
        }
        if(k == 0){
            if((s.charAt(0) == '0' && s.length() > 1 ) || Integer.parseInt(s) >= 256)
                return;
            list.add(result + "." + s);
            return;
        }

        for(int i = 1; i <= s.length(); i++){
            String temp = s.substring(0,i);
            if(Integer.parseInt(temp) < 256){
                String str = s.substring(i);
                if(result.length() > 0){
                    temp = result + "." + temp;
                }
                addDot(str,temp, k-1);
                if(s.charAt(0) == '0'){
                    break;
                }
            }else{
                break;
            }
        }
    }



    public static void main(String[] args) {
        new Toutiao19_3().run();

    }
}
