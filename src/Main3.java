public class Main3 {
    public static void main(String[] args) {

    }

    public static double median(int[] arr1 , int[] arr2){
        if(arr2.length<arr1.length){
            return median(arr2 , arr1);
        }
        int low = 0;
        int high = arr1.length;
        int mid = (arr1.length+arr2.length+1)/2;
        while (low<=high){
            int mid1 = (low+high)/2;
            int mid2 = mid-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1>0){
                l1=arr1[mid1-1];
            }
            if(mid1<arr1.length){
                r1=arr1[mid1];
            }
            if(mid2>0){
                l2=arr2[mid2-1];
            }
            if(mid2<arr2.length){
                r2=arr2[mid2];
            }
            if(l1<=r2 && l2<=r1){
                if((arr1.length+arr2.length)%2 == 1){
                    return Math.max(l1 , l2);
                }else{
                    return ((double)(Math.max(l1,l2) + Math.min(r1,r2))/2);
                }
            }
            if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        throw new IllegalArgumentException("error");
    }

    /*
    Minimize Max Distance to Gas Station

Pro
Given a sorted array arr of size n,
 containing integer positions of n gas
stations on the X-axis, and an integer k,
 place k new gas stations on the X-axis.

The new gas stations can be placed anywhere
 on the non-negative side of the X-axis,
  including non-integer positions.

Let dist be the maximum distance between
 adjacent gas stations after adding the
  k new gas stations.

Find the minimum value of dist.
     */

    public double minimiseMaxDistance(int[] arr, int k) {
        double low = 0;
        double high = 0;
        for(int i = 1 ; i < arr.length ; i++){
            int dist = arr[i]-arr[i-1];
            if(dist>high){
                high=dist;
            }
        }
        while (high-low>=1e-7){
            double mid = (low+high)/2;
            long stat = noOfstat(arr , mid);
            if(stat>k){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;
    }

    public long noOfstat(int[] arr , double k){
        long count = 0;
        for(int i = 1 ; i < arr.length ; i++){
            double gap = arr[i] - arr[i-1];
            count = (long) (count + (Math.ceil(gap/k)-1));
        }
        return count;
    }

    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int column = mat[0].length;
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[i].length ; j++){
                int element = mat[i][j];
                int up = Integer.MIN_VALUE;
                if(i>0){
                    up=i-1;
                }
                int down = Integer.MIN_VALUE;
                if(i<rows-1){
                    down=i+1;
                }
                int left = Integer.MIN_VALUE;
                if(j>0){
                    left=j-1;
                }
                int right = Integer.MIN_VALUE;
                if(j<column-1){
                    right=j+1;
                }
                if(element>right && element>up && element>left && element>down){
                    return new int[]{i , j};
                }
            }
        }
        return new int[]{-1 , -1};
    }
}
