package io.haitaoc.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
    public String toString(){
        return "["+this.start+" "+this.end+"]";
    }
}
public class Leet_435_NonOverlapingIntervals {

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length==0||intervals==null)
            return 0;
        Arrays.sort(intervals, Comparator.comparingInt((Interval in) -> in.end));
        /*for (Interval in:intervals)
        System.out.println(in);*/
        int res = 1;
        int end = intervals[0].end;
        for (int i = 1; i <intervals.length ; i++) {
            if(intervals[i].start>=end) {
                res++;
                end=intervals[i].end;
            }
        }
        return intervals.length-res;

    }
    public static void main(String[] args){
        Interval[] intervals= {new Interval(1,100),new Interval(11,22),new Interval(1,11),new Interval(2,12)};
        System.out.println(new Leet_435_NonOverlapingIntervals().eraseOverlapIntervals(intervals));
    }
}
