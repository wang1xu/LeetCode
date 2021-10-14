package day12_Dynamic_programming;
/*
假设你正在爬楼梯。需要 n阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class palouti70 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans = solution.climbStairs(45);
        System.out.println(ans);
    }
}
class Solution {

    public int climbStairs(int n) {
        //递归复杂度太高
//        if (n == 2) {
//            return 2;
//        } else if (n == 1) {
//            return 1;
//        }
//        return climbStairs(n - 2)+climbStairs(n-1);

        /*
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
       */
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int pre2=1;
        int pre1=2;
        int current = 0;
        for (int i = 2; i < n; i++) {
            current = pre1 + pre2;
            pre2=pre1;
            pre1=current;
        }
        return current;
    }
}
