public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean[][] record=new boolean[2][p.length()+1];
        int lastRow=0;
        record[0][0]=true;
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*' && record[0][i-2]){
                record[0][i]=true;
            }
            else{
                record[0][i]=false;
            }
        }
        for(int i=1;i<=s.length();i++){
            int currentRow=getCurrentRow(lastRow);
            record[currentRow][0]=false;
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    record[currentRow][j]=record[lastRow][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)!=s.charAt(i-1) && p.charAt(j-2)!='.'){
                        record[currentRow][j]=record[currentRow][j-2];
                    }
                    else{
                        if(record[lastRow][j]){
                            record[currentRow][j]=true;
                        }
                        else if(record[lastRow][j-2]){
                            record[currentRow][j]=true;
                        }
                        else if(record[currentRow][j-2]){
                            record[currentRow][j]=true;
                        }
                        else{
                            record[currentRow][j]=false;
                        }
                    }
                }
                else{
                    record[currentRow][j]=false;
                }
            }
            lastRow=currentRow;
        }
        return record[lastRow][p.length()];
    }
    
    private int getCurrentRow(int x){
        switch(x){
            case 0:
                return 1;
            case 1:
                return 0;
            default:
                return 0;
        }
    }
}