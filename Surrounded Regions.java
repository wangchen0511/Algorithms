public class Solution {
    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return;
        }
        for(int i = 0; i < board[0].length; i++){
            colorO(board, 0, i);
            colorO(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++){
            colorO(board, i, 0);
            colorO(board, i, board[0].length - 1);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'z'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    private void colorO(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length){
            return;
        }else if(board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'z';
        colorO(board, x + 1, y);
        colorO(board, x - 1, y);
        colorO(board, x, y + 1);
        colorO(board, x, y - 1);
    }
    
}