//如果在图中加入了一些障碍，有多少不同的路径？
//分别用0和1代表空区域和障碍
//例如
//下图表示有一个障碍在3*3的图中央。
//[
//    [0,0,0],
//    [0,1,0],
//    [0,0,0]
//]
//有2条不同的路径
public class LC87 {
    public int uniquePathsWithObstacles (int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    arr[i][j]=0;
                    continue;
                }
                if(i==0&&j==0){
                    arr[i][j]=1;
                    continue;
                }
                if(i==0){
                    arr[i][j]=arr[i][j-1];
                    continue;
                }
                if(j==0){
                    arr[i][j]=arr[i-1][j];
                    continue;
                }
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
