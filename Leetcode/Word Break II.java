public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<String>> record = new ArrayList<ArrayList<String>>();
        ArrayList<String> zeroItem = new ArrayList<String>();
        zeroItem.add("");
        record.add(zeroItem);
        for(int i = 1; i <= s.length(); i++){
            ArrayList<String> localRes = new ArrayList<String>();
            for(int j = 0; j < i; j++){
                String substr = s.substring(j, i);
                if(dict.contains(substr)){
                    for(String prevRes : record.get(j)){
                        if(i == s.length()){
                            localRes.add(prevRes + substr);
                        }else{
                            localRes.add(prevRes + substr + " ");   
                        }
                    }
                }
            }
            record.add(localRes);
        }
        return record.get(s.length());
    }
}





//remove some specific cases

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean isExistForward = false, isExistBack = false;
        for(int i = s.length() - 1; i >= 0; i--){
            String substr = s.substring(i, s.length());
            String substrForward = s.substring(0, i + 1);
            if(dict.contains(substr)){
                isExistForward = true;;
            }
            if(dict.contains(substrForward)){
                isExistBack = true;
            }
        }
        if(!isExistBack || !isExistForward){
            return new ArrayList<String>();
        }
        ArrayList<ArrayList<String>> record = new ArrayList<ArrayList<String>>();
        ArrayList<String> zeroItem = new ArrayList<String>();
        zeroItem.add("");
        record.add(zeroItem);
        for(int i = 1; i <= s.length(); i++){
            ArrayList<String> localRes = new ArrayList<String>();
            for(int j = 0; j < i; j++){
                String substr = s.substring(j, i);
                if(dict.contains(substr)){
                    for(String prevRes : record.get(j)){
                        if(i == s.length()){
                            localRes.add(prevRes + substr);
                        }else{
                            localRes.add(prevRes + substr + " ");   
                        }
                    }
                }
            }
            record.add(localRes);
        }
        return record.get(s.length());
    }
}






//best method!
public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < s.length(); i++){
            ArrayList<Integer> localRes = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                String substr = s.substring(j, i + 1);
                if(dict.contains(substr)){
                    if(j == 0){
                        localRes.add(j);
                    }else{
                        if(record.get(j - 1).size() > 0){
                            localRes.add(j);
                        }
                    }
                }
            }
            record.add(localRes);
        }
        ArrayList<String> res = new ArrayList<String>();
        backtrackPrint("", s.length() - 1, res, record, s);
        return res;
    }
    
    private void backtrackPrint(String prev, int end, ArrayList<String> res, ArrayList<ArrayList<Integer>> record, String origin){
        if(end < 0){
            res.add(prev);
            return;
        }
        String newRes = null;
        ArrayList<Integer> startIndex = record.get(end);
        for(int start : startIndex){
            String substr = origin.substring(start, end + 1);
            if(end == origin.length() - 1){
                newRes = substr;
            }else{
                newRes = substr + " " + prev;
            }
            backtrackPrint(newRes, start - 1, res, record, origin);
        }
    }
    
    
}