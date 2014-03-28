/**
   Letter Combinations of a Phone Number

   Given a digit string, return all possible letter combinations that the number could represent.

   A mapping of digit to letters (just like on the telephone buttons) is given below.



   Input:Digit string "23"
   Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
   Note:
   Although the above answer is in lexicographical order, your answer could be in any order you want.
 */


//v2
public class Solution {
    private static final char[][] table = {null, null, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        backTrack(new StringBuilder(), digits, 0, res);
        return res;
    }
    
    private void backTrack(final StringBuilder prev, final String digits, int start, final ArrayList<String> res){
        if(start >= digits.length()){
            res.add(prev.toString());
            return;
        }
        
        int num = digits.charAt(start) - '0';
        for(char character : table[num]){
            prev.append(character);
            backTrack(prev, digits, start + 1, res);
            prev.deleteCharAt(prev.length() - 1);
        }
    }
    
}







//v1
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[][] table={{"-"},{"@"},{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}}; 
        ArrayList<String> res=new ArrayList<String>();
        if(digits==null || digits.length()==0){
            res.add("");
            return res;
        }
        int correspondingNum=digits.charAt(0)-'0';
        if(digits.length()==1){
            res.addAll(Arrays.asList(table[correspondingNum]));
            return res;
        }
        ArrayList<String> temp=letterCombinations(digits.substring(1));
        for(int j=0;j<table[correspondingNum].length;j++){
            for(int i=0;i<temp.size();i++){
                res.add(table[correspondingNum][j]+temp.get(i));
            }
        }
        return res;
    }
}