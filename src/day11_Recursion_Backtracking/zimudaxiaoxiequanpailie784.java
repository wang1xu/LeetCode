package day11_Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例：
输入：S = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入：S = "3z4"
输出：["3z4", "3Z4"]

输入：S = "12345"
输出：["12345"]

提示：
S的长度不超过12。
S仅由数字和字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-case-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class zimudaxiaoxiequanpailie784 {
    public static void main(String[] args) {
        String s = "a1b2";
        Solution2 solution = new Solution2();

        List<String> res = new ArrayList<>();
        res = solution.letterCasePermutation(s);
        System.out.println(res);
    }
}

class Solution2 {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        List<Character> alphabetSet = new ArrayList<>();
        char[] sList = s.toCharArray();
        dfs(sList,0);
        return res;
    }

    public void dfs(char[] sList, int startIndex) {
        res.add(new String(sList));
        for (int i = startIndex; i < sList.length; i++) {
            if (!Character.isDigit(sList[i])) {
                char temp = sList[i];
                sList[i] = (char) (sList[i] - 'a' >= 0 ? sList[i] - 32 : sList[i] + 32);
                dfs(sList, i + 1);
                //没有下一行 'a1b2' -> [a1b2, A1b2, A1B2, A1b2]这样最后一个明显
                sList[i] = temp;//还原数组，不然之前的就一直下去 [a1b2, A1b2, A1B2, a1B2]
            }
        }
    }
}