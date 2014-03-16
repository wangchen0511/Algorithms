public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<String> ret=new ArrayList<String>();
        if(s.length()>12){
            return ret;
        }
        restoreHelper(ret,"",s,3);
        return ret;
    }
    
    
    private void restoreHelper(ArrayList<String> res, String prev, String source, int numPointer){
        if(source==null || source.equals("")){
            return;
        }
        if(numPointer==0){
            if(isValidNum(source)){
                res.add(prev+source);
            }
            return;
        }
        for(int i=1;i<=3;i++){
            if(i>source.length()){
                break;
            }
            String subStr=source.substring(0,i);
            String temp;
            if(isValidNum(subStr)){
                temp=prev+subStr+".";
                restoreHelper(res,temp,source.substring(i),numPointer-1);
            }
        }
    }
    
    private boolean isValidNum(String s){
        int val=Integer.parseInt(s);
        if(s.charAt(0)=='0' && s.length()>1){
            return false;
        }
        if(val<0 || val>255){
            return false;
        }
        return true;
    }
    
}