//实现函数 atoi 。函数的功能为将字符串转化为整数
//提示：仔细思考所有可能的输入情况。这个问题故意描述的很模糊
// （没有给出输入的限制），你需要自己考虑所有可能的情况。
public class LC141 {
    public static int atoi (String str) {
        if(str==null||str.trim().length()<1){
            return 0;
        }
        char[] arr=str.trim().toCharArray();
        System.out.println(arr.length);
        int index=0;int flag=1;
        if(arr[0]=='+'){
            index++;
        }
        if(arr[0]=='-'){
            flag=-1;
            index++;
        }
        int num=0;
        for(int i=index;i<arr.length;i++){
            if(arr[i]>='0'&&arr[i]<='9'){
                if(num>Integer.MAX_VALUE/10||num==Integer.MAX_VALUE&&arr[i]>'7'){
                    if(flag>0){
                        return Integer.MAX_VALUE;
                    }else{
                        return Integer.MIN_VALUE;
                    }
                }
                num=num*10+arr[i]-'0';
            }else{
                break;//字母或其他符号
            }
        }
        return num*flag;
    }

    public static void main(String[] args) {
        String s="  11333713950";
        System.out.println(atoi(s));
    }
}
