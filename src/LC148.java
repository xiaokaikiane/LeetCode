import java.util.Arrays;
import java.util.HashMap;

//给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
//你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），
// 需要满足 index1 小于index2.。注意：下标是从1开始的
//假设给出的数组中只存在唯一解
//例如：
//给出的数组为 {2, 7, 11, 15},目标值为9
//输出 ndex1=1, index2=2
public class LC148 {

    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        int[] result = new int[2];
        //map里面放 键为target-每个数的结果 值为下标
        // 每次放入的时候看是否包含 当前值
        // 有的话说明当前值和已包含的值下标的那个元素为需要的结果
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<n; i++){
            if(map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i])+1;
                result[1] = i+1;
                break;
            }
            else{
                map.put(target - numbers[i], i);
            }
        }
        return result;
    }
    public static int[] twoSum (int[] numbers, int target) {
        int[] arr=new int[2];
        if(numbers==null||numbers.length<2){
            return null;
        }
        int a1=0;
        int a2=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]<=target){
                a1=numbers[i];
                System.out.println(i);
                arr[0]=i+1;
            }else{
                continue;
            }
            if(i==numbers.length-1){
                return null;
            }
            for(int j=i+1;j<numbers.length;j++){
                a2=numbers[j];
                if(a1+a2==target){
                    arr[1]=j+1;
                    break;
                }
            }
            if(a1+a2==target){
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={3,2,4};
        System.out.println(Arrays.toString(twoSum(arr,6)));
    }
}
