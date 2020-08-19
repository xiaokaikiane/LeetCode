import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//打开转盘锁
//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
//
//锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
//
//列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
//
//字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
//
// 
//
//示例 1:
//
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
//示例 2:
//
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
//示例 3:
//
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
//示例 4:
//
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
//提示：
//
//死亡列表 deadends 的长度范围为 [1, 500]。
//目标数字 target 不会在 deadends 之中。
//每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
//
//来源：力扣（LeetCode）
public class OpenTheTurntableLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>();
        for(String s:deadends){//死亡字符串
            set.add(s);
        }
        if (set.contains("0000")){//"0000"作为死亡字符串永远不能到达
            return  -1;
        }
        //标记列表
        Set<String> visit=new HashSet<>();
        visit.add("0000");
        //初始化队列
        Queue<String> q=new LinkedList<>();
        q.add("0000");
        int step=0;//最小的次数
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                String s=q.poll();
                if (s.equals(target)){
                    return step;
                }
                //四位字符可变
                for(int i=0;i<4;i++){
                    //每位字符有两种变换结果
                    char newc1=s.charAt(i);
                    char newc2=s.charAt(i);
                    if(newc1=='9'){
                        newc1='0';
                    }else{
                        newc1++;
                    }
                    if(newc2=='0'){
                        newc2='9';
                    }else{
                        newc2--;
                    }
                    StringBuilder newStr1=new StringBuilder(s);
                    StringBuilder newStr2=new StringBuilder(s);
                    newStr1.setCharAt(i,newc1);
                    newStr2.setCharAt(i,newc2);
                    if(!set.contains(newStr1.toString())&&!visit.contains(newStr1.toString())){
                        q.add(newStr1.toString());
                        visit.add(newStr1.toString());
                    }
                    if(!set.contains(newStr2.toString())&&!visit.contains(newStr2.toString())){
                        q.add(newStr2.toString());
                        visit.add(newStr2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
