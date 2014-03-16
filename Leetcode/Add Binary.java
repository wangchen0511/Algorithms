public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder strBuilder=new StringBuilder();
        int indexA=a.length()-1;
        int indexB=b.length()-1;
        int c=0;
        while(indexA>=0 || indexB>=0){
            int next=0;
            if(indexA<0){
                next=b.charAt(indexB)-'0'+c;
            }
            else if(indexB<0){
                next=a.charAt(indexA)-'0'+c;
            }
            else{
                next=a.charAt(indexA)-'0'+b.charAt(indexB)-'0'+c;
            }
            strBuilder.insert(0,(char)('0'+next%2));
            c=next/2;
            indexA--;
            indexB--;
        }   
        if(c!=0){
            strBuilder.insert(0,'1');
        }
        return strBuilder.toString();      
    }
}