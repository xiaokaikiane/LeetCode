import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//给出一个仅包含数字的字符串，给出所有可能的字母组合。
//数字到字母的映射方式如下:(就像电话上数字和字母的映射一样)
public class LC131 {
    static ArrayList<String> result=new ArrayList<>();
   static String temp="";
    public static ArrayList<String> letterCombinations (String digits) {
        if (digits==null||digits.length()==0){
            result.add("");
            return result;
        }
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        func(map,0,digits);
        return result;
    }

    private static void func(Map<Character, String> map, int start, String digits) {
        if (start==digits.length()){
            result.add(temp);
            return ;
        }
        String arr=map.get(digits.charAt(start));
        for (int i=0;i<arr.length();i++){
            temp+=arr.charAt(i);
            func(map,start+1,digits);
            temp=temp.substring(0,temp.length()-1);
        }
    }

    public static void main(String[] args) {
        String s="23";
        System.out.println(letterCombinations(s));
    }
}
