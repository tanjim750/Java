public class Soduku {
    public static int validNumber(int[][] board, int row, int col){
        boolean[] valid = new boolean[9];

        // travel by row
        for(int r = 0; r < board[0].length; r++){
            if(board[col][r] != 0)
                valid[board[col][r]-1] = true;
        }

        // travel by column
        for(int c=0; c<board.length; c++){
            if(board[c][row] != 0)
                valid[board[c][row]-1] = true;
        }

        // travel by block 
        int r = (row/3)*3;
        int c = (col/3)*3;
        
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                if(board[c][row] != 0)
                    valid[board[c][row]-1] = true;
            }
        }

        for(int i=0; i<valid.length; i++){
            if(valid[i] == false)
                return i+1;
        }

        return 0;
    }

    public static int[][] solve(int[][] board, int row){
        if(row == board[0].length){
            return board;
        }

        for(int col = 0; col < board.length; col++){
            if(board[col][row] == 0)
                board[col][row] = validNumber(board, row, col);
            solve(board,row+1);
        }
        return board;
    }

    public static void main(String[] args) {
        int[][] board = {{0,6,0,2,0,0,0,9,0},
                         {1,0,0,3,0,6,0,0,0},
                         {0,0,2,0,3,0,0,7,0},
                         {7,0,1,0,9,0,4,0,0},
                         {0,7,0,9,0,0,6,0,3},
                         {2,0,0,5,0,0,8,0,9},
                         {6,0,8,0,0,9,0,5,0},
                         {0,8,0,1,0,0,9,0,0},
                         {0,0,7,0,2,0,0,3,0}};

        int[][] nBoard = {{5,3,0,0,7,0,0,0,0},
                      {6,0,0,1,9,5,0,0,0},
                      {0,9,8,0,0,0,0,6,0},
                      {8,0,0,0,6,0,0,0,3},
                      {4,0,0,8,0,3,0,0,1},
                      {7,0,0,0,2,0,0,0,6},
                      {0,6,0,0,0,0,2,8,0},
                      {0,0,0,4,1,9,0,0,5},
                      {0,0,0,0,8,0,0,7,9}};

        int[][] board_ = solve(nBoard, 0);

        for(int[] l: board_){
            for(int i: l){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
