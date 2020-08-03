//'.' 可以匹配任何单个字符。↵'*' 可以匹配任何字符序列（包括空序列）。
// ↵↵匹配应该覆盖整个输入字符串（而不是部分）。 ↵函数声明为：↵bool isMatch
// (const char *s, const char *p)↵↵下面给出一些样例：↵isMatch("aa","a")
// → false↵isMatch("aa","aa") → true↵isMatch("aaa","aa") → false↵isMatch
// ("aa", "a*") → true↵isMatch("aa", ".*") → true↵isMatch("ab", ".*") →
// true↵isMatch("aab", "c*a*b") → true
public class LC139 {
    public boolean isMatch(String s, String p) {
        if(s==null||p==null){
            return false;
        }
        return Match(s,0,p,0);
    }
    private boolean Match(String s,int i,String p,int j){
        if(j==p.length()){
            return i==s.length();
        }
        if(j<p.length()-1&&p.charAt(j+1)=='*'){
            if(i!=s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
                return Match(s,i,p,j+2)||Match(s,i+1,p,j);
            }else{
                return Match(s,i,p,j+2);
            }
        }
        if(s.length()!=i&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
            return Match(s,i+1,p,j+1);
        }
        return false;
    }
}
