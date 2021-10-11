package day11_Recursion_Backtracking;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。
示例 1：
输入：n = 4, k = 2
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

示例 2：
输入：n = 1, k = 1
输出：[[1]]

提示：
1 <= n <= 20
1 <= k <= n

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class zuhe77 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> l = solution.combine(4, 2);
        System.out.println(l);

    }
}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> path=new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(1, n, k);
        return res;
    }

    public void dfs(int startIndex, int n, int k) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝优化for (int i = startIndex; i <= n - (k - path.size()) + 1; i++)
       for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
//        for (int i = startIndex; i <= n ; i++) {
            path.add(i);
            dfs(i + 1, n, k);
            path.removeLast();
        }
    }
}
