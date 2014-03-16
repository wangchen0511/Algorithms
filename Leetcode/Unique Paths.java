public class Solution {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] buffer = new int[2][n+1];
        int lastRow=0;
        Arrays.fill(buffer[0],1);
        for(int i=2;i<=m;i++){
            int currentRow=(lastRow+1)%2;
            buffer[currentRow][1]=1;
            for(int j=2;j<=n;j++){
                buffer[currentRow][j]=buffer[currentRow][j-1]+buffer[lastRow][j];
            }
            lastRow=currentRow;
        }
        return buffer[lastRow][n];
    }
}