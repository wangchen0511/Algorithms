public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        LinkedList<Character> stack=new LinkedList<Character>();
        for(int i=0;i<s.length();i++){
            if(stack.size()==0){
                stack.addFirst(s.charAt(i));
            }
            else if(s.charAt(i)==')' && stack.getFirst()=='('){
                stack.removeFirst();
            }
            else if(s.charAt(i)==']' && stack.getFirst()=='['){
                stack.removeFirst();
            }
            else if(s.charAt(i)=='}' && stack.getFirst()=='{'){
                stack.removeFirst();
            }
            else{
                stack.addFirst(s.charAt(i));
            }
        }
        if(stack.size()==0){
            return true;
        }
        else{
            return false;
        }
    }
}