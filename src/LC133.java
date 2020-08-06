import java.util.Arrays;

//给出含有n个整数的数组s，找出s中和加起来的和最接近给定的目标值的三个整数。
// 返回这三个整数的和。你可以假设每个输入都只有唯一解
public class LC133 {
    public int threeSumClosest (int[] num, int target) {
        if(num==null||num.length<3){
            return 0;
        }
        Arrays.sort(num);
        int flag=Integer.MAX_VALUE;
        int result=0;
        for(int i=0;i<num.length-2;i++){
            int left=i+1;
            int right=num.length-1;
            while(left<right){
                int sum=target-num[i]-num[left]-num[right];
                if(Math.abs(sum)<flag){
                    flag=Math.abs(sum);
                    result=num[i]+num[left]+num[right];
                }
                if(result<target){
                    left++;
                }else if(result>target){
                    right--;
                }else{
                    return result;
                }
            }
        }
        return result;
    }
}
