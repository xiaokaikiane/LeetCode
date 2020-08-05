//编写一个函数来查找字符串数组中的最长公共前缀。
//Write a function to find the longest
// common prefix string amongst an array of strings.
public class LC135 {
    public String longestCommonPrefix (String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        //先找最短的字符串
        String min=strs[0];
        for(int i=1;i<strs.length;i++){
            if(min.length()>strs[i].length()){
                min=strs[i];
            }
        }
        for(int i=0;i<min.length();i++){
            for(int j=0;j<strs.length;j++){
                if(min.charAt(i)!=(strs[j].charAt(i))){
                    return min.substring(0,i);
                }
            }
        }
        return min;
    }
}
