package 回溯;

import java.util.ArrayList;
import java.util.List;

//组合总和
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。 
//示例 1：
//
//输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//示例 2：
//
//输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
//
//提示：
//
//1 <= candidates.length <= 30
//1 <= candidates[i] <= 200
//candidate 中的每个元素都是独一无二的。
//1 <= target <= 500
//
//来源：力扣（LeetCode）
public class CombinedTotal {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(candidates==null||candidates.length==0){
            return result;
        }
        int sum=0;
        List<Integer> list=new ArrayList<>();
        func(result,list,candidates,target,0,sum);
        return result;
    }

    private void func(List<List<Integer>> result, List<Integer> list,
                      int[] candidates, int target,int flag,int sum) {
        if(sum==target){
            List<Integer> n=new ArrayList<>();
            for (int e:list){
                n.add(e);
            }
            result.add(n);
        }else if(sum>target){
            return;
        }
        for(int i=flag;i<candidates.length;i++){
            if(candidates[i]>target){
                continue;
            }
            list.add(candidates[i]);
            sum+=candidates[i];
            func(result,list,candidates,target,i,sum);
            list.remove(list.size()-1);
            sum-=candidates[i];
        }
    }
}
