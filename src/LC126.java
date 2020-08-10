//将给定的链表中每两个相邻的节点交换一次，返回链表的头指针
//例如,
//给出1->2->3->4，你应该返回链表2->1->4->3。
//你给出的算法只能使用常量级的空间。你不能修改列表中的值，只能修改节点本身。
public class LC126 {
    public ListNode swapPairs (ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode pre=new ListNode(0);
        ListNode cur=pre;
        ListNode p=head;
        while(p!=null&&p.next!=null){
            cur.next=p.next;
            p.next=cur.next.next;
            cur.next.next=p;
            cur=p;
            p=p.next;
        }
        return pre.next;
    }
}
