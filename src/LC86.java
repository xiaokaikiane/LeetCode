//给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，
// 请找出路径上的所有数字之和最小的路径。
//注意：你每次只能向下或向右移动。
import java.util.*;


public class LC86 {
    /**
     *
     * @param grid int整型二维数组
     * @return int整型
     */
    public int minPathSum (int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    arr[0][0]=grid[0][0];//初始状态
                    continue;
                }
                if(i==0){
                    //状态递推,当i=0时,当前点的值为新数组左边的值加上旧数组的原始这个点的值
                    arr[i][j]=arr[i][j-1]+grid[i][j];
                    continue;
                }
                if(j==0){
                    //状态递推,当j=0时,当前点的值为新数组上边的值加上旧数组的原始的这个点的值
                    arr[i][j]=arr[i-1][j]+grid[i][j];
                    continue;
                }
                //递归方程:F[i][j]=Math.min(F[i-1][j],F[i][j-1])+grid[i][j];
                arr[i][j]=Math.min(arr[i-1][j],arr[i][j-1])+grid[i][j];
            }
        }
        return arr[m-1][n-1];
    }
}
