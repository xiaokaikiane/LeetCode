package 搜索;

import java.util.LinkedList;
import java.util.Queue;

//腐烂的橘子
//在给定的网格中，每个单元格可以有以下三个值之一：
//
//值 0 代表空单元格；
//值 1 代表新鲜橘子；
//值 2 代表腐烂的橘子。
//每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
//
//返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
//
// 
//
//来源：力扣（LeetCode）
public class RottenOrange {
    class Orange{
        public int x;
        public int y;

        public Orange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<Orange> queue=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    queue.add(new Orange(i,j));
                }
            }
        }
        //可以走的方向
        int[][] arr={{0,1},{1,0},{0,-1},{-1,0}};
        int step=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean flag=false;
            while(size-->0){
                Orange orange=queue.peek();
                queue.poll();
                for(int k=0;k<4;k++){
                    int newx=orange.x+arr[k][0];
                    int newy=orange.y+arr[k][1];
                    //越界,没有橘子,橘子已经腐烂就跳过
                    if(newx<0||newx>=row||newy<0||newy>=col||
                            grid[newx][newy]!=1){
                        continue;
                    }
                    flag=true;//表示
                    grid[newx][newy]=2;
                    queue.add(new Orange(newx,newy));
                }
            }
            if (flag){
                step++;
            }
        }
        for(int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return step;
    }
}
