package day10_Recursion_Backtracking;

import java.awt.*;

/*
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

示例 1：
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]

示例 2：
输入：head = [1,2]
输出：[2,1]

示例 3：
输入：head = []
输出：[]
提示：
链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class fanzhuanlianbiao206 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        hebingyouxulianbiao21.showListNode(l1);

        ListNode newl = new ListNode();
        Solution1 solution = new Solution1();
        newl=solution.reverseList(l1);

        hebingyouxulianbiao21.showListNode(newl);
    }

}

class Solution1 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        digui(root, head);
        return root.next;
    }

    /*
    这里采用迭代的思路
    对于原链表，分成两部分，原头和剩余部分
    建立新头，不断将源头插入新头和其剩余部分
    最后即是反向链表
     */
    public void digui(ListNode root, ListNode current) {
        if (current == null) {
            return;
        }

        ListNode temp = current.next;

        ListNode roottemp = new ListNode();

        roottemp =root.next;
        root.next = current;
        root.next.next=roottemp;

        digui(root, temp);

    }
}