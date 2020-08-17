//给定两个字符串S和T，返回S子序列等于T的不同子序列个数有多少个？
//字符串的子序列是由原来的字符串删除一些字符（也可以不删除）
// 在不改变相对位置的情况下的剩余字符（例如，"ACE"is a subsequence of"ABCDE"但是"AEC"不是）
//例如：
//S ="rabbbit", T ="rabbit"
//返回3
public class LC36 {
    public int numDistinct (String S, String T) {
        int length1=S.length();
        int length2=T.length();
        if(length1==0){
            return 0;
        }
        if(length2==0){
            return 1;
        }
        int[][] arr=new int[length1+1][length2+1];
        for(int i=0;i<=length1;i++){
            for(int j=0;j<=length2;j++){
                //初始化
                if(i==0&&j==0){
                    arr[i][j]=1;
                    continue;
                }
                if(i==0){
                    arr[i][j]=0;
                    continue;
                }
                if(j==0){
                    arr[i][j]=1;
                    continue;
                }
                //状态方程:
                //当当前字符相等时,F[i][j]=F[i-1][j-1]+F[i-1][j];
                if(S.charAt(i-1)==T.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
                }else{//当当前字符不等时,F[i][j]=F[i-1][j];
                    arr[i][j]=arr[i-1][j];
                }
            }
        }
        return arr[length1][length2];
    }
}
