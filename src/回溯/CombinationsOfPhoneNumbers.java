package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的组合
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
