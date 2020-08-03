//给定 n 非负整数1 ，a 2 ，...，，一个n ，其中每个表示坐标处的点
// （i，i ）。绘制的垂直线使行 i 的两个端点位于 （i， ai）和 （i， 0） 。
// 查找两条线，它们与 x 轴一起形成一个容器，使容器包含最多的水。
//注意：您不能倾斜容器。
public class LC138 {
    public int maxArea (int[] height) {
        if(height.length<2){
            return 0;
        }
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            max=Math.max((Math.min(height[left],height[right])*(right-left)),max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
