class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Logic involoves finding the elements in the left half)
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 > length2)return findMedianSortedArrays(nums2,nums1);

        //Elements to be in left half -> Half
        int leftElements = (length1+length2)/2;
        
        //Binary Search over smaller Array
        int low = 0 , high = length1;
    
        while(low<=high){
            int mid = (low+high)/2;
            //Number of elements in right should be ->
            int mid2 = leftElements - mid;// 6 elements should be in left partition -> If i take mid(3) elemtnts from nums1 how much fro nums2 
            
            int aLeft = mid > 0 ? nums1[mid-1] : Integer.MIN_VALUE;
            int aRight = mid < length1 ? nums1[mid] : Integer.MAX_VALUE;
            int bLeft = mid2 > 0 ? nums2[mid2-1] : Integer.MIN_VALUE;
            int bRight = mid2 < length2 ? nums2[mid2] : Integer.MAX_VALUE;
 
            //correct symmtery
            if(aLeft <= bRight && bLeft <= aRight){
                //if odd
                if((length1+length2)%2 != 0){
                    return Math.min(aRight,bRight);
                }
                return (Math.max(aLeft,bLeft) + Math.min(aRight,bRight))/2.0;
            }
            else if(aLeft > bRight){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return 0;
    }
}
