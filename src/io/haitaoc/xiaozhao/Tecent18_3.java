package io.haitaoc.xiaozhao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一、题目描述：
 * 小Q的公司最近接到m个任务，第i个任务需要xi的时间去完成，难度等级为yi。
 * 小Q拥有n台机器，每台机器最长工作时间zi，机器等级wi。
 * 对于一个任务，它只能交由一台机器来完成，如果安排给它的机器的最长工作时间小于任务需要的时间，则不能完成，如果完成这个任务将获得200*xi+3*yi的收益。
 * 对于一台机器，它一天只能完成一个任务，如果它的机器等级小于安排给它的任务难度等级，则不能完成。
 * 小Q想在今天尽可能的去完成任务，即完成的任务数量最大。如果有多种安排方案，小Q还想找到收益最大的那个方案。
 * 输入描述：
 * 输入包括N+M+1行，
 * 输入的第一行为两个正整数n和m（1<=n,m<=100000），表示机器的数量和任务的数量。
 * 接下来n行，每行两个整数xi和yi（0<xi<1000,0<=yi<=100），表示每台机器的最大工作时间和机器等级。
 * 接下来m行，每行两个整数zi和wi（0<zi<1000,0<=wi<=100），表示每个任务需要的完成时间和任务的难度等级。
 * 输出描述：
 * 输出两个正整数，分别表示最大能完成的任务数量和获取的收益。
 */
class A implements Comparable<A> {
    int x;
    int y;

    public int compareTo(A o) {
        // TODO Auto-generated method stub
        if (this.x > o.x)
            return -1;//返回-1表示当前对象在前，即由高到底排序  ;return 1则为由低到高排
        else if (this.x < o.x)
            return 1;
        else { //如果x的值一样，则比较y的大小
            if (this.y > o.y)
                return -1;//由高到低排序
            else if (this.y < o.y)
                return 1;
            else
                return 0;  //如果x,y都相等，返回0
        }
    }
}

/**
 * 收益只与完成的任务x、y有关，且x、y越大，获得的收益越大，所以要优先完成x更大的任务，若x相等，则要优先完成y大的任务。
 *
 * 为保证上述完成要求，我们可以将任务的x按从大到小排序，若x相同，根据y从大到小排序，排序完成后，再给任务分配机器。
 *
 * 当有多台机器符合x条件，选择y满足条件的最小的wi
 */
public class Tecent18_3 {
    public static int Max = 100000;

    public void run() {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();//机器的数量
        int M = in.nextInt();//任务的数量

        int i, j, k;
        //引用类型数组初始化!!!!动态初始化由系统为数组元素分配默认的初始值：null，即每个数组元素的值都是null。
        A[] machine = new A[Max];//机器的工作时间和机器等级
        //m数组的Max个数组元素都是引用，而且这个引用并未指向任何有效的内存，因此每个数组元素的值都是null
        //因为每个数组元素都是null，这相当于定义了Max个连续的A变量，但这个变量还未指向任何有效的内存区，所以这Max个连续的A变量（m数组的数组元素）还不能使用。

        for (i = 0; i < N; i++) {
            machine[i] = new A();//！！！！如果没有这一句，对象都没有初始化，因为只创建了数组对象，而数组的每个元素都为null，所以运行的时候会抛出空指针异常。
            machine[i].x = in.nextInt();
            machine[i].y = in.nextInt();
        }

        A[] task = new A[Max];//任务需要完成的时间和任务难度
        for (i = 0; i < M; i++) {
            task[i] = new A();
            task[i].x = in.nextInt();
            task[i].y = in.nextInt();
        }
        //Arrays.sort(machine);//空指针错误,用Arrays.sort 的排序，必须保证数组里面不存在空值，

        A m[] = Arrays.copyOfRange(machine, 0, N);
        Arrays.sort(m);//自动调用compareTo
        //Collections.sort(m);//出现错误！！类型 Collections 中的方法 sort（List<T>）对于参数（A[]）不适用
//        for(i=0;i<N;i++){
//          System.out.println("###"+m[i].x+"###"+m[i].y);
//        }

        A t[] = Arrays.copyOfRange(task, 0, M);
        Arrays.sort(t);

        int mark[] = new int[100];//定义数组,并初始化，默认值就是0

        long sum = 0;
        int count = 0;

        for (i = 0, j = 0; i < M; i++) {
            while (j < N && t[i].x <= m[j].x) {
                mark[m[j].y]++;
                j++;
            }
            for (k = t[i].y; k < 100; k++) {
                if (mark[k] != 0) {
                    mark[k]--;
                    count++;
                    sum = sum + 200 * t[i].x + 3 * t[i].y;
                    break;
                }
            }
        }
        System.out.println(count + " " + sum);
    }


    public static void main(String[] args) {
        new Tecent18_3().run();
    }
}
