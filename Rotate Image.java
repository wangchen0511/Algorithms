public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(matrix==null || matrix.length==0 || matrix.length==1){
            return;
        }
        for(int row=0;row<=(matrix.length-1)/2;row++){
            for(int col=0;col<=(matrix[0].length-2)/2;col++){
                int originalSecond=matrix[col][matrix.length-1-row];
                matrix[col][matrix.length-1-row]=matrix[row][col];
                int originalThird=matrix[matrix.length-1-row][matrix[0].length-1-col];
                matrix[matrix.length-1-row][matrix[0].length-1-col]=originalSecond;
                int originalFourth=matrix[matrix[0].length-1-col][row];
                matrix[matrix[0].length-1-col][row]=originalThird;
                matrix[row][col]=originalFourth;
            }
        }
    }
}