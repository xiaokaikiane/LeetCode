package 搜索;

import java.util.*;

//单词接龙
//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
//
//每次转换只能改变一个字母。
//转换过程中的中间单词必须是字典中的单词。
//说明:
//
//如果不存在这样的转换序列，返回 0。
//所有单词具有相同的长度。
//所有单词只由小写字母组成。
//字典中不存在重复的单词。
//你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//示例 1:
//
//输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
//示例 2:
//
//输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。
//
//来源：力扣（LeetCode）
public class Randomly {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.isEmpty()){
            return 0;
        }
        Set<String> set=new HashSet<>();
        //将单词放在set集合中,方便
        for(String a:wordList){
            set.add(a);
        }
        //记录单词的访问结果
        Set<String> visit=new HashSet<>();
        visit.add(beginWord);
        //初始化队列
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int count=1;//记录次数
        while(!queue.isEmpty()){
            int size= queue.size();
            while(size-->0){
                String s=queue.poll();
                //单词的每个位置
                for (int i=0;i<s.length();i++){
                    StringBuilder stringBuilder=new StringBuilder(s);
                    //每个位置分别用26个字母替换
                    for (char a='a';a<='z';a++){
                        stringBuilder.setCharAt(i,a);
                        String newword=stringBuilder.toString();
                        if(!set.contains(newword)||visit.contains(newword)){
                            continue;
                        }
                        //转换成功
                        if(newword.equals(endWord)){
                            return count+1;
                        }
                        //如果没有转换成功
                        visit.add(newword);
                        queue.add(newword);
                    }
                }
            }
            count++;//循环一次代表没有转化成功并进行下一次循环
        }
        return 0;//转换不成功
    }
}
