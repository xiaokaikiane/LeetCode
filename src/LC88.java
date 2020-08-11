import java.util.ArrayList;

//一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置）。
//机器人每次向下或向右移动。机器人要到达地图的右下角。（终点，下图中的标记“Finish"的位置）。
//可以有多少种不同的路径从起点走到终点？
public class LC88 {
    public int uniquePaths(int m, int n) {
        int[] count = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0)
                    count[j] = 1;
                else
                    count[j] = count[j - 1] + count[j];
            }
        }
        return count[m - 1];
    }
    public int uniquePaths2(int m, int n) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        //初始化,行和列为0 的都只有一条路出来, F(0,i) = 1,F(i,0) = 1
        for(int i=0;i<m;i++){
            list.add(new ArrayList<>());
            list.get(i).add(1);
        }
        for(int i=0;i<n;i++){
            list.get(0).add(1);
        }
        //F(i,j)=F(i,j-1)+F(i-1,j);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                list.get(i).add(list.get(i-1).get(j)+list.get(i).get(j-1));
            }
        }
        return list.get(m-1).get(n-1);
    }
}
