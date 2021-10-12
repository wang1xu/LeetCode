package day11_Recursion_Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]

示例 3：
输入：nums = [1]
输出：[[1]]
提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class quanpailie46 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> list = new ArrayList<>();
        list = solution.permute(nums);
        System.out.println(list);
    }
}

class Solution1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(list, new ArrayList<>(), nums);
        return list;
    }

    public void dfs(List<List<Integer>> res,List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i : nums) {
            if (path.contains(i)) {
                continue;
            }
            path.add(i);
            dfs(res,path,nums);
            path.remove(path.size()-1);
        }
    }

}