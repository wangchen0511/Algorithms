public class Solution {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] target= new int[256];
        int[] buffer=new int[256];
        for(int i=0;i<T.length();i++){
            target[(int)T.charAt(i)]++;
        }
        int matchedNum=0;
        String minStr="";
        int totalNum=T.length();
        int head=0,tail=-1;
        while(true){
            if(tail==S.length()-1 && matchedNum<T.length()){
                break;
            }
            if(matchedNum<T.length()){
                char current=S.charAt(++tail);
                if(buffer[(int)current]<target[(int)current]){
                    matchedNum++;
                }
                buffer[(int)current]++;
            }
            else if(matchedNum>=T.length()){
                char current=S.charAt(head++);
                buffer[(int)current]--;
                if(buffer[(int)current]<target[(int)current]){
                    matchedNum--;
                }
            }
            if(matchedNum==T.length()){
                if(minStr.equals("")){
                    minStr=S.substring(head,tail+1);
                }
                else if(tail-head+1<minStr.length()){
                    minStr=S.substring(head,tail+1);
                }
            }
        }
        return minStr;
    }
}