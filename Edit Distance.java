public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(word1==""){
            return word2.length();
        }
        else if(word2==""){
            return word1.length();
        }
        int[][] recordTable=new int[2][word1.length()+1];
        int lastRow=0;
        recordTable[0][0]=0;
        for(int i=1;i<=word1.length();i++){
            recordTable[0][i]=i;
        }
        for(int i=1;i<=word2.length();i++){
            int currentRow=(lastRow+1)%2;
            recordTable[currentRow][0]=i;
            for(int j=1;j<=word1.length();j++){
                if(word2.charAt(i-1)==word1.charAt(j-1)){
                    recordTable[currentRow][j]=recordTable[lastRow][j-1];
                }
                else{
                    int insert=recordTable[lastRow][j];
                    int delete=recordTable[currentRow][j-1];
                    int replace= recordTable[lastRow][j-1];
                    recordTable[currentRow][j]=Math.min(Math.min(insert,delete),replace)+1;
                }
            }
            lastRow=currentRow;
        }
        return recordTable[lastRow][word1.length()];
        
    }
}