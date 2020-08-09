import java.util.ArrayList;

//给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
//例如，给出n=3，解集为：
//"((()))", "(()())", "(())()", "()(())", "()()()"
public class LC128 {
    public static ArrayList<String> generateParenthesis (int n) {
        ArrayList<String> result=new ArrayList<>();
        if(n==0){
            return result;
        }
        func(result,"",0,0,n);
        return result;
    }
    static void func(ArrayList<String> result, String s, int left, int right, int n){
        if(right==n){
            result.add(s);
            return;
        }
        //保证括号组数不大于n
        if(left<n){
            func(result,s+"(",left+1,right,n);
        }
        //保证左括号的数量大于等于右括号的数量
        if(left>right){
            func(result,s+")",left,right+1,n);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
