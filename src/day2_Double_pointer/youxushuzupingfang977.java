package day2_Double_pointer;

import java.util.Arrays;

/*
给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]

示例 2：
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]

提示：
1 <= nums.length <= 110
-104 <= nums[i] <= 104
nums 已按 非递减顺序 排序

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class youxushuzupingfang977 {
    public static void main(String[] args) {
        int[] nums={-5,-3,-2,-1};
        int[] re_nums;
        re_nums = sortedSquares(nums);
        System.out.println(Arrays.toString(re_nums));
    }
    public static int[] sortedSquares(int[] nums) {
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }
        if(nums[nums.length-1]<=0){
            int[] r_nums = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                r_nums[nums.length-1-i] = nums[i] * nums[i];
            }
            return r_nums;
        }
        int left=0;
        int right=0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                left=i-1;
                right=i;
                break;
            }
        }
        int a;
        int b;
        int counter=0;
        int[] r_nums = new int[nums.length];

        while (true) {
            a = nums[left]*nums[left];
            b = nums[right]*nums[right];
            if (a < b) {
                r_nums[counter]=a;
                left--;
            }else{
                r_nums[counter]=b;
                right++;
            }
            if (left < 0) {
                for (int i = right; i < nums.length; i++) {
                    r_nums[i] = nums[i] * nums[i];
                }
                break;
            }
            if (right >= nums.length) {
                counter++;
                for (int i = left; i >= 0; i--) {
                    r_nums[counter] = nums[i] * nums[i];
                    counter++;
                }
                break;
            }
            counter++;
        }

        return r_nums;
        }
}
































