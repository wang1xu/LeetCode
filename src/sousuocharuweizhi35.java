public class sousuocharuweizhi35 {
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=2;
        System.out.println(searchInsert(nums,target));
    }
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int index;
        while(left<=right){
            index = (right - left) / 2 + left;
            if(nums[index]==target) return index;
            if(nums[index]>target){
                right=index-1;
            }else{
                left=index+1;
            }

        }
        return left;

    }
}
