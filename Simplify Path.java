public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        StringBuilder strBuilder=new StringBuilder();
        strBuilder.append(path.charAt(0));
        for(int i=1;i<path.length();i++){
            char current=path.charAt(i);
            char last=strBuilder.charAt(strBuilder.length()-1);
            if(current=='.' && last!='.'){
                strBuilder.append(current);
            }
            else if(current=='.' && last=='.'){
                removeLastDir(strBuilder);
            }
            else if(current=='/'){
                    if(strBuilder.charAt(strBuilder.length()-1)=='/'){
                        continue;
                    }
                    else if(strBuilder.charAt(strBuilder.length()-1)=='.'){
                        strBuilder.deleteCharAt(strBuilder.length()-1);
                        continue;
                    }
                    else{
                        strBuilder.append(current);            
                    }
            }
            else{
                strBuilder.append(current);
            }
        }
        for(int i=strBuilder.length()-1;i>=1;i--){
            if(strBuilder.charAt(strBuilder.length()-1)=='/' || strBuilder.charAt(strBuilder.length()-1)=='.'){
                strBuilder.deleteCharAt(strBuilder.length()-1);
            }
            else{
                break;
            }
        }
        return strBuilder.toString();
    }
    
    
    
    private void removeLastDir(StringBuilder strBuilder){
        if(strBuilder.length()<=2){
            strBuilder.deleteCharAt(strBuilder.length()-1);
        }
        else{
            strBuilder.delete(strBuilder.length()-2,strBuilder.length());
            for(int i=strBuilder.length()-1;i>=0;i--){
                if(strBuilder.charAt(i)!='/'){
                    strBuilder.deleteCharAt(i);
                }
                else{
                    if(strBuilder.length()!=1){
                        strBuilder.deleteCharAt(i);
                    }
                    break;
                }
            }
        }
    }
}







public class Solution {
    public String simplifyPath(String path) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i = 0; i < path.length() ; i++){
            if(stack.size() == 0){
                stack.push(path.charAt(i));
            }else if(path.charAt(i) == '/'){
                if(stack.peek() == '/'){
                    continue;
                }else if(stack.peek() == '.'){
                    stack.pop();
                }else{
                    stack.push('/');
                }
            }else if(path.charAt(i) == '.'){
                if(stack.peek() == '.'){
                    stack.pop();
                    stack.pop();
                    removeUntilSlash(stack);
                    if(stack.size() == 0){
                        stack.push('/');
                    }
                }else{
                    stack.push('.');   
                }
            }else{
                stack.push(path.charAt(i));
            }
        }
        if(stack.peek() == '.'){
            stack.pop();
        }
        if(stack.peek() == '/' && stack.size() > 1){
            stack.pop();
        }
        StringBuilder strBuilder = new StringBuilder();
        for(char c : stack){
            strBuilder.insert(0, c);
        }
        return strBuilder.toString();
    }
    
    private void removeUntilSlash(LinkedList<Character> stack){
        while(stack.size() > 0){
            if(stack.pop() == '/'){
                break;
            }
        }
    }
}