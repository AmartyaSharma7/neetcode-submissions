class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Find the row using BS
        //Find the col using BS
        int low = 0, high = matrix.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[mid][0]==target)return true;
            if(matrix[mid][0] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        int row = high;
        if(row<0)return false;
        int low1 = 0, high1 = matrix[0].length-1;
        while(low1<=high1){
            int mid = (low1+high1)/2;
            if(matrix[row][mid]==target)return true;
            if(matrix[row][mid]<target){
                low1=mid+1;
            }
            else{
                high1=mid-1;
            }
        }
        return false;
    }
}
