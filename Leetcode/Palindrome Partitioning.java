public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> res=new  ArrayList<ArrayList<String>>();
        ArrayList<String> prev=new ArrayList<String>();
        partitionHelper(prev,res,s);
        return res;
    }
    
    
    private void partitionHelper(ArrayList<String> prev, ArrayList<ArrayList<String>> res, String source){
        if(source.length()==1){
            ArrayList<String> ret=new ArrayList<String>(prev);
            ret.add(source);
            res.add(ret);
            return;
        }
        if(source.length()==0){
            ArrayList<String> ret=new ArrayList<String>(prev);
            res.add(ret);
            return;
        }
        for(int i=1;i<=source.length();i++){
            String subStr=source.substring(0,i);
            if(isPalindro(subStr)){
                prev.add(subStr);
                partitionHelper(prev,res,source.substring(i));
                prev.remove(prev.size()-1);
            }
        }
    }
    
    private boolean isPalindro(String a){
        int head=0,tail=a.length()-1;
        while(head<tail){
            if(a.charAt(head++)!=a.charAt(tail--)){
                return false;
            }
        }
        return true;
    }
}



//The following method uses DP!
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<ArrayList<String>>> opt = new ArrayList<ArrayList<ArrayList<String>>>();
        ArrayList<ArrayList<String>> zeroIndex = new ArrayList<ArrayList<String>>();
        ArrayList<String> valueForZero = new ArrayList<String>();
        zeroIndex.add(valueForZero);
        opt.add(zeroIndex);
        for(int i = 1; i <= s.length(); i++){
            ArrayList<ArrayList<String>> localRes = new ArrayList<ArrayList<String>>();
            for(int start = i; start > 0 ; start--){
                if(isPalindrome(s, start - 1, i - 1)){
                    ArrayList<ArrayList<String>> lastRes = opt.get(start - 1);
                    for(ArrayList<String> str : lastRes){
                        ArrayList<String> temp = new ArrayList<String>(str);
                        temp.add(s.substring(start - 1, i));
                        localRes.add(temp);
                    }
                }
            }
            opt.add(localRes);
        }
        return opt.get(s.length());
    }
    
    private boolean isPalindrome(String s, int from, int to){
        while(from < to){
            if(s.charAt(from++) != s.charAt(to--)){
                return false;
            }
        }
        return true;
    }
    
}




//下面那个是用DP＋backtrack : save more space but the problem is the ArrayList<String> add(0, a) this is low efficient.
public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> record = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < s.length(); i++){
            ArrayList<Integer> localRes = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(isPalindrome(s, j, i)){
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
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        backtrackPrint(new ArrayList<String>(), s.length() - 1, res, s, record);
        return res;
    }
    
    private void backtrackPrint(ArrayList<String> prev, int end, ArrayList<ArrayList<String>> res, String origin, ArrayList<ArrayList<Integer>> record){
        if(end < 0){
            res.add(new ArrayList<String>(prev));
            return;
        }
        ArrayList<Integer> startIndexes = record.get(end);
        for(int start : startIndexes){
            String substr = origin.substring(start, end + 1);
            prev.add(0, substr);
            backtrackPrint(prev, start - 1, res, origin, record);
            prev.remove(0);
        }
        
    }
    
    
    private boolean isPalindrome(String s, int from, int to){
        while(from < to){
            if(s.charAt(from++) != s.charAt(to--)){
                return false;
            }
        }
        return true;
    }
    
}
