public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> history = new HashSet<String>();
        Queue<String> lastRow = new LinkedList<String>();
        lastRow.offer(start);
        history.add(start);
        int deep = 1;
        while(lastRow.size() > 0){
            deep++;
            Queue<String> currentRow = new LinkedList<String>();
            for(String node : lastRow){
                ArrayList<String> children = findAllChildren(node);
                for(String child : children){
                    if(child.equals(end)){
                        return deep;
                    }else if(dict.contains(child) && !history.contains(child)){
                        currentRow.offer(child);
                        history.add(child);
                    }
                }
            }
            lastRow = currentRow;
        }
        return 0;
    }
    
    private ArrayList<String> findAllChildren(String source){
        ArrayList<String> res = new ArrayList<String>();
        char[] charSource = source.toCharArray();
        for(int i = 0; i< charSource.length; i++){
            char origin = charSource[i];
            for(int j = 0; j < 26; j++){
                char replace = (char) ('a' + j);
                charSource[i] = replace;
                if(replace != origin){
                    res.add(new String(charSource));
                }
            }
            charSource[i] = origin;
        }
        return res;
    }
}