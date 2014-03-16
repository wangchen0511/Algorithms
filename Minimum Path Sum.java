public class Solution {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(grid==null || grid.length==0){
            return 0;
        }
        int[][] buffer= new int[2][grid[0].length+1];
        int lastRow=0;
        buffer[0][1]=grid[0][0];
        for(int i=2;i<=grid[0].length;i++){
            buffer[0][i]=buffer[0][i-1]+grid[0][i-1];
        }
        for(int i=2;i<=grid.length;i++){
            int currentRow=(lastRow+1)%2;
            buffer[currentRow][1]=buffer[lastRow][1]+grid[i-1][0];
            for(int j=2;j<=grid[0].length;j++){
                if(buffer[currentRow][j-1]<buffer[lastRow][j]){
                    buffer[currentRow][j]=buffer[currentRow][j-1]+grid[i-1][j-1];
                }
                else{
                    buffer[currentRow][j]=buffer[lastRow][j]+grid[i-1][j-1];
                }
            }
            lastRow=currentRow;
        }
        return buffer[lastRow][grid[0].length];
    }
}