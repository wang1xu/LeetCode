package day5_Double_pointer4;
/*
给定一个头结点为 head的非空单链表，返回链表的中间结点。
如果有两个中间结点，则返回第二个中间结点。

示例 1：
输入：[1,2,3,4,5]
输出：此列表中的结点 3 (序列化形式：[3,4,5])
返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
注意，我们返回了一个 ListNode 类型的对象 ans，这样：
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.

示例2：
输入：[1,2,3,4,5,6]
输出：此列表中的结点 4 (序列化形式：[4,5,6])
由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

提示：
给定链表的结点数介于1和100之间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/middle-of-the-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class lianbiaozhongjianjiedian876 {
    public static void main(String[] args) {
        int[] l=new int[]{1,2,3,4,5,6};
        ListNode head = new ListNode(l[0]);
        ListNode p=head;
        for (int i = 1; i < l.length; i++) {
            p.next = new ListNode(l[i],null);
            p=p.next;
        }

        showListNode(head);
        p = middleNode(head);
        System.out.println(p.val);
    }
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static ListNode middleNode(ListNode head) {
        ListNode p;
        p=head;
        int counter = 0;
        while (p != null) {
            counter++;
            p=p.next;
        }
        int mid=0;
        p=head;
        System.out.println(counter);
        while (mid < (counter+1) / 2) {
            p = p.next;
            mid++;
        }
        return p;

         */
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
