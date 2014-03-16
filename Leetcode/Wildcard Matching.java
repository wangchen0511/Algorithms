//大数据超时！

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null && p==null){
            return true;
        }
        if(s.length()==0 && p.length()==0){
            return true;
        }
        if(s==null || p==null){
            return false;
        }
        boolean[][] opt=new boolean[2][p.length()+1];
        int lastRow=0;
        opt[lastRow][0]=true;
        
        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='?'){
                opt[lastRow][i]=false;
            }
            else if(p.charAt(i-1)=='*'){
                opt[lastRow][i]=opt[lastRow][i-1];
            }
            else{
                opt[lastRow][i]=false;
            }
        }
        for(int i=1;i<=s.length();i++){
            int currentRow=(lastRow+1)%2;
            opt[currentRow][0]=false;
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)=='?'){
                    opt[currentRow][j]=opt[lastRow][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    if(opt[lastRow][j-1] || opt[lastRow][j] || opt[currentRow][j-1]){
                        opt[currentRow][j]=true;
                    }
                    else{
                        opt[currentRow][j]=false;
                    }
                }
                else{
                    if(p.charAt(j-1)==s.charAt(i-1)){
                        opt[currentRow][j]=opt[lastRow][j-1];
                    }
                    else{
                        opt[currentRow][j]=false;
                    }
                }
            }
            lastRow=currentRow;
        }
        return opt[lastRow][p.length()];
    }
}


//Greedy

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p==null){
            if(s==null){
                return true;
            }
            else{
                return false;
            }
        }
        
        if(p.equals("")){
            	if(s.equals("")){
	        		return true;
	        	}
	        	else{
	        		return false;
	        	}
	        }
	        if(s.equals("")){
	        	if(p.equals("*")){
	        		return true;
	        	}
	        	else{
	        		return false;
	        	}
	        }
        
         String[] pattern;
            if(p.indexOf("*")>=0){
	        	pattern=p.split("\\*");
	        }
	        else{
	        	pattern=new String[]{p};
	        }
        int basePos=0;
        for(int i=0;i<pattern.length;i++){
            int matchedStart=s.indexOf(pattern[i],basePos);
            if(matchedStart==-1){
                return false;
            }
            if(i==0 && p.charAt(0)!='*' && matchedStart!=0){
                return false;
            }
            if(i==pattern.length-1 && p.charAt(p.length()-1)!='*' && matchedStart!=s.length()-pattern[i].length()){
                return false;
            }
            basePos=matchedStart+pattern[i].length();
        }
        return true;
    }
}
















public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && s == null){
            return true;
        }
        if(s == null || s == null){
            return false;
        }
        if(s.length() == 0 && p.length() == 0){
            return true;
        }
        if(p.length() == 0){
            return false;
        }
        String[] splitedStr = p.split("\\*");
        int startIndex = 0;
        for(int i = 0; i < splitedStr.length; i++){
            int nextStart = search(s, startIndex, splitedStr[i]);
            if(nextStart == -1){
                return false;
            }else{
                if(p.charAt(0) != '*' && i == 0){
                    if(nextStart != splitedStr[0].length()){
                        return false;
                    }
                }
                if(p.charAt(p.length() - 1) != '*' && i == splitedStr.length - 1){
                    if(nextStart != s.length()){
                        return false;
                    }
                }
            }
            startIndex = nextStart;
        }
        return true;
    }
    
    private int search(String s, int startIndex, String target){
        if(target == null || target.length() == 0){
            return startIndex;
        }
        for(int i = startIndex; i <= s.length() - target.length(); i++){
            boolean isMatched = true;
            for(int j = 0; j < target.length(); j++){
                if(target.charAt(j) != '?' && s.charAt(i + j) != target.charAt(j)){
                    isMatched = false;
                    break;
                }
            }
            if(isMatched){
                return i + target.length();                
            }
        }
        return -1;
    }
    
}


//The following is correct version

public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(p == null && s == null){
            return true;
        }
        if(s == null || s == null){
            return false;
        }
        if(s.length() == 0 && p.length() == 0){
            return true;
        }
        if(p.length() == 0){
            return false;
        }
        if(!p.contains("*")){
            if(s.length() != p.length()){
                return false;
            }else{
                if(search(s, 0, p) < 0){
                    return false;
                }
                return true;
            }
        }
        String[] splitedStr = p.split("\\*");
        int startIndex = 0;
        for(int i = 0; i < splitedStr.length; i++){
            int nextStart = search(s, startIndex, splitedStr[i]);
            if(nextStart == -1){
                return false;
            }else{
                if(p.charAt(0) != '*' && i == 0){
                    if(nextStart != splitedStr[0].length()){
                        return false;
                    }
                }
                if(p.charAt(p.length() - 1) != '*' && i == splitedStr.length - 1){
                    int temp = search(s, s.length() - splitedStr[i].length(), splitedStr[i]);
                    if(temp == -1){
                        return false;
                    }
                }
            }
            startIndex = nextStart;
        }
        return true;
    }
    
    private int search(String s, int startIndex, String target){
        if(target == null || target.length() == 0){
            return startIndex;
        }
        for(int i = startIndex; i <= s.length() - target.length(); i++){
            boolean isMatched = true;
            for(int j = 0; j < target.length(); j++){
                if(target.charAt(j) != '?' && s.charAt(i + j) != target.charAt(j)){
                    isMatched = false;
                    break;
                }
            }
            if(isMatched){
                return i + target.length();                
            }
        }
        return -1;
    }
    
}