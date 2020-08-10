import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//合并k个已排序的链表并将其作为一个已排序的链表返回。分析并描述其复杂度。
public class LC127 {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null){
            return null;
        }
        ArrayList<ListNode> result=new ArrayList<>();
        for(int i=0;i<lists.size();i++){
            ListNode cur=lists.get(i);
            while(cur!=null){
                result.add(cur);
                cur=cur.next;
            }
        }
        Collections.sort(result, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        for (int i=0;i<result.size();i++){
            cur.next=result.get(i);
            cur=cur.next;
        }
        return pre.next;
    }
}
