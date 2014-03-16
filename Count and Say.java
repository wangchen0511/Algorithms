public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String value="1";
        for(int i=1;i<n;i++){
            value=getNext(value);
        }
        return value;
    }
    
    private String getNext(String n){
         // DO NOT write main() function
        StringBuilder builder=new StringBuilder();
        char prev=n.charAt(0);
        int count=1;
        for(int i=1;i<n.length();i++){
            char current=n.charAt(i);
            if(current==prev){
                count++;
            }
            else{
                builder.append(count);
                builder.append(prev);
                count=1;
                prev=current;
            }
        }
        builder.append(count);
        builder.append(prev);
        return builder.toString();
    }
}