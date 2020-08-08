//给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
import java.util.*;


class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val){
      this.val=val;
  }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


public class LC130 {
    /**
     *
     * @param head ListNode类 
     * @param n int整型 
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd (ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        int length=1;
        while(cur.next!=null){
            length++;
            cur=cur.next;
        }
        if(n<1||n>length){
            return head;
        }
        ListNode cur1=head;
        ListNode pre=cur1;

        if(n==length){
            return cur1.next;
        }
        for(int i=0;i<length-n-1;i++){
            cur1=cur1.next;
        }
        cur1.next=cur1.next.next;
        return pre;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(0);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        System.out.println(removeNthFromEnd(n1,1));
    }
}