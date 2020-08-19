package 搜索;

import java.util.LinkedList;
import java.util.Queue;

//迷宫问题
//
public class MazeProblem {
    class Node{
        public int x;
        public int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public boolean Bfs(int[][] map,int startx,int starty,int endx,int endy){
        //迷宫大小
        int row=map.length;
        int col=map[0].length;
        //标记矩阵
        int[][] book=new int[row][col];
        book[startx][starty]=1;//已经走过
        //存储迷宫中的位置
        Queue<Node> queue=new LinkedList<>();
        queue.add(new Node(startx,starty));
        //四个行走的方向
        int[][] arr={{0,1},{1,0},{0,-1},{-1,0}};

        boolean flag=false;
        while(!queue.isEmpty()){
            for(int k=0;k<4;k++){
                int newx=queue.peek().x+arr[k][0];
                int newy=queue.peek().y+arr[k][1];
                if(newx<0||newx>=row||newy<0||newy>=col){
                    continue;
                }
                if(map[newx][newy]==0&&book[newx][newy]==0){
                    queue.add(new Node(newx,newy));
                    book[newx][newy]=1;
                }
                if(newx==endx&&newy==endy){
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }
            queue.poll();
        }
        return flag;
    }
}
