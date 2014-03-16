public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || s.length() <= 1){
            return false;
        }
        boolean[] record = new boolean[s.length() + 1];
        if(dict.contains(s.substring(0, 1))){
            record[1] = true;
        }
        record[0] = true;
        for(int i = 2; i <= s.length(); i++){
            for(int j = i - 1; j >=0; j--){
                if(record[j] && dict.contains(s.substring(j, i))){
                    if(i != s.length() || j != 0){
                        record[i] = true;
                        break;
                    }
                }
            }
        }
        return record[s.length()];
    }
}

//the following method think that even without space is ok!

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(s == null || s.length() <= 0){
            return false;
        }
        boolean[] record = new boolean[s.length() + 1];
        if(dict.contains(s.substring(0, 1))){
            record[1] = true;
        }
        record[0] = true;
        for(int i = 2; i <= s.length(); i++){
            for(int j = i - 1; j >=0; j--){
                if(record[j] && dict.contains(s.substring(j, i))){
                        record[i] = true;
                        break;
                }
            }
        }
        return record[s.length()];
    }
}