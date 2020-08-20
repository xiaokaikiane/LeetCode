package 回溯;

import java.util.ArrayList;
import java.util.List;

//N皇后
public class NQueen {
    static class point{
        public int x;
        public int y;
        point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static List<point> list=new ArrayList<>();
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        if(n<4&&n>1){
            return result;
        }
        queenpoint(result,n,0);
        return result;
    }
    private static void queenpoint(List<List<String>> result,int n, int x) {
        if (x==n){
            result.add(func(n));
        }
            for (int i = 0; i < n; i++) {
                if (isvisit(x, i)) {
                    list.add(new point(x,i));
                    queenpoint(result,n,x+1);
                    list.remove(list.size()-1);
                }
            }
    }

    private static List<String> func(int n) {
        List<String> ret=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            StringBuilder sb=new StringBuilder("");
            for(int j=0;j<n;j++){
                if(j==list.get(i).y){
                    sb.append("Q");
                }else {
                    sb.append(".");
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }

    private static boolean isvisit(int x,int y) {
        if (list.isEmpty()){
            return true;
        }
        for(int i=0;i<list.size();i++){
            if(list.get(i).x==x||list.get(i).y==y||
                    list.get(i).x+list.get(i).y==x+y||
            list.get(i).x-list.get(i).y==x-y){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
