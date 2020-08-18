//被围绕的区域
/**
给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

        找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

        示例:

        X X X X
        X O O X
        X X O X
        X O X X
        运行你的函数后，矩阵变为：

        X X X X
        X X X X
        X X X X
        X O X X
        解释:

        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

        来源：力扣（LeetCode）
 */

public class TheAreaThatIsSurrounded {
    public void solve(char[][] board) {
        if (board.length==0){
            return;
        }
        int row=board.length;
        int col=board[0].length;
        //第一行与最后一行
        for(int i=0;i<col;i++){
            if(board[0][i]=='O'){
                func(board,row,col,0,i);
            }
            if(board[row-1][i]=='O'){
                func(board,row,col,row-1,i);
            }
        }
        for(int i=0;i<row;i++){
            if(board[i][0]=='O'){
                func(board,row,col,i,0);
            }
            if (board[i][col-1]=='O'){
                func(board,row,col,i,col-1);
            }
        }
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='*'){
                    board[i][j]='O';
                }
            }
        }
    }
    private int[][] arr={{0,1},{1,0},{0,-1},{-1,0}};
    private void func(char[][] board, int row, int col, int i, int j) {
        board[i][j]='*';
        for(int k=0;k<4;k++){
            int newi=i+arr[k][0];
            int newj=j+arr[k][1];
            if(newi<0||newi>=row||newj<0||newj>=col){
                continue;
            }
            if(board[newi][newj]!='*'&&board[newi][newj]!='X'){
                func(board,row,col,newi,newj);
            }
        }
    }
}
