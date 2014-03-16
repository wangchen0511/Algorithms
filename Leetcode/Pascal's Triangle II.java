public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> lastRow=new ArrayList<Integer>();
        if(rowIndex<0){
            return lastRow;
        }
        ArrayList<Integer> currentRow=new ArrayList<Integer>();
        lastRow.add(1);
        for(int i=1;i<=rowIndex;i++){
            currentRow.add(1);
            for(int j=1;j<lastRow.size();j++){
                currentRow.add(lastRow.get(j)+lastRow.get(j-1));
            }
            currentRow.add(1);
            ArrayList<Integer> temp=lastRow;
            lastRow=currentRow;
            currentRow=temp;
            currentRow.clear();
        }
        return lastRow;
    }
}




public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> lastRow = new ArrayList<Integer>(rowIndex);
        ArrayList<Integer> currentRow = new ArrayList<Integer>(rowIndex);
        lastRow.add(1);
        lastRow.add(1);
        currentRow.add(1);
        if(rowIndex == 0){
            return currentRow;
        }else if(rowIndex == 1){
            return lastRow;
        }
        for(int i = 2; i <= rowIndex; i++){
            currentRow.clear();
            currentRow.add(1);
            for(int j = 1; j < i; j++){
                currentRow.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            currentRow.add(1);
            ArrayList<Integer> temp = currentRow;
            currentRow = lastRow;
            lastRow = temp;
        }
        return lastRow;
    }
}