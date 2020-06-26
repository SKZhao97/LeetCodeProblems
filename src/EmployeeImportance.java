import java.util.*;

/**
 * 690. Employee Importance
 * https://leetcode.com/problems/employee-importance/
 * June 26th
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return helper(employees, id, map);
    }

    public int helper(List<Employee> employees, int id, Map<Integer, Employee> map) {
        Employee current = map.get(id);
        int res = 0;

        res += current.importance;

        if (current.subordinates.size() == 0) {
            return res;
        }
        for (int subId : current.subordinates) {
            res += helper(employees, subId, map);
        }

        return res;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(3);
        Employee employee1 = new Employee(1,5, list1);
        Employee employee2 = new Employee(2,3, new LinkedList<>());
        Employee employee3 = new Employee(3,3, new LinkedList<>());
        List<Employee> employees = new LinkedList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        EmployeeImportance employeeImportance = new EmployeeImportance();
        System.out.println(employeeImportance.getImportance(employees, 1));
    }
}


// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
};

