//This method is correct, but not optimal for this problem!


public class Solution {
    public int totalNQueens(int n)  {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] res=new int[1];
        if(n==0){
            return res[0];
        }
        StringBuilder templateBuilder=new StringBuilder();
        for(int i=0;i<n-1;i++){
            templateBuilder.append(".");
        }
        String template=templateBuilder.toString();
        String[] current=new String[n];
        if(n-2>=0){
            for(int i=0;i<=(n-2)/2;i++){
                String oneCase=template.substring(0,i)+"Q"+template.substring(i);
                current[0]=oneCase;
                getAllQ(current,1,n,res);
            }
        }
        res[0]=res[0]*2;
        if(n%2==1){
            String oneCase=template.substring(0,n/2)+"Q"+template.substring(n/2);
            current[0]=oneCase;
            getAllQ(current,1,n,res);
        }
        return res[0];
    }
    
    private void getAllQ(String[] current, int nextLine, int total, int[] res){
        StringBuilder templateBuilder=new StringBuilder();
        for(int i=0;i<total-1;i++){
            templateBuilder.append(".");
        }
        String template=templateBuilder.toString();
        if(nextLine>=total){
            res[0]++;
            return;
        }
        for(int i=0;i<total;i++){
            String oneCase=template.substring(0,i)+"Q"+template.substring(i);
            current[nextLine]=oneCase;
            if(isValid(current,nextLine,i,total)){
                 getAllQ(current,nextLine+1,total,res);
            }
        }
    }
    
    private boolean isValid(String[] current, int row, int col, int n){
        for(int i=0;i<row;i++){
            if(current[i].charAt(col)=='Q'){
                return false;
            }
        }
        int tempRow=row-1;
        int tempCol=col-1;
        while(tempRow>=0 && tempCol>=0){
            if(current[tempRow--].charAt(tempCol--)=='Q'){
                return false;
            }
        }
        tempRow=row-1;
        tempCol=col+1;
        while(tempRow>=0 && tempCol<n){
            if(current[tempRow--].charAt(tempCol++)=='Q'){
                return false;
            }
        }
        return true;
    }
}












This is a better way for this problem!










public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n==0){
            return 0;
        }
        int[] current=new int[n];
        int[] res=new int[1];
        if(n-2>=0){
            for(int i=0;i<=(n-2)/2;i++){
                current[0]=i;
                getALLQ(current,1,n,res);
            }
        }
        res[0]=res[0]*2;
        if(n%2==1){
            current[0]=n/2;
            getALLQ(current,1,n,res);
        }
        return res[0];
    }
    
    private void getALLQ(int[] current, int nextLine, int total, int[] res){
        if(nextLine>=total){
            res[0]++;
            return;
        }
        for(int i=0;i<total;i++){
            current[nextLine]=i;
            if(isValid(current,nextLine)){
                getALLQ(current,nextLine+1,total,res);
            }
        }
    }
    
    private boolean isValid(int[] current, int row){
        for(int i=0;i<row;i++){
            if(current[i]==current[row] || Math.abs(current[i]-current[row])==row-i){
                return false;
            }
        }
        return true;
    }
    
}