package day6_Sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

/*
给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

示例 1：
输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").

示例 2：
输入：s1= "ab" s2 = "eidboaoo"
输出：false

提示：
1 <= s1.length, s2.length <= 104
s1 和 s2 仅包含小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutation-in-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class zifuchuanpailie567 {
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        boolean flag = checkInclusion(s1, s2);
        System.out.println(flag);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length2 < length1) {
            return false;
        }
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < length1; i++) {
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }
       if (Arrays.equals(c1,c2)) {
            return true;
        }
        for (int i = length1; i  < length2; i++) {
            c2[s2.charAt(i-length1)-'a']--;
            c2[s2.charAt(i)-'a']++;
            if (Arrays.equals(c1,c2)) {
                return true;
            }
        }
        return false;
    }
}
