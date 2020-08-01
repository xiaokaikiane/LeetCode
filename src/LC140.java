//在不使用额外的内存空间的条件下判断一个整数是否是回文
 //       提示：
 //       负整数可以是回文吗？（比如-1）
 //       如果你在考虑将数字转化为字符串的话，请注意一下不能使用额外空间的限制
 //       你可以将整数翻转。但是，如果你做过题目“Reverse Integer”，你会知道将整数翻转
// 可能会出现溢出的情况，你怎么处理这个问题？
 //       这道题有更具普遍性的解法。
public class LC140 {
    public boolean isPalindrome (int x) {
        if(x<0){
            return false;
        }
        int point=1;
        while(x/point>=10){
            point*=10;
        }
        while(x>0){
            int low=x/point;
            int high=x%10;
            if(low!=high){
                return false;
            }
            x=x%point/10;
            point/=100;
        }
        return true;
    }
}
