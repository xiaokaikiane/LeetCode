package 动归;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] arr=new int[m+1][n+1];
        if(m==0||n==0){
            return 0;
        }
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0){
                    arr[i][j]=0;
                    continue;
                }
                //f(i,j)=f(i-1,j-1)+1;
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }else{//f(i,j)=Math.max(f(i-1,j),f(i,j-1))
                    arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]);
            }
            System.out.print("\n");
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        String s1="bsbininm";
        String s2="jmjkbkjkv";
        System.out.println(longestCommonSubsequence(s1,s2));
    }
}
