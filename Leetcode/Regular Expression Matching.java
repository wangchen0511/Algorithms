/**
   Regular Expression Matching:

   '.' Matches any single character.
   '*' Matches zero or more of the preceding element.

   The matching should cover the entire input string (not partial).

   The function prototype should be:
   bool isMatch(const char *s, const char *p)

   Some examples:
   isMatch("aa","a") → false
   isMatch("aa","aa") → true
   isMatch("aaa","aa") → false
   isMatch("aa", "a*") → true
   isMatch("aa", ".*") → true
   isMatch("ab", ".*") → true
   isMatch("aab", "c*a*b") → true
 */


//v2

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] records = new boolean[2][p.length() + 1];
        int lastRow = 0;
        for(int i = 0; i <= p.length(); i++){
            if(i == 0){
                records[lastRow][i] = true;
            }else if(p.charAt(i - 1) == '*'){
                records[lastRow][i] = records[lastRow][i - 2];
            }else{
                records[lastRow][i] = false;
            }
        }
        for(int i = 1; i <= s.length(); i++){
            int currentRow = 1 - lastRow;
            records[currentRow][0] = false;
            char sChar = s.charAt(i - 1);
            for(int j = 1; j <= p.length(); j++){
                char pChar = p.charAt(j - 1);
                if(pChar == '.' || pChar == sChar){
                    records[currentRow][j] = records[lastRow][j - 1];
                }else if(pChar == '*'){
                    if(j == 1){
                        records[currentRow][j] = false;
                    }else{
                        if(p.charAt(j - 2) == sChar || p.charAt(j - 2) == '.'){
                            records[currentRow][j] = records[currentRow][j - 2] | records[lastRow][j];
                        }else{
                            records[currentRow][j] = records[currentRow][j - 2];
                        }
                    }
                }else{
                    records[currentRow][j] = false;
                }
            }
            lastRow = currentRow;
        }
        return records[lastRow][p.length()];
    }
}








//v1
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






