package introToOops.hashCodeAndEqals;

import java.util.Map;

public class HashMapCheck {
    public static void main(String[] args){
        Map<Employee, String> employeeMap = new java.util.HashMap<>();
        employeeMap.put(new Employee(1, "John"), "Developer");
        employeeMap.put(new Employee(1, "John"), "Manager");
        System.out.println("Size of employee map: " + employeeMap.size());
        System.out.println(employeeMap);
    }
}
