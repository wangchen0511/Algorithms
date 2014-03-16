public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0){
            return null;
        }
        int[][] res=new int[n][n];
        int distributor=1;
        for(int i=0;i<=(n-1)/2;i++){
            int row=i;
            int col=i;
            int width=n-2*i;
            for(int j=0;j<width;j++){
                res[row][col+j]=distributor++;
            }
            if(width==1){
                break;
            }
            for(int j=1;j<width;j++){
                res[row+j][col+width-1]=distributor++;
            }
            for(int j=width-2;j>=0;j--){
                res[row+width-1][col+j]=distributor++;
            }
            for(int j=width-2;j>=1;j--){
                res[row+j][col]=distributor++;
            }
        }
        return res;
    }
}