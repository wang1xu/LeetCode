package day13_Bit_compute;
/*
编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。

提示：
请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3中，输入表示有符号整数 -3。

示例 1：
输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011中，共有三位为 '1'。

示例 2：
输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000中，共有一位为 '1'。

示例 3：
输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

提示：
输入必须是长度为 32 的 二进制串 。
进阶：
如果多次调用这个函数，你将如何优化你的算法？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-1-bits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class wei1degeshu191 {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int n= 00010;
        //String a="01000";
        //int d=Integer.parseInt(a,进制数，比如2) 二进制0100
        int ans = solution.hammingWeight(n);
        System.out.println(ans);

        System.out.println(n);
//        show();
    }

    public static void show() {
        int c=0b11111;//0b表示二进制
        int b=011;//0开头表示8进制
        int x=0x10;//16进制
        System.out.println(b);
    }
}

class Solution1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //统计1的个数 二进制 n&1求出末尾是否为1 为1则是n&1==1,即含有这一位
        int res=0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
