package 搜索;

//岛屿数量
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
//
// 
//
//示例 1:
//
//输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
//示例 2:
//
//输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成
//
//来源：力扣（LeetCode）
public class TheNumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        int[][] book=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&book[i][j]==0) {
                    count++;
                    func(grid, book, row, col, i, j);
                }
            }
        }
        return count;
    }
    private int[][] arr={{0,1},{1,0},{0,-1},{-1,0}};
    private void func(char[][] grid, int[][] book, int row, int col, int i, int j) {
        book[i][j]=1;
        for (int k=0;k<4;k++){
            int newi=i+arr[k][0];
            int newj=j+arr[k][1];
            if(newi<0||newi>=row||newj<0||newj>=col){
                continue;
            }
            if(grid[newi][newj]=='1'&&book[newi][newj]==0){
                func(grid, book, row, col, newi, newj);
            }
        }
    }
}
