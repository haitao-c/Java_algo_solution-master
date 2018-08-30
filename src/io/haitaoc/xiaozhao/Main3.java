package io.haitaoc.xiaozhao;


import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String str=scanner.next();
            int   cCount=first(str,'C');
            int   dCount=first(str,'D');
            System.out.println(Math.min(cCount, dCount));
        }

    }

    private static int first(String str,char firstChar) {
        int res=0;
        char []a=new char[str.length()];
        int cCount=0;
        for(int i=0;i<a.length;i++){
            a[i]=str.charAt(i);
            if(a[i]==firstChar){
                cCount++;
            }
        }
        for(int i=0;i<cCount;i++){
            int index=i;
            while(a[index]!=firstChar){
                index++;
            }
            for(int j=index;j>i;j--){
                char temp=a[j];
                a[j]=a[j-1];
                a[j-1]=temp;
                res++;
            }

        }
        //System.out.println(Arrays.toString(a));
        //System.out.println(res);
        return res;
    }

}