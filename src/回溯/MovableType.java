package 回溯;

import java.util.HashSet;
import java.util.Set;

//活字印刷
//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
//
//注意：本题中，每个活字字模只能使用一次。
//
// 
//
//示例 1：
//
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
//示例 2：
//
//输入："AAABBC"
//输出：188
// 
//
//提示：
//
//1 <= tiles.length <= 7
//tiles 由大写英文字母组成
//
//来源：力扣（LeetCode）
public class MovableType {
    static Set<String> result=new HashSet<>();
    static StringBuilder sb=new StringBuilder("");
    public static int numTilePossibilities(String tiles) {
        if(tiles.length()==0||tiles==null){
            return 0;
        }
        int[] arr=new int[tiles.length()];
        System.out.println(result);
        func(result,tiles,arr);
        System.out.println(result);
        return result.size();
    }

    private static void func(Set<String> result, String tiles,int[] arr) {
        if(sb.length()!=0) {
            result.add(sb.toString());
        }

        for(int i=0;i<tiles.length();i++){
            if(arr[i]==1){
                continue;
            }
            sb.append(tiles.charAt(i));
            arr[i]=1;
            func(result,tiles,arr);
            arr[i]=0;
            sb=sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String s="AAABBC";
        System.out.println(numTilePossibilities(s));
    }
}
