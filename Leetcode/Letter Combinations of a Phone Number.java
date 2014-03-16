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