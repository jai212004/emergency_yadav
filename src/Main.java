import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {17,12,-8,-11,14,-19,9,-4,-11,-12,-8,5,15,14,9,-19,12,5,0,18,13,-1,3,19,16,-13,-11,9};
        Arrays.sort(arr);
        for(int i : arr){
            System.out.println(i);
        }
        System.out.println(longestConsecutive(arr));
    }
    /*
    Given an array nums of n integers.

Return the length of the longest sequence of consecutive integers.
 The integers in this sequence can appear in any order.
Example 1:
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation:
The longest sequence of consecutive elements in the array is [1, 2, 3, 4],
which has a length of 4. This sequence can be formed regardless of the initial order
of the elements in the array.
     */
    public static int longestConsecutive(int[] nums) {
        int currentlen = 0;
        int longest_queue = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length-1 ; i++){
                if(nums[i]+1==nums[i+1]){
                    currentlen++;
                    if(currentlen>longest_queue){
                        longest_queue=currentlen;
                    }
                } else if (nums[i+1]==nums[i]) {
                    continue;
                } else{
                    currentlen=0;
                }
            }
        return longest_queue+1;
    }
}