//给出一个字符串s，分割s使得分割出的每一个子串都是回文串
//计算将字符串s分割成回文分割结果的最小切割数
//例如:给定字符串s="aab",
//返回1，因为回文分割结果["aa","b"]是切割一次生成的
public class LC19 {
    public boolean func(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    /**
    方法：动态规划
    状态：
    子状态：到第1,2,3,...,n个字符需要的最小分割数
    F(i): 到第i个字符需要的最小分割数
    状态递推：
    F(i) = min{F(i), 1 + F(j)}, where j<i && j+1到i是回文串
    上式表示如果从j+1到i判断为回文字符串，且已经知道从第1个字符
    到第j个字符的最小切割数，那么只需要再切一次，就可以保证
  1-->j, j+1-->i都为回文串。
    初始化：
    F(i) = i - 1
    上式表示到第i个字符需要的最大分割数
    比如单个字符只需要切0次，因为单子符都为回文串
  2个字符最大需要1次，3个2次......
    返回结果：
    F(n)
    遗留问题：如何判断一段字符串为回文串
    循环判断首尾元素是否相同，如果全部相同，则是回文串
  */
    public int minCut (String s) {
        int length=s.length();
        if(length==0){
            return 0;
        }
        int[] mincut=new int[length+1];
        for(int i=0;i<=length;i++){
            mincut[i]=i-1;
        }
        for(int i=1;i<=length;i++){
            for(int j=0;j<i;j++){
                // F(i) = min{F(i), 1 + F(j)}, where j<i && j+1到i是回文串
                // 从最长串判断，如果从第j+1到i为回文字符串
                // 则再加一次分割，从1到j，j+1到i的字符就全部分成了回文字符串
                if(func(s,j,i-1)){
                    mincut[i]=Math.min(mincut[i],mincut[j]+1);
                }
            }
        }
        return mincut[length];
    }
}
