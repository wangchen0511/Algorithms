public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] record=new int[2][T.length()+1];
        int lastRow=0;
        record[lastRow][0]=1;
        for(int i=1;i<=T.length();i++){
            record[lastRow][i]=0;
        }
        for(int i=1;i<=S.length();i++){
            int currentRow=(lastRow+1)%2;
            record[currentRow][0]=1;
            for(int j=1;j<=T.length();j++){
                if(S.charAt(i-1)==T.charAt(j-1)){
                    record[currentRow][j]=record[lastRow][j-1]+record[lastRow][j];
                }
                else{
                    record[currentRow][j]=record[lastRow][j];
                }
            }
            lastRow=currentRow;
        }
        return record[lastRow][T.length()];
    }
}