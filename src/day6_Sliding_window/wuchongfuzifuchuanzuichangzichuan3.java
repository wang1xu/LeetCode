package day6_Sliding_window;
/*
给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
示例1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。

示例 4:
输入: s = ""
输出: 0

提示：
0 <= s.length <= 5 * 104
s由英文字母、数字、符号和空格组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class wuchongfuzifuchuanzuichangzichuan3 {
    public static void main(String[] args) {
        String s = "wwpww";
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int res=0;
        Set<Character> set = new HashSet<>();

        int left = 0, right = -1;
        while (left < s.length()) {
            if (right < s.length() - 1 && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}











