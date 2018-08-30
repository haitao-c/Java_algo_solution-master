package io.haitaoc.xiaozhao;

import java.util.LinkedList;
import java.util.List;

public class ZhaoHang_2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        DFS(res, "", 0, 0, n);
        return res;
    }

    public void DFS(List<String> res, String curr, int left, int right, int n) {
        if (left == n && right == n) {
            res.add(curr);
            return;
        }
        if (left < n) {
            DFS(res, curr + '(', left + 1, right, n);
        }
        if (right < left) {
            DFS(res, curr + ')', left, right + 1, n);

        }

    }
}
