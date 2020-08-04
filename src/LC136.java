//请将给出的罗马数字转化为整数
//保证输入的数字范围在1 到 3999之间。
import java.util.HashMap;
import java.util.Map;

public class LC136 {
    public int romanToInt (String s) {
        Map<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int num=0;
        int temp=0;
        for(int i=s.length()-1;i>=0;i--){
            int nowValue=map.get(s.charAt(i));
            if(nowValue>=temp){
                num=num+nowValue;
            }else{
                num=num-nowValue;
            }
            temp=nowValue;
        }
        return num;
    }
}
