//请将给出的整数转化为罗马数字
//保证输入数字的范围在1 到 3999之间。
public class LC137 {
    public String intToRoman (int num) {
        String[] th={"M","MM","MMM",};
        String[] hun={"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ten={"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] one={"I","II","III","IV","V","VI","VII","VIII","IX"};
        String s="";
        if(num>=1000){
            s=s+th[num/1000-1];
            num=num%1000;
        }
        if(num>=100){
            s=s+hun[num/100-1];
            num=num%100;
        }
        if(num>=10){
            s=s+ten[num/10-1];
            num=num%10;
        }
        if(num>=1){
            s=s+one[num-1];
        }
        return s;
    }
}
