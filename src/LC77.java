//给定两个单词word1和word2，请计算将word1转换为word2至少需要多少步操作。
//你可以对一个单词执行以下3种操作：
//a）在单词中插入一个字符
//b）删除单词中的一个字符
//c）替换单词中的一个字符
public class LC77 {

    public int minDistance (String word1, String word2) {
        int size1=word1.length();
        int size2=word2.length();
        if(size1==0||size2==0){//F(i,0)=i  F(0,j)=j;初始值
            return Math.max(size1,size2);
        }
        int[][] result=new int[size1+1][size2+1];
        for(int i=0;i<=size1;i++){
            for(int j=0;j<=size2;j++){
                if(i==0&&j==0){
                    result[i][j]=0;
                    continue;
                }
                if(i==0){
                    result[i][j]=j;
                    continue;
                }
                if(j==0){
                    result[i][j]=i;
                    continue;
                }
                //递推方程
                //F[i][j]=Math.min(F[i-1][j]+1,F[i][j-1]+1,F[i-1][j-1]+word1[i]=word2[j]?0:1)
                //可分解为下面两个步骤
                result[i][j]=Math.min(result[i][j-1],result[i-1][j])+1;
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    result[i][j]=Math.min(result[i][j],result[i-1][j-1]);
                }else{
                    result[i][j]=Math.min(result[i][j],result[i-1][j-1]+1);
                }
            }
        }
        return result[size1][size2];
    }
}
