import java.util.ArrayList;
import java.util.Arrays;

//给出一个有n个元素的数组S，S中是否有元素a,b,c和d满足a+b+c+d=目标值？
// 找出数组S中所有满足条件的四元组。
//注意：
//四元组（a、b、c、d）中的元素必须按非降序排列。（即a≤b≤c≤d）
//解集中不能包含重复的四元组。
public class LC132 {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(num==null||num.length<4){
            return result;
        }
        Arrays.sort(num);
        for(int i=0;i<num.length-3;i++){
            if(i>0&&num[i]==num[i-1]){
                continue;
            }
            int other=i+1;
            int flag=i+1;
            for(;other<num.length-2;other++){
                if(other>flag&&num[other]==num[other-1]){
                    continue;
                }
                int left=other+1;
                int right=num.length-1;
                while(left<right){
                    if(num[i]+num[other]+num[left]+num[right]<target){
                        while(left<right&&num[left]==num[left+1]){
                            left++;
                        }
                        left++;
                    }else if(num[i]+num[other]+num[left]+num[right]>target){
                        while(left<right&&num[right]==num[right-1]){
                            right--;
                        }
                        right--;
                    }else if(num[i]+num[other]+num[left]+num[right]==target){
                        ArrayList<Integer> list=new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[other]);
                        list.add(num[left]);
                        list.add(num[right]);
                        result.add(list);
                        while(left<right&&num[left]==num[left+1]){
                            left++;
                        }
                        while(left<right&&num[right]==num[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num={1,-2,-5,-4,-3,3,3,5};
        System.out.println(fourSum(num,-11));
    }
}
