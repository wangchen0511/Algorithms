public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1==null && s2==null && s3==null){
            return true;
        }
        else if(s1==null || s2==null || s3==null){
            return false;
        }
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] record=new boolean[2][s1.length()+1];
        int lastRow=0;
        record[lastRow][0]=true;
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1)!=s3.charAt(i-1)){
                record[lastRow][i]=false;
            }
            else{
                record[lastRow][i]=record[lastRow][i-1];
            }
        }
        for(int i=1;i<=s2.length();i++){
            int currentRow=(lastRow+1)%2;
            if(s2.charAt(i-1)!=s3.charAt(i-1)){
                record[currentRow][0]=false; 
            }
            else{
                record[currentRow][0]=record[lastRow][0];
            }
            for(int j=1;j<=s1.length();j++){
                if(s1.charAt(j-1)!=s3.charAt(i+j-1) && s2.charAt(i-1)!=s3.charAt(i+j-1)){
                    record[currentRow][j]=false;
                }
                else if(s1.charAt(j-1)!=s3.charAt(i+j-1)){
                    record[currentRow][j]=record[lastRow][j];
                }
                else if(s2.charAt(i-1)!=s3.charAt(i+j-1)){
                    record[currentRow][j]=record[currentRow][j-1];
                }
                else{
                    record[currentRow][j]=record[currentRow][j-1] | record[lastRow][j];
                }
            }
            lastRow=currentRow;
        }
        return record[lastRow][s1.length()];
    }
    
    
    
    
}