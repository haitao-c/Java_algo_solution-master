package io.haitaoc.xiaozhao;

import java.util.Scanner;

public class ZhaoHang_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(binSearch(str));
    }


    public static String binSearch(String str) {
        int len = 2;
        while (str.length()/len>0){
            if(str.length()%len!=0){
                len++;
                continue;
            }else {
                StringBuilder sb =new StringBuilder();
                for(int i=0;i<len;i++){
                    sb.append(str.substring(0,str.length()/len));
                }
                if(sb.toString().equals(str)){
                    return str.substring(0,str.length()/len);
                }
                len++;
            }
        }
        return "false";
    }
}
