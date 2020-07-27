//找出给出的字符串S中最长的回文子串。假设S的最大长度为1000，并且只存在唯一解
public class LC144 {
    public String longestPalindrome (String s) {
        if(s==null||s.length()<2){
            return s;
        }
        int MaxLength=0;
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int k=0;
            while(k<2){
                int left=i;
                int right=i+k;

                while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }
                left++;
                if(MaxLength<right-left){
                    MaxLength=right-left;
                    start=left;
                    end=right;
                }
                k++;
            }
        }
        return s.substring(start,end);
    }
}
