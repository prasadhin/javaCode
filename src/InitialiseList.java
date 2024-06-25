import java.util.*;
import java.util.stream.Stream;

public class InitialiseList {

    static List<Employee> getEmployees(){
/*        stream.of(List1, List2)
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.asList(numbers);
        Arrays.asList(1,2,3);
        IntStream.closed(1,5);
        List<Integer> list1 = Stream.of(1, 3, 4, 6, 7, 9, 19).collect(Collectors.toList());
        List<Integer> list2 = Stream.of(11, 3, 43, 6, 7, 19).collect(Collectors.toList());*/


        List<Employee> employees =  Arrays.asList(
            new Employee("Prasadh","IT",7000.00,43),
            new Employee("Rajesh","Ops",4000.00,30),
            new Employee("Selva","Computers",1500.01,20),
            new Employee("Amrish","DB",2000.03,40),
            new Employee("Prasadh1","Microsoft",5000.45,25),
            new Employee("Rajesh1","Operations",4100.36,35),
            new Employee("Selva1","Finance",5500.15,50),
            new Employee("Amrish2","DB",2000.21,40),
            new Employee("Prasadh2","Microsoft",3000.06,25),
            new Employee("Rajesh2","Operations",4100.26,35),
            new Employee("Selva2","Aps",5500.05,50)
        );
        return employees;
    }

/*    static <E> List<E> sortedEmployeesSalary(List<E> e){
        List<E> emps = e.stream().sorted().toList();
        return emps;
    }*/

    static List<Employee> sortedEmployeesSal(){
        //return sortedEmployeesSalary(getEmployees());
        return getEmployees().stream().sorted(Comparator
            .comparing(Employee::Salary)
            .reversed()
            .thenComparing(Employee::Dept)
            .thenComparing(Employee::name))
            .toList();
    }

    static List<Employee> merge2List(){
        List<Employee> list = Stream.of(getEmployees(), getEmployees())
            .flatMap(Collection::stream)
            .toList();
   return list;
    }

    //get nth highest salary from List
    static Employee getNthSalaryEmployee(Integer n){
        List<Employee> list = merge2List();
        System.out.println(list);
        return getEmployees().get(n);
    }

    public static void main(String[] args) {
        System.out.println(sortedEmployeesSal());
        System.out.println(getNthSalaryEmployee(4));
    }

    record Employee(String name, String Dept, Double Salary, Integer age) {}
}
