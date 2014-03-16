public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(board==null || board.length==0 || board[0]==null || board[0].length==0){
            return false;
        }
        boolean[][] mask= new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(isExist(board,i,j,word,mask)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    private boolean isExist(char[][] board, int x, int y, String word, boolean[][] mask){
        if(word==null || word.length()==0){
            return true;
        }
        if(x<0 || x>=board.length){
            return false;
        }
        if(y<0 || y>=board[0].length){
            return false;
        }
        if(mask[x][y]){
            return false;
        }
        if(board[x][y]!=word.charAt(0)){
            return false;
        }
        mask[x][y]=true;
        if(isExist(board,x-1,y,word.substring(1),mask)){
            mask[x][y]=false;
            return true;
        }
        else if(isExist(board,x+1,y,word.substring(1),mask)){
            mask[x][y]=false;
        
            return true;
        }
        else if(isExist(board,x,y-1,word.substring(1),mask)){
            mask[x][y]=false;
            return true;
        }
        else if(isExist(board,x,y+1,word.substring(1),mask)){
            mask[x][y]=false;
            return true;
        }
        else{
            mask[x][y]=false;
            return false;
        }        
    }
}

















public class Solution {
    public boolean exist(char[][] board, String word) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(board == null || board.length < 1 || board[0] == null || board[0].length < 1){
            return false;
        }
        if(word == null || word.length() == 0){
            return true;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backTrack(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backTrack(char[][] board, String word, int x, int y, int startIndex){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return false;
        }
        if(board[x][y] != word.charAt(startIndex)){
            return false;
        }
        if(startIndex == word.length() - 1){
            return true;
        }
        startIndex++;
        char buffer = board[x][y];
        board[x][y] = '\u0000';
        if(backTrack(board, word, x + 1, y, startIndex) || backTrack(board, word, x - 1, y, startIndex) || backTrack(board, word, x, y - 1, startIndex) || backTrack(board, word, x, y + 1, startIndex)){
            board[x][y] = buffer;
            return true;
        }
        board[x][y] = buffer;
        return false;
    }
}












