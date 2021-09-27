package day4_Double_pointer3;
/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：
在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fanzhuanzifuchuandanci557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = reverseWords(s);
        System.out.println(s);
        System.out.println("hot test");
    }

    public static String reverseWords(String s) {
        StringBuilder s1 = new StringBuilder();
        int i=0;
        while (i < s.length()) {
            int left=i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            for (int right = i-1; right >=left ; right--) {
                s1.append(s.charAt(right));
            }
            while (i < s.length() && s.charAt(i) == ' ') {
                s1.append(' ');
                i++;
            }
        }
        return s1.toString();
    }
    /*普通做法
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        String res = "";
        for (String i : s1) {
            res+=singleWords(i)+" ";
        }
        return res.substring(0,res.length()-1);
    }

    public static String singleWords(String s) {
        char[] s1 = s.toCharArray();
        char temp;
        for (int i=0; i < s1.length / 2; i++) {
            temp=s1[i];
            s1[i] = s1[s1.length - 1 - i];
            s1[s1.length-1-i]=temp;
        }
        return new String(s1);
    }

     */
    }