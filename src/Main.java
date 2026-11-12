import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7 , 7, 8, 10};
        int[] res = searchRange(arr , 5);
        int[] arrr = getFloorAndCeil(arr, 2);
        for(int a : arrr){
            System.out.println(a);
        }
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

    /*
    Given an array of integers nums sorted in non-decreasing order,
     find the starting and ending position of a given target value.
      If the target is not found in the array, return [-1, -1].

Example 1:
Input: nums = [5, 7, 7, 8, 8, 10], target = 8

Output: [3, 4]

Explanation:The target is 8, and it appears in the array at indices 3 and 4,
 so the output is [3,4]
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] arr = new int[]{-1,-1};
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]==target){
                arr[0]=i;
                break;
            }
        }
        for(int i = nums.length-1 ; i >= 0 ; i--){
            if(nums[i]==target){
                arr[1]=i;
                break;
            }
        }
        return arr;
    }
    /*
    Given a sorted array of nums and an integer x,
    write a program to find the lower bound of x.

The lower bound algorithm finds the first and smallest index in a
 sorted array where the value at that index is greater than or equal
  to a given key i.e. x.

If no such index is found, return the size of the array.

Example 1:
Input : nums= [1,2,2,3], x = 2

Output:1

Explanation:

Index 1 is the smallest index such that arr[1] >= x.
     */

    public static int lowerBound(int[] nums, int x) {
        int first = nums.length;
        for (int i = 0 ; i < nums.length ; i++){
            if (nums[i]>=x){
                first=i;
                break;
            }
        }
        return first;
    }
    /*
    Given a sorted array of nums and an integer x,
     write a program
    to find the upper bound of x.

The upper bound of x is defined as the smallest
 index i such that nums[i] > x.

If no such index is found, return the size of the array.

Example 1:
Input : n= 4, nums = [1,2,2,3], x = 2

Output:3

Explanation:

Index 3 is the smallest index such that arr[3] > x.
     */
        public static int upperBound(int[] nums, int x) {
            int first = nums.length;
            for (int i = 0 ; i < nums.length ; i++){
                if (nums[i]>x) {
                    first = i;
                    break;
                }
            }
            return first;
        }
        /*
        brute
         */

        /*
        Given a sorted array nums and an integer x.
         Find the floor and ceil of x in nums.
          The floor of x is the largest element in the array which is smaller than or equal to x.
           The ceiling of x is the smallest element in the array greater than or equal to x.
         If no floor or ceil exists, output -1.
         Example 1:
         Input : nums =[3, 4, 4, 7, 8, 10], x= 5
        Output: 4 7
        Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.
         */
        public static int[] getFloorAndCeil(int[] nums, int x) {
            int[] arr = new int[2];
            int floor = -1;
            int ceiling = Integer.MAX_VALUE;
            boolean flag = false;
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i]<x && nums[i]>floor){
                    floor=nums[i];
                }else if(nums[i]>x && nums[i]<ceiling){
                    ceiling=nums[i];
                    flag=true;
                }else if(nums[i]==x){
                    ceiling=x;
                    floor=x;
                    flag=true;
                }
            }
            arr[0] = floor;
            if(flag){
                arr[1] = ceiling;
            }else{
                arr[1] = -1;
            }
            return arr;
        }
        /*
        brute
         */
}