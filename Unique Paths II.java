public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0]==null || obstacleGrid[0].length==0){
            return 0;
        }
        int[][] buffer=new int[2][obstacleGrid[0].length+1];
        int lastRow=0;
        for(int i=1;i<buffer[0].length;i++){
            if(obstacleGrid[0][i-1]==1){
                buffer[0][i]=0;
            }
            else{
                if(i==1){
                    buffer[0][i]=1;
                }
                else{
                    buffer[0][i]=buffer[0][i-1];
                }
            }
        }
        for(int i=2;i<=obstacleGrid.length;i++){
            int currentRow=(lastRow+1)%2;
            buffer[currentRow][0]=0;
            for(int j=1;j<=obstacleGrid[0].length;j++){
                if(obstacleGrid[i-1][j-1]==1){
                    buffer[currentRow][j]=0;
                }
                else{
                    buffer[currentRow][j]=buffer[lastRow][j]+buffer[currentRow][j-1];
                }
            }
            lastRow=currentRow;
        }
        return buffer[lastRow][obstacleGrid[0].length];
    }
}