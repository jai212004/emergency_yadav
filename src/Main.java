import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.floor;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
//        for(int i = 0 ; i < arre.length ; i++){
//            for(int j = i ; j < arre[i].length; j++){
//                System.out.println(arre[i][j]);
//            }
//        }
        int[] arr1 = {1,4,5,9};
        int[] arr2 = {2,3,6,11};
        System.out.println(kthElement(arr1 , arr2 , 2));
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
    /*
    Single element in sorted array

Core
Given an array nums sorted in non-decreasing order.
 Every number in the array except one appears twice.
  Find the single number in the array.

Example 1:
Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]

Output:4

Explanation: Only the number 4 appears once in the array.
     */
    public static int singleNonDuplicate(int[] nums) {
        int res = 0;
        HashMap<Integer , Integer> hs = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (hs.containsKey(nums[i])) {
                hs.put(nums[i], hs.get(nums[i]) + 1);
            } else {
                hs.put(nums[i], 1);
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(hs.get(nums[i])==1){
                res=nums[i];
                break;
            }
        }
        return res;
    }
    public static int singleNonDuplicate2(int[] nums){
        int xor = 0;
        for(int i = 0 ; i < nums.length ; i++){
            xor = xor^nums[i];
        }
        return xor;
    }

    public static int singleNonDuplicate3(int[] nums){
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }
        int left = 1;
        int right = nums.length-2;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(((mid%2==0) && (nums[mid]==nums[mid+1])) || ((mid%2==1) && (nums[mid]==nums[mid-1]))){
                left = mid+1;
            }else if(((mid%2==1) && (nums[mid]==nums[mid+1])) || ((mid%2==0) && (nums[mid]==nums[mid-1]))){
                right = mid-1;
            }
        }
        return -1;
    }
    /*
    You are given a sorted array of integers arr and an integer target.
    Your task is to determine how many times target appears in arr.

Return the count of occurrences of target in the array.

Example 1:
Input: arr = [0, 0, 1, 1, 1, 2, 3], target = 1

Output: 3

Explanation: The number 1 appears 3 times in the array.
     */
    public static int countOccurrences(int[] arr, int target) {
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i]==target){
                count++;
            }
        }
        return count;
    }//sorted not being used
    public static int firstcountOccurences(int[] arr , int target){
        int left = 0;
        int right = arr.length-1;
        int res = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target){
                res=mid;
                right=mid-1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else if(target>arr[mid]){
                left=mid+1;
            }
        }
        return res;
    }
    public static int lastountOccurences(int[] arr , int target){
        int left = 0;
        int right = arr.length-1;
        int res = -1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid]==target){
                res=mid;
                left=mid+1;
            }else if(target<arr[mid]){
                right=mid-1;
            }else if(target>arr[mid]){
                left=mid+1;
            }
        }
        return res;
    }

    public static int countOccurences(int[] arr , int target){
        int fr = firstcountOccurences(arr , target);
        int ls = lastountOccurences(arr , target);
        if(fr==-1){
            return 0;
        }else{
            return ls-fr+1;
        }
    }
    //optimal solution

    public static int countsingle(int[] arr){
        if(arr.length==1){
            return arr[0];
        }if(arr[0]!=arr[1]){
            return arr[0];
        }if(arr[arr.length-1]!=arr[arr.length-2]){
            return arr[arr.length-1];
        }
        int left = 1;
        int right = arr.length-2;
        int mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1]){
                return arr[mid];
            }else if((mid%2==0) && (arr[mid+1]==arr[mid]) || ((mid%2==1) && (arr[mid]==arr[mid-1]))){
                left=mid+1;
            }else if((mid%2==1) && (arr[mid]==arr[mid+1]) || (mid%2==0)&&(arr[mid]==arr[mid-1])){
                right=mid-1;
            }
        }
        return -1;
    }
    /*
    Given an array of integers nums and an integer limit as the threshold value, find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, the sum of the division results is less than or equal to the threshold value.

After dividing each element by the chosen divisor, take the ceiling of the result (i.e., round up to the next whole number).

Example 1:
Input: nums = [1, 2, 3, 4, 5], limit = 8

Output: 3

Explanation: We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor.

The sum is 9(1 + 1 + 2 + 2 + 3) if we choose 2 as a divisor.
 Upon dividing all the elements of the array by 3,
 we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e.
  the threshold value. So, 3 is the minimum possible answer.

Example 2:
Input: nums = [8,4,2,3], limit = 10

Output: 2

Explanation: If we choose 1, we get 17 as the sum.
 If we choose 2, we get 9 (4+2+1+2) <= 10 as the answer.
  So, 2 is the answer.
     */
    public static int smallestDivisor1(int[] nums, int limit) {
        int divisor = 1;
        int max1 = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            max1 = Integer.max(max1 , nums[i]);
        }
        while(divisor<=max1){
            int sum = 0;
            for(int i = 0 ; i < nums.length ; i++){
                sum = sum + (int)Math.ceil((double)nums[i]/divisor);
            }
            //System.out.println(sum);
            if(sum<=limit){
                break;
            }else{
                divisor++;
                sum=0;
            }
        }
        return divisor;
    }
    //brute
    public static int smallestDivisor(int[] nums, int limit) {
        int max = Integer.MIN_VALUE;
        int count = 1;
        for(int i = 0 ; i < nums.length ; i++){
            max = Integer.max(max , nums[i]);
        }
//        int[] arr = new int[max];
//        for(int i = 0 ; i < arr.length ; i++){
//            arr[i] = count;
//            count++;
//        }
        int left = 1;
        int right = max;
        int mid = (left+right)/2;
        while (left<=right){
            mid = (left+right)/2;
            if(sum1(nums , mid)<=limit){
                right = mid-1;
            }else if(sum1(nums , mid)>limit){
                left = mid+1;
            }
        }
        return left;
    }

    public static long sum1(int[] nums , int mid){
        long sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            sum += (nums[i] + mid - 1) / mid;
        }
        return sum;
    }
     /*
    A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas.
     An integer h represents the total time in hours to eat all the bananas.

Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas.
 If the pile contains fewer than k bananas, the monkey eats all the bananas in that pile and does not consume any more bananas in that hour.

Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.

Example 1:
Input: n = 4, nums = [7, 15, 6, 3], h = 8

Output: 5

Explanation: If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly.
 So, he will take 8 hours to complete all the piles.
     */
     public static int minimumRateToEatBananas(int[] nums, int h) {
         long max = Integer.MIN_VALUE;
         for(int i = 0 ; i < nums.length ; i++){
             max = Integer.max((int) max , nums[i]);
         }
         int left = 1;
         int right = (int)max;
         while(left<=right){
           int mid = (left+right)/2;
           if(sum(nums , mid)<=h){
               right = mid-1;
           }else if(sum(nums , mid)>h){
               left = mid+1;
           }
         }
         return left;
     }
     public static long sum(int[] arr , int mid){
         long sum = 0;
         for(int i = 0 ; i < arr.length ; i++){
             sum += (arr[i] + mid - 1) / mid;
         }
         return sum;
     }
     /*
     Find out how many times the array is rotated

Core
Given an integer array nums of size n, sorted in ascending order with distinct values.
 The array has been right rotated an unknown number of times, between 0 and n-1 (including).
  Determine the number of rotations performed on the array.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

Output: 4

Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7].
 So, we can notice that the array has been rotated 4 times.
      */
     public static int findKRotation(ArrayList<Integer> nums) {
         if(getindex(nums)==nums.size()-1){
             return 0;
         }else{
             return getindex(nums)+1;
         }
     }

     public static int getindex(ArrayList<Integer> nums){
         int index = 0;
         int max = Integer.MIN_VALUE;
         for(int i = 0 ; i < nums.size() ; i++){
             if(nums.get(i)>max){
                 max=nums.get(i);
                 index = i;
             }
         }
         return index;
     }

     /*
     Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]

Output: 0

Explanation: Here, the element 0 is the minimum element in the array.

Example 2:
Input : nums = [3, 4, 5, 1, 2]

Output: 1

Explanation:Here, the element 1 is the minimum element in the array.

      */
     public static int findMin(ArrayList<Integer> arr) {
         if(getindex(arr)==arr.size()-1){
             return arr.get(0);
         }else{
             return arr.get(getindex(arr)+1);
         }
     }
     /*
     Search in rotated sorted array-I


67

Core

Companies
Given an integer array nums, sorted in ascending order (with distinct values) and a target value k.
 The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.

Example 1:
Input : nums = [4, 5, 6, 7, 0, 1, 2], k = 0

Output: 4

Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums.
 Thus, we get output as 4, which is the index at which 0 is present in the array.

Example 2:
Input: nums = [4, 5, 6, 7, 0, 1, 2], k = 3

Output: -1

Explanation: Here, the target is 3.
 Since 3 is not present in the given rotated sorted array. Thus, we get the output as -1.
      */
     public static int searchone(int[] nums, int k) {
         ArrayList<Integer> arr = new ArrayList<>();
         for(int a : nums){
             arr.add(a);
         }
         int breakpoint = getindex(arr);
         int res = -1;
         if(breakpoint==arr.size()-1){
             res = bin(nums , 0 , arr.size()-1 , k);
         }else{
             int ack1 = bin(nums , 0 , breakpoint , k);
             int ack2 = bin(nums , breakpoint+1 , arr.size()-1 , k);
             if(ack1!=-1){
                 res=ack1;
             }else{
                 res=ack2;
             }
         }

         return res;
     }

     public static int bin(int[] nums , int left , int right , int target){
         int mid = (left+right)/2;
         while(left<=right){
             mid=(left+right)/2;
             if(nums[mid]==target){
                 return mid;
             }else if(target<nums[mid]){
                 right=mid-1;
             }else if(target>nums[mid]){
                 left=mid+1;
             }
         }
         return -1;
     }

    public boolean searchInARotatedSortedArrayII(int[] nums, int k) {
         boolean res = false;
         for(int i = 0 ; i<nums.length ; i++){
             if(k==nums[i]){
                 res=true;
                 break;
             }
         }
         return res;
    }

    public static int search1(int[] nums , int k){
         int left = 0;
         int right = nums.length-1;
         while(left<=right){
             int mid = (left+right)/2;
             if(nums[mid]==k){
                 return mid;
             }else if(nums[right]<nums[mid]){
                 if(k>=nums[left] && k<nums[mid]){
                     right=mid-1;
                 }else{
                     left=mid+1;
                 }
             }else{
                 if(k<=nums[right] && k>nums[mid]){
                     left=mid+1;
                 }else{
                     right=mid-1;
                 }
             }
         }
         return -1;
    }
    /*
    Given an array of integers nums and an integer target.
     Return the indices(0 - indexed) of two elements in nums such that they add up to target.

Each input will have exactly one solution, and the same element cannot be used twice.
 Return the answer in any order.

Example 1:
Input: nums = [1, 6, 2, 10, 3], target = 7

Output: [0, 1]

Explanation:

nums[0] + nums[1] = 1 + 6 = 7
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int res = 0;
        HashMap<Integer , Boolean> hs = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!hs.containsKey(nums[i])){
                hs.put(nums[i] , true);
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            //target is -3 , 6 comes now -9 is needed , if -9 comes will it be checked ?
            //target is 6 , 3 comes now 3 is needed , if 3 comes will it be checked
            //target is -6 , 9 comes now -15 is needed
            if(hs.containsKey(target-nums[i]) && target-nums[i]!=nums[i]){
                arr[0]=i;
                break;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]==(target-nums[arr[0]])){
                arr[1]=i;
                break;
            }
        }
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        return arr;
    }
    public static int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        int res = 0;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            hs.putIfAbsent(nums[i] , i);
        }
        for(int i = 0 ; i < nums.length ; i++){
            int comp = target - nums[i];
            if(hs.containsKey(comp) && hs.get(comp)!=i){
                arr[0]=i;
                arr[1]=hs.get(comp);
            }
        }
        return arr;
    }
    /*
    Given an array arr of integers. A peak element is defined as an element greater than both of its neighbors.

Formally, if arr[i] is the peak element, arr[i - 1] < arr[i] and arr[i + 1] < arr[i].

Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.

Note:

As there can be many peak values, "true" is given as output if the returned index is a peak number, otherwise the returned value of index.
The first and last elements of the array can also be considered peak elements. For boundary elements, assume the missing neighbor is smaller than any possible element in the array.
Example 1:
Input : arr = [1, 2, 3, 4, 5, 6, 7, 8, 5, 1]

Output: 7

Explanation: In this example, there is only 1 peak that is at index 7.
     */
    public static int findPeakElement(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }else if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        for(int i = 1 ; i < arr.length-1 ; i++){
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                return i;
            }
        }
        return -1;
    }
    /*
    Given a positive integer n.
    Find and return its square root.
     If n is not a perfect square,
      then return the floor value of sqrt(n).
Example 1:
Input: n = 36

Output: 6

Explanation: 6 is the square root of 36.
     */
    public static int floorSqrt(int n) {
        int left = 1;
        int right = n;
        int mid = (left+right)/2;
        long sq = ((long) mid *mid);
        while(left<=right){
            mid = left + (right - left) / 2;
            sq = ((long) mid *mid);
            if(sq==n){
                return mid;
            }else if(sq<n){
                left = mid+1;
            }else if(sq>n){
                right = mid-1;
            }
        }
        if(sq>n){
            return mid-1;
        }else{
            return mid;
        }
    }

    public static int power(int i , int n){
        long result = 1;
        while(n!=0){
            if(n%2==0){
                i=(int) ((long)i*i);
                n=n/2;
            }else if(n%2==1){
                result=result*i;
                n--;
            }
        }
        return (int)result;
    }
    public static int NthRoot(int N, int M) {
        int left = 1;
        int right = M;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long pw = power(mid, N);
            if (pw == M) {
                return mid;
            } else if (pw > M) {
                right = mid - 1;
            } else if (pw < M) {
                left = mid + 1;
            }
        }
        return -1;
    }
    /*
    Given two numbers N and M,
     find the Nth root of M.
     The Nth root of a number M is defined
      as a number X such that when X is raised
     to the power of N, it equals M.
      If the Nth root is not an integer, return -1.
Example 1:
Input: N = 3, M = 27

Output: 3

Explanation: The cube root of 27 is equal to 3.
     */
    public int NthRoot2(int N, int M) {
        int left = 1;
        int right = M;
        int mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            int req = power(mid , N , M);
            if(req==1){
                return mid;
            }else if(req==2){
                right=mid-1;
            }else if(req==0){
                left=mid+1;
            }
        }
        return -1;
    }

    public int power(int base , int power , int limit){
        long res = 1;
        int out = 0;
        for(int i = 0 ; i < power ; i++){
            res = res*base;
            if(res>limit){
                out = 2;
                break;
            }
        }
        if(res==limit){
            out=1;
        }
        return out;
    }
    /*
    Minimum days to make M bouquets


84

Pro

Companies
Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day,
 only adjacent bloomed roses can be picked to make a bouquet.
Exactly k adjacent bloomed roses are required to make a single bouquet.
 Find the minimum number of days required to make at least m bouquets,
each containing k roses. Return -1 if it is not possible.

Example 1:
Input: n = 8, nums = [7, 7, 7, 7, 13, 11, 12, 7],
 m = 2, k = 3

Output: 12

Explanation: On the 12th the first 4 flowers and the
last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.
     */
    public int roseGarden(int n, int[] nums, int k, int m) {
        if((long)k*m>n){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]<min){
                min = nums[i];
            }
            if(nums[i]>max){
                max = nums[i];
            }
        }
        int left = min;
        int right = max;
        int mid = (left+right)/2;
        while (left<=right){
            mid = (left+right)/2;
            int noofBouq = bloomFlower(nums , k , mid);
            if(noofBouq<m){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    public static int bloomFlower(int[] nums , int noofflowinBouq , int days) {
        int count = 0;
        int noofbouqet = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=days){
                count++;
                if(count==noofflowinBouq){
                    noofbouqet++;
                    count=0;
                }
            }else{
                count=0;
            }
        }
        return noofbouqet;
    }
    /*
    You are given an array weights where weights[i]
    represents the weight of the i-th package on a conveyor belt.
     All the packages must be shipped in the order
      given from one port to another within days.

Each day,
 the ship can carry a contiguous sequence of packages,
  as long as the total weight does not exceed its maximum capacity.

Your task is to find the minimum possible capacity
 of the ship so that all packages can be shipped within
  the given number of days.

Example 1:
Input: weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], days = 5

Output: 15

Explanation:

Minimum ship capacity = 15. One way to ship in 5 days:

Day 1: 1 + 2 + 3 + 4 + 5 = 15
Day 2: 6 + 7 = 13
Day 3: 8
Day 4: 9
Day 5: 10
No day exceeds capacity 15 and all packages are shipped in order in 5 days.
     */
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < weights.length ; i++){
            if(weights[i]>max){
                max=weights[i];
            }
            sum = sum + weights[i];
        }
        int left = max;
        int right = sum;
        int mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            int res = checkIt(weights , mid);
            if(res>days){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }

    public static int checkIt(int[] weights , int cap){
        int days = 0;
        int sum = 0;
        for(int i = 0 ; i < weights.length ; i++){
            if(sum + weights[i]>cap){
                days++;
                sum=weights[i];
            }else{
                sum=sum+weights[i];
            }
        }
        return days+1;
    }
    /*
    Given a sorted array of unique positive integers arr, your task is to return the kᵗʰ missing positive number that is not present in arr.

The array is guaranteed to be strictly increasing, and the missing numbers are those positive integers that do not appear in arr but would appear in a full sequence starting from 1.

Example 1:
Input: arr = [3, 5, 7, 10], k = 6
Output: 9
Explanation:
The missing numbers are
 [1, 2, 4, 6, 8, 9, 11, ...].
  The 6ᵗʰ missing number is 9.
     */
    public static int findKthPositive2(int[] arr, int k) {
        HashMap<Integer, Boolean> hs = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for(int i = 1 ; i <= max ; i++){
            hs.put(i , false);
        }
        for(int i = 0 ; i < arr.length ; i++){
            hs.put(arr[i] , true);
        }
        int v = 0;
        int num = 1;
        while(true){
            if(v==k){
                break;
            }
            if(hs.containsKey(num)){
                if(!hs.get(num)){
                    v++;
                    num++;
                }else{
                    num++;
                }
            }else{
                v++;
                num++;
            }
        }
        return num-1;
    }
    public static int findKthPositive(int[] arr, int k) {
        int maxmissing = helper(arr , arr.length-1);
        if(k>maxmissing){
            return k-maxmissing+arr[arr.length-1];
        }
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        while (left<=right){
            mid = (left+right)/2;
            int req = helper(arr , mid);
            if(req>=k){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        if(left==0){
            return k;
        }else {
            return arr[right] + k - helper(arr, right);
        }
    }
    public static int helper(int[] arr , int mid){
        return arr[mid]-mid-1;
    }
    /*
    binary search ensures that at the end we are left with two sides left and right ,
     where left satisfies one condition and right satisfies other like in this case
    when left>right missing numbers till left were greater than equal to k - statement 1 , missing
    numbers till right were less than k , so we do arr[right] + (total number of missing numbers we need - no of missing numbers we have till now)
    which is (arr[right] + (k-helper(arr , right)) , helper(arr , right) = x , but mind didn't satisfy that k-x wont overshoot so
    we need to check that k-x <= helper(arr , left) - helper(arr , right) , helper(arr , right) = x so k <= helper(arr,left)
    then statement 1 comes into play proving the case , two case left when missing kth number is before the first element and other is
    when the missing element is after last element , we handle the first case by checking whether left is 0 which means if left is 0
    it means 0 is the first index where no of missing numbers are greater than equal to k , so right becomes -1 which when provided
    to helper function will cause issue therefore when this happens , returning k would be sufficient as there is no wall struck the missing numbers
    are consecutive and for the second case where k is greater than missing numbers at last index we do lastEle + k - x where k is
    total number of missing numbers and x = helper(arr , arr.length-1)
     */
    public int paint(int A, int B, int[] C) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for(int i = 0 ; i < C.length ; i++){
            if(C[i]>max){
                max=C[i];
            }
            sum=sum+C[i];
        }
        long left = (long)max*B;
        long right = (long)sum*B;
        long mid = (left+right)/2;
        while (left<=right){
            mid = (left+right)/2;
            int painter = help2(C , mid , B);
            if(painter<=A){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return (int)(((long)left)%10000003);
    }

    public int help2(int[] arr , long cap , int time){
        int painters = 0;
        long sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if((sum+arr[i])*time>cap){
                painters++;
                sum=arr[i];
            }else{
                sum=sum+arr[i];
            }
        }
        return painters+1;
    }
    /*
    You are given A painters and an array C of N integers where C[i] denotes the length of the ith board.
     Each painter takes B units of time to paint 1 unit of board. You must assign boards to painters such that:

Each painter paints only contiguous segments of boards.
No board can be split between painters.
The goal is to minimize the time to paint all boards.
Return the minimum time required to paint all boards modulo 10000003.

Example 1:
Input: A = 2, B = 5, C = [1, 10]

Output: 50

Explanation:

Painter 1 paints board 0 (length = 1), time = 5
Painter 2 paints board 1 (length = 10), time = 50
Max time = 50
Return 50 % 10000003 = 50
     */

    public int findPages(int[] nums, int m) {
        if(m>nums.length){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]>max){
                max=nums[i];
            }
            sum=sum+nums[i];
        }
        int left = max;
        int right = sum;
        int mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            int res = help3(nums , mid);
            if(res<=m){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int help3(int[] arr , int cap){
        int chilren = 0;
        int books = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(books+arr[i]>cap){
                chilren++;
                books=arr[i];
            }else{
                books=books+arr[i];
            }
        }
        return chilren+1;
    }
    /*Book Allocation: same as painters, lower bound is max, helper counts students*/
    public static int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        if(k>nums.length || k<2){
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = nums[nums.length-1]-nums[0];
        for(int i = 0 ; i < nums.length-1 ; i++){
            int low = nums[i+1]-nums[i];
            if(low<left){
                left=low;
            }
        }
        while (left<=right){
            int mid = (left+right)/2;
            int noofcow = retDis(nums , mid);
            if(noofcow>=k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }

    public static int retDis(int[] arr , int dist){
        //returning no of cows
        int noofcow = 1;
        int indexofcow = 0;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i]-arr[indexofcow]>=dist){
                indexofcow=i;
                noofcow++;
            }
        }
        return noofcow;
    }
    /*
    Median of 2 sorted arrays

Pro
Given two sorted arrays arr1 and arr2 of size m and n
 respectively,
 return the median of the two sorted arrays.
The median is defined as the middle value of
 a sorted list of numbers.
 In case the length of the list is even, the median is the
  average of the two middle elements.
     */
    public double median3(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length+arr2.length];
        int req = 0;
        int max1 = arr1[arr1.length-1];
        int max2 = arr2[arr2.length-1];
        int min1 = arr1[0];
        int min2 = arr2[0];
        if(max2>max1){

        }
        return 9.0;
    }
    /*
    Find row with maximum 1's

Core
Given a non-empty grid mat consisting
 of only 0s and 1s, where all the rows
  are sorted in ascending order,
   find the index of the row with the
   maximum number of ones.

If two rows have the same number of ones,
 consider the one with a smaller index.
 If no 1 exists in the matrix, return -1.

Example 1:
Input : mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]

Output: 0

Explanation: The row with the maximum number
of ones is 0 (0 - indexed).
     */
