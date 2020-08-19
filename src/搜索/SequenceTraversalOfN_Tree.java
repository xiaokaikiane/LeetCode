package 搜索;//N叉树的层序遍历
//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
//例如，给定一个 3叉树 :

//返回其层序遍历:
//
//[
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//来源：力扣（LeetCode）
public class SequenceTraversalOfN_Tree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>  result=new ArrayList<>();
          if(root==null){
            return result;
        }
        Queue<Node> queue1=new LinkedList<>();
          queue1.add(root);
          Queue<Node> queue2=new LinkedList<>();
          int index=1;
          while(!queue1.isEmpty()||!queue2.isEmpty()){
              if(index%2==1){
                  List<Integer> temp=new ArrayList<>();
                  while(!queue1.isEmpty()){
                      Node node=queue1.poll();
                      if(node!=null){
                          temp.add(node.val);
                         for (Node n:node.children){
                             queue2.add(n);
                         }
                      }
                  }
                  if (!temp.isEmpty()){
                      result.add(temp);
                      index++;
                  }
              }
              if(index%2==0){
                  List<Integer> temp=new ArrayList<>();
                  while(!queue2.isEmpty()){
                      Node node=queue2.poll();
                      if(node!=null){
                          temp.add(node.val);
                          for(Node n:node.children){
                              queue1.add(n);
                          }
                      }
                  }
                  if (!temp.isEmpty()){
                      result.add(temp);
                      index++;
                  }
              }
        }
        return  result;
    }
}
