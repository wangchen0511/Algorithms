public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        solveSudoku1(board,0,0);
    }
    
    private boolean solveSudoku1(char[][] board,int row, int col){
        for(;row<9;row++){
            for(;col<9;col++){
                if(board[row][col]=='.'){
                    break;
                }
            }
            if(col<9 && board[row][col]=='.'){
                break;
            }
            col=0;
        }
        if(row==9){
            return true;
        }
        for(int i=0;i<9;i++){
            board[row][col]=(char)('1'+i);
            if(isValid(board,row,col)){
                if(solveSudoku1(board,row+(col+1)/9,(col+1)%9)){
                    return true;
                }
            } 
            board[row][col]='.';
        }
        return false;
    }
    
    
    
    private boolean isValid(char[][] board,int row, int col) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<Character> set=new HashSet<Character>();
        for(int i=0;i<9;i++){
            if(board[row][i]!='.'){
                if(set.contains(board[row][i])){
                    return false;
                }
                else{
                    set.add(board[row][i]);
                }
            }
        }
        
        set.clear();
        
        for(int i=0;i<9;i++){
            if(board[i][col]!='.'){
                if(set.contains(board[i][col])){
                    return false;
                }
                else{
                    set.add(board[i][col]);
                }
            }
        }
        
        row=row/3*3;
        col=col/3*3;
        set.clear();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               if(board[row+i][col+j]!='.'){
                if(set.contains(board[row+i][col+j])){
                    return false;
                }
                else{
                    set.add(board[row+i][col+j]);
                }
            } 
            }
        }
        return true;
        
    }
}




//version 2
public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        backtrack(board, 0, 0);
    }
    
    private boolean backtrack(char[][] board, int x, int y){
        if(x > 8){
            return true;
        }
        int nextX = x + (y + 1) / 9;
        int nextY = (y + 1) % 9;
        if(board[x][y] != '.'){
            return backtrack(board, nextX, nextY);
        }
        for(int i = 1; i <= 9; i++){
            char inserted = (char) ('0' + i);
            board[x][y] = inserted;
            if(isValid(board, x, y)){
                if(backtrack(board, nextX, nextY)){
                    return true;
                }
            }
        }
        board[x][y] = '.';
        return false;
    }
    
    private boolean isValid(char[][] board, int x, int y){
        for(int i = 0; i < 9; i++){
            if(i != x && board[i][y] == board[x][y]){
                return false;
            }
        }
        for(int i = 0; i < 9; i++){
            if(i != y && board[x][i] == board[x][y]){
                return false;
            }
        }
        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 3; j++){
                if(((startX + i) != x || (startY +j) != y) && board[startX + i][startY + j] == board[x][y]){
                    return false;
                }
            }
        }
        return true;
    }
}