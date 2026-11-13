import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2 , 0 , 2 , 6, 4};
        //int[] res = searchRange(arr , 6);
        System.out.println(subarraysWithXorK(arr , 2));
        System.out.println(subarraywithxor(arr , 2));
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
    /*
    Given a sorted array of nums consisting of distinct integers and a target value,
    return the index if the target is found.
     If not, return the index where it would be if it were inserted in order.

Example 1:
Input: nums = [1, 3, 5, 6], target = 5

Output: 2

Explanation: The target value 5 is found at index 2 in the sorted array.
Hence, the function returns 2.
     */
        public static int searchInsert(int[] nums, int target) {
            int pos = -1;
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[0]>=target) {
                    pos = 0;
                }
                else if(nums[nums.length-1]<target){
                    pos = nums.length;
                }
                else {
                    if(nums[i]<target && nums[i+1]>=target){
                        pos=i+1;
                    }
                }
            }
            return pos;
        }
        /*
        Search X in sorted array

Basic
Given a sorted array of integers nums with 0-based indexing, find the index of a specified target integer. If the target is found in the array, return its index. If the target is not found, return -1.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9

Output: 4

Explanation: The target integer 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2

Output: -1

Explanation: The target integer 2 does not exist in nums so return -1
         */
        public static int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            int mid = -1;
            while(left<=right){
                mid = (left+right)/2;
                if(target<nums[mid]){
                    right=mid-1;
                }else if(target>nums[mid]){
                    left=mid+1;
                }else if(target==nums[mid]){
                    break;
                }
            }
            if(nums[mid]==target){
                return mid;
            }else{
                return -1;
            }
        }
        /*
        binary search
         */
        public int search(int[] nums, int target , int left , int right) {
            if(left>right){
                return -1;
            }
            int mid = (left+right)/2;
            if(target>nums[mid]){
                return search(nums , target , mid+1 , right);
            }else if(target<nums[mid]){
                return search(nums , target , left , mid-1);
            }else{
                return mid;
            }
        }
    public int recsearch(int[] nums, int target) {
            return search(nums , target , 0 , nums.length-1);
    }
    /*bs
     */
    /*
    Largest Subarray with Sum 0


24

Core

Companies
You are given an integer array arr of size n which contains both positive and negative integers.
 Your task is to find the length of the longest contiguous subarray with sum equal to 0.

Return the length of such a subarray. If no such subarray exists, return 0.

Example 1:
Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]

Output: 5

Explanation:

The subarray [-2, 2, -8, 1, 7] sums up to 0 and has the maximum length among all such subarrays.
     */
    public static int maxLen(int[] arr) {
        int maxlen = 0;
        int currentlen = 0;
        int sum = 0;
            for(int i = 0 ; i < arr.length ; i++){
                for(int j = i ; j < arr.length ; j++){
                    sum=sum+arr[j];
                    if(sum==0){
                        currentlen=j-i+1;
                        if(currentlen>maxlen){
                            maxlen=currentlen;
                        }

                    }
                }
                sum=0;
            }
        return maxlen;
            /*
            brute force sum0
             */
    }
    public static int longestSubarray(int[] nums, int k) {
        int maxlen = 0;
        int currentlen = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j < nums.length ; j++){
                sum=sum+nums[j];
                if(sum==k){
                    currentlen=j-i+1;
                    if(currentlen>maxlen){
                        maxlen=currentlen;
                    }

                }
            }
            sum=0;
        }
        return maxlen;
            /*
            brute force sum0
             */
    }
    /*
    count no of arrays with sum k
     */
    public static int subarraySum(int[] nums, int k) {
        int count=0;
        int sum=0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i ; j < nums.length ; j++){
                sum=sum+nums[j];
                if(sum==k){
                    count++;
                }
            }
            sum=0;
        }
        return count;
    }
    /*
    subarray sum using prefix sum
     */
    public static int subarraySum2(int[] nums, int k){
        int sum = 0;
        int count = 0;
        HashMap<Integer , Integer> hs = new HashMap<>();
        hs.put(0,1);
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum+nums[i];
            if(hs.containsKey(sum-k)){
                count=count+hs.get(sum-k);
            }
            if(hs.containsKey(sum)){
                hs.put(sum, hs.get(sum)+1);
            }else{
                hs.put(sum , 1);
            }
        }
        return count;
    }
    public static int retSumSub(int[] arr , int k){
        HashMap<Integer , Integer> hs = new HashMap<>();
        int sum = 0;
        int count = 0;
        hs.put(0 , 1);
        for(int i = 0 ; i < arr.length ; i++){
            sum=sum+arr[i];
            if(hs.containsKey(sum-k)){
                count=count+hs.get(sum-k);
            }
            if(hs.containsKey(sum)){
                hs.put(sum , hs.get(sum)+1);
            }else{
                hs.put(sum , 1);
            }
        }
        return count;
    }
    /*
    Given an array of integers nums and an integer k,
     return the total number of subarrays whose XOR equals to k.

Example 1:
Input : nums = [4, 2, 2, 6, 4], k = 6

Output : 4

Explanation : The subarrays having XOR of their elements as 6 are [4, 2],
 [4, 2, 2, 6, 4], [2, 2, 6], and [6]
     */
    public static int subarraysWithXorK(int[] nums, int k) {
        int xor = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for (int j = i ; j < nums.length ; j++){
                xor = xor ^ nums[j];
                if(xor==k){
                    count++;
                }
            }
            xor=0;
        }
        return count;
    }
    public static int subarraywithxor(int[] nums , int k){
        HashMap<Integer , Integer> hs = new HashMap<>();
        hs.put(0,1);
        int xor = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            xor = xor^nums[i];
            if(hs.containsKey(xor^k)){
                count=count+hs.get(xor^k);
            }
            if(hs.containsKey(xor)){
                hs.put(xor, hs.get(xor)+1);
            }else{
                hs.put(xor , 1);
            }
        }
        return count;
    }

    public static int subarrSum(int[] nums , int k){
        HashMap<Integer , Integer> hs = new HashMap<>();
        hs.put(0 , 1);
        int sum = 0;
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum = sum + nums[i];
            if(hs.containsKey(sum-k)){
                count = count + hs.get(sum-k);
            }
            if(hs.containsKey(sum)){
                hs.put(sum, hs.get(sum)+1);
            }else{
                hs.put(sum , 1);
            }
        }
        return count;
    }
}