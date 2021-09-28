package day5_Double_pointer4;

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
进阶：你能尝试使用一趟扫描实现吗？
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class shanchulianbiaodaoshudiNgejiedian19 {
    public static void main(String[] args) {
        int[] l=new int[]{1,2};
        int n = 2;
        ListNode head = new ListNode(l[0],null);
        ListNode p=head;
        for (int i = 1; i < l.length; i++) {
            p.next = new ListNode(l[i],null);
            p=p.next;
        }
       showListNode(head);
        head = removeNthFromEnd(head, n);
        showListNode(head);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 0;
        ListNode p,d_p;
        ListNode new_head = new ListNode(-1,head);
        p=head;
        d_p=new_head;
        while (p != null) {
            counter++;
            p = p.next;
            //找到删除节点前一个位置
            if (counter > n) {
                d_p = d_p.next;
            }
        }
        d_p.next = d_p.next.next;
        return new_head.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {this.val = val;this.next = next;}
    }

        public static void showListNode(ListNode head) {
        ListNode p=head;
        while (p != null) {
            System.out.print(p.val+" ");
            p=p.next;
        }
        System.out.println();
    }
}
