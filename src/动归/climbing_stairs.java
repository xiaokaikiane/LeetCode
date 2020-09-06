package 动归;
//LC79
//你在爬楼梯，需要n步才能爬到楼梯顶部
  // 每次你只能向上爬1步或者2步。有多少种方法可以爬到楼梯顶部？
public class climbing_stairs {
    public int climbStairs (int n) {
        int[] arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
