//this method use DFS, can not pass big data!
public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] min=new int[1];
        min[0]=-1;
        minCutHelper(0,s,min);
        return min[0];
    }
    
    
    private void minCutHelper(int prevCut,String source, int[] min){
        if(min[0]>=0 && prevCut>=min[0]){
            return;
        }
        if(source.length()<=1){
            if(min[0]<0){
                min[0]=prevCut;
            }
            else{
                min[0]=Math.min(min[0],prevCut);
            }
        }
        for(int i=source.length();i>=1;i--){
            String subStr=source.substring(0,i);
            if(isPalindro(subStr)){
                if(i!=source.length()){
                    minCutHelper(prevCut+1,source.substring(i),min);
                }
                else{
                     minCutHelper(prevCut,source.substring(i),min);
                }
            }
        }
    }
    
    private boolean isPalindro(String a){
        int head=0,tail=a.length()-1;
        while(head<tail){
            if(a.charAt(head++)!=a.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
    
}