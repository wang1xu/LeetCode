package day2_Double_pointer;

import java.util.Arrays;

/*
给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。

进阶：
尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？

示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

示例2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]

提示：
1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class xuanzhuanshuzu189 {
    public static void main(String[] args) {
        int[] nums={-1};
        int k=3;
        rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        if (k != 0) {
            int[] r_nums = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                r_nums[(i + k) % nums.length] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = r_nums[i];
            }
        }

    }
}
