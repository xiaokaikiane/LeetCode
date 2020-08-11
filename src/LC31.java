import java.util.ArrayList;

//
//给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
//例如，给出的三角形如下：
//[↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
//最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
public class LC31 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle==null){
            return 0;
        }
        ArrayList<ArrayList<Integer>> list=new  ArrayList<>();
        for(int i=0;i<triangle.size();i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(triangle.get(0).get(0));
        int row=triangle.size();
        for(int i=1;i<row;i++){
            int min=0;
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    min=list.get(i-1).get(0);
                }else if(j==i){
                    min=list.get(i-1).get(j-1);
                }else{
                    min=Math.min(list.get(i-1).get(j-1),list.get(i-1).get(j));
                }
                list.get(i).add(min+triangle.get(i).get(j));
            }
        }
        int size=list.size();
        int minValue=list.get(size-1).get(0);
        for(int i=1;i<list.get(size-1).size();i++){
            minValue=Math.min(list.get(size-1).get(i),minValue);
        }
        return minValue;
    }
}
