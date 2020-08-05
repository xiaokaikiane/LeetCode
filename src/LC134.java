import java.util.ArrayList;
import java.util.Arrays;

//给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？
// 找出数组S中所有满足条件的三元组。
//注意：
//三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c）
//解集中不能包含重复的三元组。
public class LC134 {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(num==null||num.length<3){
            return result;
        }
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if (num[i]>0){
                break;
            }
            if(i>0&&num[i]==num[i-1]){
                continue;
            }
            int j=i+1;
            int k=num.length-1;
            while(j<k) {
                if (num[i] + num[j] + num[k] < 0) {
                    while(j<k&&num[j]==num[j+1]){
                        j++;
                    }
                    j++;
                } else if (num[i] + num[j] + num[k] > 0) {
                    while(j<k&&num[k]==num[k-1]){
                        k--;
                    }
                    k--;
                } else if (num[i] + num[j] + num[k] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[j]);
                    list.add(num[k]);
                    result.add(list);
                    while(j<k&&num[j]==num[j+1]){
                        j++;
                    }
                    while(j<k&&num[k]==num[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num={0,-1,-1,3,2,-4,1};
        System.out.println(threeSum(num));
    }
}
