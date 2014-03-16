public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0 || matrix[0]==null || matrix[0].length==0){
            return res;
        }
        int startRow=0;
        int startCol=0;
        int height=matrix.length;
        int width=matrix[0].length;
        for(int j=0;j<=Math.min((height-1)/2,(width-1)/2);j++){
            int row=startRow+j;
            int col=startCol+j;
            int localWidth=width-2*j;
            int localHeight=height-2*j;
            for(int i=0;i<localWidth;i++){
                res.add(matrix[row][col+i]);
            }
            for(int i=1;i<localHeight;i++){
                res.add(matrix[row+i][col+localWidth-1]);
            }
            if(localHeight==1){
                break;
            }
            for(int i=localWidth-2;i>=0;i--){
                res.add(matrix[row+localHeight-1][col+i]);
            }
            if(localWidth==1){
                break;
            }
            for(int i=localHeight-2;i>=1;i--){
                res.add(matrix[row+i][col]);
            }
        }
        return res;
    }
}