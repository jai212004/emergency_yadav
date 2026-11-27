public class Main2 {
    public static void main(String[] args) {
        int[] arr = {805306368,805306368,805306368};
        System.out.println(minimumRateToEatBananas(arr , 1000000000));
        System.out.println(smalldiv(arr, 1000000000));
    }
    public static int smalldiv(int[] arr , int limit){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            max = Integer.max(max , arr[i]);
        }
        int left = 1;
        int right = max;
        int mid = (left+right)/2;
        while(left<=right){
            mid = (left+right)/2;
            if(sum(arr , mid)<=limit){
                right = mid - 1;
            }else if(sum(arr , mid)>limit){
                left = mid + 1;
            }
        }
        return left;
    }
    public static int sum3(int[] arr , int mid){
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum = sum + (int)Math.ceil((double)arr[i]/mid);
        }
        return sum;
    }
        public static int minimumRateToEatBananas(int[] nums, int h) {
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < nums.length ; i++){
                max = Integer.max(max , nums[i]);
            }
            int left = 1;
            int right = max;
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
            long total = 0;
            for(int i = 0 ; i < arr.length ; i++){
                total += (arr[i] + mid - 1) / mid;
            }
            return total;
        }

//    public static int findMedian(int[][] grid){
//        int low = Integer.MAX_VALUE;
//        int high = Integer.MIN_VALUE;
//        int sum = grid.length*grid[0].length;
//        int needed = 0;
//        if(sum%2==0){
//            needed=sum/2;
//        }else{
//            needed=(sum+1)/2;
//        }
//        for(int i = 0 ; i < grid.length ; i++){
//            low = Math.min(low , grid[i][0]);
//            high = Math.max(high , grid[i][grid[i].length-1]);
//        }
//        while (low<=high){
//            int mid = (low+high)/2;
//            int count = 0;
//            for(int i = 0 ; i < grid.length ; i++){
//                count = count + countLessThanEqual(grid[i] , mid);
//            }
//            if(count<needed){
//                low = mid + 1;
//            }else{
//                high = mid - 1;
//            }
//        }
//        return low;
//    }

//    public static int countLessThanEqual(int[] arr , int target){
//        int low = 0;
//        int high = arr.length-1;
//        while(low<=high){
//            int mid = (low+high)/2;
//            if(arr[mid]>target){
//                high=mid-1;
//            }else{
//                low=mid+1;
//            }
//        }
//        return low;
//    }
    public int findMedian(int[][] matrix) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int sum = matrix.length*matrix[0].length;
        int needed = 0;
        if(sum%2==1){
            needed=(sum+1)/2;
        }else{
            needed=(sum/2);
        }
        for(int i = 0 ; i < matrix.length ; i++){
            low = Math.min(low , matrix[i][0]);
            high = Math.max(high , matrix[i][matrix[i].length-1]);
        }
        while (low<=high){
            int mid = (low+high)/2;
            int count = 0;
            for(int i = 0 ; i < matrix.length ; i++){
                count = count+countLessThanEqual(matrix[i] , mid);
            }
            if(count<needed){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }
    public int countLessThanEqual(int[] arr , int target){
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
