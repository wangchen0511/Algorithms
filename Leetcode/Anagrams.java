public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res=new ArrayList<String>();
        if(strs==null || strs.length==0){
            return res;
        }
        HashMap<String, Integer> maps=new HashMap<String,Integer>();
        String[] sortedStrings=new String[strs.length];
        for(int i=0;i<strs.length;i++){
            sortedStrings[i]=sort(strs[i]);
            if(!maps.containsKey(sortedStrings[i])){
                maps.put(sortedStrings[i],1);
            }
            else{
                maps.put(sortedStrings[i],maps.get(sortedStrings[i])+1);
            }
        }
        for(int i=0;i<strs.length;i++){
            if(maps.get(sortedStrings[i])>1){
                res.add(strs[i]);
            }
        }
        return res;
    }
    
    private String sort(String input){
        if(input==null){
            return null;
        }
        char[] chars= input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}