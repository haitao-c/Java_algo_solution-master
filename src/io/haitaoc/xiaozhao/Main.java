package io.haitaoc.xiaozhao;

import java.util.ArrayList;
import java.util.List;

public class Main {
    int[] steps = new int[11];
    List<String> res = new ArrayList<>();

    public void run() {
        steps[1] = 1;
        steps[2] = 1;
        System.out.println(steps(10));
        System.out.println(res);

    }

    private int steps(int num) {
        if (num == 1) {
            res.add("2");
            return 1;
        }
        if (num == 2) {
            res.add("3");
            return 1;
        }

        if (num <= 0)
            return 0;

        if ((num - 1) % 2 == 0) {
            steps[num] = steps((num - 1) / 2) + 1;
            res.add("2");
        } else {
            steps[num] = steps((num - 2) / 2) + 1;
            res.add("3");
        }
        return steps[num];
    }

    public static void main(String[] args) {
        new Main().run();

    }
}