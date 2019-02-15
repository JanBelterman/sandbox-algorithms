package Cloning;

import java.util.LinkedList;
import java.util.List;

public class Cloning {

    public static void run() {
        System.out.println("Cloning\n");

        // Creating objects
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Employee1", 1000));
        employees.add(new Employee("Employee2", 2000));
        employees.add(new Employee("Employee3", 3000));

        // Cloning
        LinkedList<Employee> shallowCopy = (LinkedList<Employee>) employees.clone();
        LinkedList<Employee> shallowCopyConstructor = new LinkedList<>(employees);
        LinkedList<Employee> deepCopy = deepCopy(employees);

        // Change employee 1
        employees.get(0).name = "New name";
        employees.get(0).salary = 9999;
        // Original
        System.out.println("Original, so name changed");
        System.out.println(employees.get(0));
        // Shallow copy
        System.out.println("Clone(), copies reference so name changed");
        System.out.println(shallowCopy.get(0));
        // Shallow copy constr
        System.out.println("Copy contr, copies reference so name changed");
        System.out.println(shallowCopyConstructor.get(0));
        // Deep copy
        System.out.println("Deep copy, copies down to primitives so name didn't change");
        System.out.println(deepCopy.get(0));
    }

    // Deep copy helper
    private static LinkedList<Employee> deepCopy(List<Employee> original) {
        LinkedList<Employee> deepCopy = new LinkedList<>();
        for(Employee e : original) {
            deepCopy.add(new Employee(e.name, e.salary));
        }
        return deepCopy;
    }
}


class Employee {

    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + salary;
    }

}