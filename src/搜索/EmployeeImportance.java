package 搜索;

import java.util.*;

//员工的重要程度
//给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
//
//比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
//
//现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
//
//示例 1:
//
//输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//输出: 11
//解释:
//员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
//
//来源：力扣（LeetCode）
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

/**
 * 深度优先搜索
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.isEmpty()){
            return 0;
        }
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id,e);
        }
        return func(map,id);
    }

    private int func(Map<Integer,Employee> map, int id) {
        Employee employee=map.get(id);
        int sumimportance=employee.importance;
        for(int ID:employee.subordinates){
            sumimportance+=func(map,ID);
        }
        return sumimportance;
    }

    /**广度优先搜索
     * @param employees
     * @param id
     * @return
     */
    public int getImportance2(List<Employee> employees, int id){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(id);
        Map<Integer,Employee> map=new HashMap<>();
        for(Employee employee:employees){
            map.put(employee.id,employee);
        }
        int sum=0;
        while(!queue.isEmpty()){
            sum+=map.get(queue.peek()).importance;
            int k=queue.poll();
            for(int a:map.get(k).subordinates){
                queue.add(a);
            }
        }
        return sum;
    }
}
