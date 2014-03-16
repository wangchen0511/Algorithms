public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i=0;i<board.length;i++){
            Set<Character> set=new HashSet<Character>();
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]!='.'){
                    if(set.contains(board[i][j])){
                        return false;
                    }
                    else{
                        set.add(board[i][j]);
                    }
                }
            }
        }
        for(int i=0;i<board.length;i++){
            Set<Character> set=new HashSet<Character>();
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]!='.'){
                    if(set.contains(board[j][i])){
                        return false;
                    }
                    else{
                        set.add(board[j][i]);
                    }
                }
            }
        }
        for(int i=0;i<9;i++){
            int row=i/3*3;
            int col=(i%3)*3;
            Set<Character> set=new HashSet<Character>();
            for(int j=row;j<row+3;j++){
                for(int k=col;k<col+3;k++){
                    if(board[j][k]!='.'){
                    if(set.contains(board[j][k])){
                        return false;
                    }
                    else{
                        set.add(board[j][k]);
                    }
                }   
                }
            }
        }
        return true;
        
        
    }
}






//another version
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Character> record = new HashSet<Character>();
        for(int i = 0; i < board.length; i++){
            record.clear();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != '.'){
                    if(record.contains(board[i][j])){
                        return false;
                    }else{
                        record.add(board[i][j]);
                    }
                }
            }
        }
        for(int i = 0; i < board[0].length; i++){
            record.clear();
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != '.'){
                    if(record.contains(board[j][i])){
                        return false;
                    }else{
                        record.add(board[j][i]);
                    }
                }
            }
        }
        for(int i = 0; i < 7; i = i + 3){
            for(int j = 0; j < 7; j = j + 3){
                record.clear();
                for(int m = 0; m < 3; m++){
                    for(int n = 0; n < 3; n++){
                        if(board[i + m][j + n] != '.'){
                            if(record.contains(board[i + m][j + n])){
                                return false;
                            }else{
                                record.add(board[i + m][j + n]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}