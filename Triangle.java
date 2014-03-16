public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(triangle==null || triangle.size()==0){
            return 0;
        }
        int[] min=new int[1];
        min[0]=Integer.MAX_VALUE;
        int prev=0;
        minimumTotalHelper(triangle,0,min,0,0);
        return min[0];
        
    }
    
    
    private void minimumTotalHelper(ArrayList<ArrayList<Integer>> triangle, int prev, int[] min, int row, int col){
        if(row>=triangle.size()){
            min[0]=min[0]>prev?prev:min[0];
            return;
        }
        prev+=triangle.get(row).get(col);
        minimumTotalHelper(triangle,prev,min,row+1,col);
        minimumTotalHelper(triangle,prev,min,row+1,col+1);
    }
    
}


//method 2
public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] opt=new int[triangle.size()];
        for(int i=0;i<triangle.size();i++){
            opt[i]=triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                opt[j]=Math.min(opt[j],opt[j+1])+triangle.get(i).get(j);
            }
        }
        return opt[0];
    }
}