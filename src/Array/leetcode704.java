package Array;

/**
 * @author Judy
 * @create 2024-03-09-16:02
 */
public class leetcode704 {

    public static int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }

        if (nums.length == 1){
            return nums[0]==target?nums[0]:-1;
        }
        return precess(nums,0,nums.length-1,target);
    }

    public static int precess(int[] nums, int left, int right, int target){
        if(nums[left] == target){
            return left;
        }else if(nums[right] == target){
            return right;
        }else if(right == left+1){
            return -1;
        }else if (right == left){
            return -1;
        }

        int mid = left+(right-left)/2;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid]<target){
            return precess(nums,mid+1,right,target);
        }else{
            return precess(nums,left,mid-1,target);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,5};
        System.out.println(search(nums, 2));
    }

}
