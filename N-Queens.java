public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res=new ArrayList<String[]>();
        if(n==0){
            return res;
        }
        String[] current=new String[n];
        getAllQ(current,0,n,res);
        return res;
    }
    
    private void getAllQ(String[] current, int nextLine, int total,ArrayList<String[]> res){
        StringBuilder templateBuilder=new StringBuilder();
        for(int i=0;i<total-1;i++){
            templateBuilder.append(".");
        }
        String template=templateBuilder.toString();
        if(nextLine>=total){
            res.add(Arrays.copyOfRange(current,0,total));
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