//    public static int rowWithMax1s(int[][] mat) {
//        int max = Integer.MIN_VALUE;
//        int count = 0;
//        int row = -1;
//        for(int i = 0 ; i < mat.length ; i++){
//            for(int j = 0 ; j < mat[i].length ; j++){
//                if(mat[i][j]==1){
//                    count++;
//                }
//            }
//            if(count>max && count!=0){
//                max=count;
//                row = i;
//            }count=0;
//        }
//        return row;
//    }
    public static int rowWithMax1s(int[][] mat){
        int max = -1;
        int row = -1;
        for(int i = 0 ; i < mat.length ; i++){
            int first1 = binHelp(mat[i]);
            if(first1==-1){
                continue;
            }
            int count = mat[i].length-first1;
            if(count>max){
                max=count;
                row=i;
            }
        }
        return row;
    }
    public static int binHelp(int[] row) {
        int left = 0;
        int right = row.length-1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            if (row[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left>row.length-1){
            return -1;
        }
        else{
            return left;
        }
    }
    /*
    Search in a 2D Matrix


49

Core

Companies
Given a 2-D array mat where the elements
of each row are sorted in non-decreasing order,
and the first element of a row is greater than
the last element of the previous row (if it exists),
 and an integer target, determine if the target
 exists in the given mat or not.

Example 1:
Input: mat = [ [1, 2, 3, 4],
 [5, 6, 7, 8],
  [9, 10, 11, 12] ], target = 8

Output: True

Explanation: The target = 8
 exists in the 'mat' at index (1, 3).
     */
    public static boolean searchMatrix2(int[][] mat, int target) {
        int left = 0;
        int right = mat.length-1;
        int mid = (left+right)/2;
        while (left<=right){
            mid = (left+right)/2;
            int low = mat[mid][0];
            int high = mat[mid][mat[mid].length-1];
            if(low==target){
                return true;
            }if(target==high){
                return true;
            }
            if(target>low && target<high){
                return searchinRow(mat[mid] , target);
            }else if(target<low){
                right=mid-1;
            }else if(target>high){
                left=mid+1;
            }
        }
        return false;
    }
    public static boolean searchinRow(int[] arr , int target){
        int left = 0;
        int right = arr.length-1;
        int mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            if(arr[mid]==target){
                return true;
            }else if(target>arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
    /*
    Search in 2D matrix - II

Core
Given a 2D array matrix where each row is
 sorted in ascending order from left to right
and each column is sorted in ascending order
from top to bottom, write an efficient algorithm
to search for a specific integer target in the matrix.

Example 1:
Input: matrix = [ [1, 4, 7, 11, 15],
[2, 5, 8, 12, 19], [3, 6, 9, 16, 22],
[10, 13, 14, 17, 24], [18, 21, 23, 26, 30] ],
 target = 5

Output: True

Explanation: The target 5 exists in the
 matrix in the index (1,1)
     */
    public boolean searchMatrix22(int[][] matrix, int target) {
        boolean res = false;
        for(int i = 0 ; i < matrix.length ; i++){
            res = searchinRow(matrix[i] , target);
            if(res){
                break;
            }
        }
        return res;
    }
    /*
    Given a 2D array matrix where each row is
    sorted in ascending order from left to right
    and each column is sorted in ascending order
    from top to bottom, write an efficient algorithm
    to search for a specific integer target
     in the matrix.

Example 1:
Input: matrix = [ [1, 4, 7, 11, 15],
[2, 5, 8, 12, 19], [3, 6, 9, 16, 22],
 [10, 13, 14, 17, 24], [18, 21, 23, 26, 30] ],
 target = 5

Output: True

Explanation: The target 5 exists in the matrix
 in the index (1,1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int noofrows = 0;
        int column = matrix[0].length-1;
        while(noofrows < matrix.length && column>=0){
            int element = matrix[noofrows][column];
            if(element==target){
                return true;
            }else if(element>target){
                column--;
            }else{
                noofrows++;
            }
        }
        return false;
    }
    /*
    Split array - largest sum

Pro
Given an integer array a of size n
and an integer k. Split the array a
into k non-empty subarrays such that
the largest sum of any subarray is minimized.
Return the minimized largest
 sum of the split.
Example 1:
Input: a = [1, 2, 3, 4, 5], k = 3
Output:6
Explanation: There are many ways to split
the array a[] into k consecutive subarrays.
The best way to do this is to split the array
a[] into [1, 2, 3], [4], and [5], where the
largest sum among the three subarrays is only 6.
     */
    public static int largestSubarraySumMinimized(int[] a, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < a.length ; i++){
            if(a[i]>max){
                max=a[i];
            }
            sum = sum+a[i];
        }
        int left = max;
        int right = sum;
        while(left<=right){
            int mid = (left+right)/2;
            int noofel = helping(a , mid);
            if(noofel==-1){
                continue;
            }
            if(noofel>k){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return left;
    }
    public static int helping(int[] nums , int capSum){
        int sum = 0;
        int noofel = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]+sum>capSum){
                noofel++;
                sum=nums[i];
            }else{
                sum=sum+nums[i];
            }
        }
        if(noofel+1>nums.length){
            return -1;
        }
        return noofel+1;
    }
    /*
Given two sorted arrays arr1 and arr2 of size
m and n respectively, return the median of the two sorted arrays.

The median is defined as the middle value of a sorted list
 of numbers. In case the length of the list is even,
  the median is the average of the two middle elements.
Example 1:
Input: arr1 = [2, 4, 6], arr2 = [1, 3, 5]
Output: 3.5
     */
    public static double median1(int[] arr1, int[] arr2) {
        int left = 0;
        int right = 0;
        int count = 0;
        int prev = 0;
        int current = 0;
        while(true){
            if(count==((arr1.length+arr2.length)/2)+1){
                break;
            }
            if(left>arr1.length-1){
                prev=current;
                current=arr2[right];
                right++;
                count++;
            }else if(right>arr2.length-1){
                prev=current;
                current=arr1[left];
                count++;
                left++;
            }
            else if(arr1[left]<arr2[right]){
                prev=current;
                current=arr1[left];
                count++;
                left++;
            }else{
                prev=current;
                current=arr2[right];
                right++;
                count++;
            }
        }
        if((arr1.length+arr2.length)%2==1){
            return current;
        }else{
            return (double) (prev + current) /2;
        }
    }
    /*
    Kth element of 2 sorted arrays

Pro
Given two sorted arrays a and b of size m and n
 respectively.
Find the kth element of the final sorted array.

Example 1:
Input: a = [2, 3, 6, 7, 9], b = [1, 4, 8, 10], k = 5

Output: 6

Explanation: The final sorted array would
be [1, 2, 3, 4, 6, 7, 8, 9, 10]. The 5th
element of this array is 6.
     */
    public static int kthElement(int[] a, int[] b, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int prev = 0;
        int current = 0;
        while(count!=k){
            if(left>a.length-1){
                prev=current;
                current=b[right];
                right++;
                count++;
            }else if(right>b.length-1){
                prev=current;
                current=a[left];
                left++;
                count++;
            } else if (a[left]<b[right]) {
                prev=current;
                current=a[left];
                left++;
                count++;
            }else{
                prev=current;
                current=b[right];
                right++;
                count++;
            }
        }
        return current;
    }
    /*
    Median of 2 sorted arrays

Pro
Given two sorted arrays arr1 and arr2 of size m and n respectively,
 return the median of the two sorted arrays.
The median is defined as the middle value of a sorted list of numbers.
 In case the length of the list is even, the median is the average of the two middle elements.
     */
//    public static double median(int[] arr1, int[] arr2) {
//        if(arr1.length>arr2.length){
//            return median(arr2,arr1);
//        }
//        int low = 0;
//        int high = arr1.length;
//        int mid = (arr1.length+arr2.length+1)/2;
//        while (low<=high){
//            int mid1 = (low+high)/2;
//            int mid2 = mid-mid1;
//            int l1 = Integer.MIN_VALUE;
//            int l2 = Integer.MIN_VALUE;
//            int r1 = Integer.MAX_VALUE;
//            int r2 = Integer.MAX_VALUE;
//            if(mid1>0){
//                l1=arr1[mid1-1];
//            }if(mid1<arr1.length){
//                r1=arr1[mid1];
//            }if(mid2>0){
//                l2=arr2[mid2-1];
//            }if(mid2<arr2.length){
//                r2=arr2[mid2];
//            }
//            if(l1<=r2 && l2<=r1){
//                if((arr1.length+arr2.length)%2==1){
//                    return Math.max(l1,l2);
//                }
//                return (double) (Math.max(l1, l2) + Math.min(r1, r2)) /2;
//            }if(l1>r2){
//                high=mid1-1;
//            }else{
//                low=mid1+1;
//            }
//        }
//        throw new IllegalArgumentException("Input arrays are not sorted.");
//    }
//
    public static double median(int[] arr1 , int[] arr2){
        if(arr2.length<arr1.length){
            return median(arr2 , arr1);
        }
        int low = 0;
        int high = arr1.length;
        int mid = (arr1.length+arr2.length)/2;
        while (low<=high){
            int mid1 = (low+high)/2;
            int mid2 = mid-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1>0){
                l1=arr1[mid1-1];
            }if(mid1<arr1.length){
                r1=arr1[mid1];
            }if(mid2>0){
                r1=arr2[mid2-1];
            }if(mid2<arr2.length){
                r2=arr2[mid2];
            }
            if(l1<=r2 && l2<=r1){
                if((arr1.length+arr2.length)%2==1){
                    return Math.max(l1,l2);
                }else{
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) /2;
                }
            }if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        throw new IllegalArgumentException("error");
    }
}