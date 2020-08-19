package 动归;

/*
状态：
 F(i, j): 前i个物品放入大小为j的背包中所获得的最大价值
状态递推：对于第i个商品，有一种例外，装不下，两种选择，放或者不放
 如果装不下：此时的价值与前i-1个的价值是一样的
 F(i,j) = F(i-1,j)
 如果可以装入：需要在两种选择中找最大的
 F(i, j) = max{F(i-1,j), F(i-1, j - A[i]) + V[i]}
 F(i-1,j): 表示不把第i个物品放入背包中， 所以它的价值就是前i-1个物品放入大小为j的背包的最大价值
 F(i-1, j - A[i]) + V[i]：表示把第i个物品放入背包中，价值增加V[i],但是需要腾出j - A[i]的大小放
第i个商品
初始化：第0行和第0列都为0，表示没有装物品时的价值都为0
 F(0,j) = F(i,0) = 0
返回值：F(n,m)
*/
public class backpack {//背包问题
    public static int pack(int m,int[] A,int[] V){//m背包的大小,A为物品大小的数组,V为物品的价值
        int n=A.length;
        int arr[][]=new int[n+1][m+1];
        if(m==0||n==0){
            return 0;
        }
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                    continue;//初始化
                }
                if (A[i - 1] > j) {//如果装不下
                    arr[i][j] = arr[i - 1][j];
                } else {
                    //如果能装下
                    //1.可以不装 价值为上一个的状态arr[i-1][j];
                    //2.装下它的价值为多少,arr[i-1][j-A[i-1]]+v[i-1];
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return arr[n][m];
    }
}
