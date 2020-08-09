import java.util.Stack;

//给出一个仅包含字符'(',')','{','}','['和']',的字符串，
// 判断给出的字符串是否是合法的括号序列
//括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法
public class LC129 {
    public boolean isValid (String s) {
        if(s==null||s.length()<2){
            return false;
        }
        Stack<Character> stack=new Stack<>();
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='('){
                stack.push(')');
            }else if(arr[i]=='{'){
                stack.push('}');
            }else if(arr[i]=='['){
                stack.push(']');
            }else if(stack.isEmpty()||arr[i]!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
