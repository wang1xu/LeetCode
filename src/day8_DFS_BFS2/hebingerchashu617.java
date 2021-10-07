package day8_DFS_BFS2;

/*
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
示例1:

输入: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
输出: 
合并后的树:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
注意:合并必须从两个树的根节点开始。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-two-binary-trees
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class hebingerchashu617 {
    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1.left=new TreeNode(3);
        r1.right=new TreeNode(2);
        r1.left.left = new TreeNode(5);
        r1.left.right = null;
        r1.right.left = null;
        r1.right.right = null;

        TreeNode r2 = new TreeNode(2);
        r2.left = new TreeNode(1);
        r2.right = new TreeNode(3);
        r2.left.right = new TreeNode(4);
        r2.left.left = null;
        r2.right.right = new TreeNode(7);
        r2.right.left=null;

        Solution solution = new Solution();
        TreeNode newTree = solution.mergeTrees(r1, r2);

        showTR(r1);
    }

    public static void showTR(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            showTR(treeNode.left);
            showTR(treeNode.right);
        }
    }
}
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return addTrees(root1,root2);
    }
    public TreeNode addTrees(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 != null) {
        return r2;
    }
    if ((r1 != null && r2 == null) || (r1 == null && r2 == null)) {
        return r1;
    }
    r1.val += r2.val;
    r1.left=addTrees(r1.left,r2.left);
    r1.right = addTrees(r1.right, r2.right);
    return r1;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
