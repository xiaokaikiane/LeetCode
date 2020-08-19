package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//示例:
//
//输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
//
//来源：力扣（LeetCode）
public class CombinationsOfPhoneNumbers {
     List<String> result=new ArrayList<>();
     String temp="";
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
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

    private void func(Map<Character, String> map, int start, String digits) {
        if(start==digits.length()){
            result.add(temp);
            return;
        }
        String s=map.get(digits.charAt(start));
        for(int i=0;i<s.length();i++){
            temp+=s.charAt(i);
            func(map,start+1,digits);
            temp=temp.substring(0,temp.length()-1);
        }
    }
}
