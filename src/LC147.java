import java.util.Comparator;
import java.util.PriorityQueue;

//有两个大小分别为m和n的有序数组A和B。请找出这两个数组的中位数。
// 你需要给出时间复杂度在O(log (m+n))以内的算法。
public class LC147 {
    public double findMedianSortedArrays (int[] A, int[] B) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(20, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int k=0;
        if (A.length>0) {
            for (int i = 0; i < A.length; i++) {
                if (k % 2 == 0) {
                    maxHeap.add(A[i]);
                    minHeap.add(maxHeap.poll());
                    k++;
                }
                if (k % 2 != 0) {
                    minHeap.add(A[i]);
                    maxHeap.add(minHeap.poll());
                    k++;
                }
            }
        }
        if (B.length>0){
            for (int j=0;j<B.length;j++){
                if (k%2==0){
                    maxHeap.add(B[j]);
                    minHeap.add(maxHeap.poll());
                    k++;
                }
                if (k%2!=0){
                    minHeap.add(B[j]);
                    maxHeap.add(minHeap.poll());
                    k++;
                }
            }
        }
        double a=0;
        if (k%2==0){
            a=(minHeap.peek()+maxHeap.peek())/2.0;
        }else {
            a=minHeap.peek()/2.0;
        }
        return a;
    }
}
