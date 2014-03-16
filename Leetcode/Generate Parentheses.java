public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return generateParenth(n,n);
    }
    
    private ArrayList<String> generateParenth(int left, int right){
        ArrayList<String> sets=new ArrayList<String>();
        if(left==0){
            StringBuilder builder=new StringBuilder();
            for(int i=0;i<right;i++){
                builder.append(")");
            }
            sets.add(builder.toString());
            return sets;
        }
        if(left<right){
            ArrayList<String> buffer=generateParenth(left-1,right);
            for(int i=0;i<buffer.size();i++){
                sets.add("("+buffer.get(i));
            }
            buffer=generateParenth(left,right-1);
            for(int i=0;i<buffer.size();i++){
                sets.add(")"+buffer.get(i));
            }
        }
        else{
            ArrayList<String> buffer=generateParenth(left-1,right);
            for(int i=0;i<buffer.size();i++){
                sets.add("("+buffer.get(i));
            } 
        }
        return sets;
    }
}