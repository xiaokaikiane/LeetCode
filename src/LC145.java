import java.util.ArrayList;

//给定两个代表非负数的链表，数字在链表中是反向存储的（链表头结点处的数字是个位数，
// 第二个结点上的数字是十位数...），求这个两个数的和，结果也用链表表示。
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出： 7 -> 0 -> 8
public class LC145 {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
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
    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur=l1;
        int num1=0;
        ArrayList<Integer> list1=new ArrayList<>();
        while(cur!=null){
            list1.add(cur.val);
            cur=cur.next;
        }
        while(!list1.isEmpty()){
            num1+=Math.pow(10,list1.size()-1)*list1.get(list1.size()-1);
            list1.remove(list1.size()-1);
        }
        ListNode cur1=l2;
        int num2=0;
        while(cur1!=null){
            list1.add(cur1.val);
            cur1=cur1.next;
        }
        while(!list1.isEmpty()){
            num2+=Math.pow(10,list1.size()-1)*list1.get(list1.size()-1);
            list1.remove(list1.size()-1);
        }
        int k=num1+num2;
        ListNode pre=new ListNode(0);
        ListNode point=pre;
        while(k>0){
            point.next=new ListNode(k%10);
            point=point.next;
            k=k/10;
        }
        return pre.next;

    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = new ListNode(0);
        ListNode p = head;
        int temp = 0;
        while(l1!=null||l2!=null||temp!=0){
            if(l1!=null){
                temp+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                temp+=l2.val;
                l2=l2.next;
            }
            p.next=new ListNode(temp%10);
            p=p.next;
            temp/=10;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode p1=new ListNode(2);
        ListNode p2=new ListNode(4);
        ListNode p3=new ListNode(3);
        p1.next=p2;
        p2.next=p3;
        ListNode p4=new ListNode(5);
        ListNode p5=new ListNode(6);
        ListNode p6=new ListNode(4);
        p4.next=p5;
        p5.next=p6;
        System.out.println(addTwoNumbers(p1,p4));
    }
}
