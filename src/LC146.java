import java.util.ArrayList;

//给定一个字符串，找出最长的不具有重复字符的子串的长度。例如，
// “abcabcbb”不具有重复字符的最长子串是“abc”，长度为3。对于“bbbbb”，
// 最长的不具有重复字符的子串是“b”，长度为1
public class LC146 {
    public static int lengthOfLongestSubstring (String s) {
        ArrayList<Character> result=new ArrayList<>();
        char[] arr=s.toCharArray();
        int count=0;
        if(s==null||s.length()==0){
            return count;
        }
        for(int i=0;i<arr.length;i++){
            if(!result.contains(arr[i])){
                result.add(arr[i]);
                System.out.println(result);
                count=Math.max(count,result.size());
            }
            else{
                int k=result.indexOf(arr[i]);
                for(int j=k;j>=0;j--){
                    System.out.println(result);
                    result.remove(j);
                }
                result.add(arr[i]);
                System.out.println(result);
                count=Math.max(count,result.size());
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
