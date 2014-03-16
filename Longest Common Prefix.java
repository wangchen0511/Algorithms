public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs==null || strs.length==0){
            return "";
        }   
        int i=0;
        for(;i<strs[0].length();i++){
            char standChar=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i || strs[j].charAt(i)!=standChar){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,i);
    }
}