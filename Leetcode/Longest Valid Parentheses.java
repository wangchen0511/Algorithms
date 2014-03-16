public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Integer> stack=new LinkedList<Integer>();
        if(s==null ||s.length()==0){
            return 0;
        }
        stack.addFirst(0);
        for(int i=1;i<s.length();i++){
            if(stack.size()==0){
                stack.addFirst(i);
            }
            else if(s.charAt(i)==')' && s.charAt(stack.getFirst())=='('){
                stack.removeFirst();
            }
            else{
                stack.addFirst(i);
            }
        }
        int max=0;
        int prev=s.length();
        while(stack.size()!=0){
            int temp=stack.getFirst();
            max=(prev-temp-1)>max?(prev-temp-1):max;
            prev=temp;
            stack.removeFirst();
        }
        max=prev>max?prev:max;
        return max;
        
    }
}