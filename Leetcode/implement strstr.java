public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(haystack==null || needle==null){
            return null;
        }
        if(needle.length()>haystack.length()){
            return null;
        }
        if(needle.length()==0 && haystack.length()==0){
            return "";
        }
        for(int i=0;i<haystack.length();i++){
            if(haystack.length()-i<needle.length()){
                return null;
            }
            boolean isMatch=true;
            for(int j=0;j<needle.length();j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    isMatch=false;
                    break;
                }
            }
            if(isMatch){
                return haystack.substring(i);
            }
        }
        return null;
        
    }
}