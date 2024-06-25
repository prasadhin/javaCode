import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectionsProcessor {


    public static void main(String[] args) {
        Employe emp = new Employe("Prasadh","SharedTech",1000,20);
        emp.name();
        List<Employe> employeList = Arrays.asList(
            new Employe("Prasadh","SharedTech",1000,20),
            new Employe("Rajesh","IT",1100,30),
            new Employe("Selva","Computers",1500,20),
            new Employe("Amrish","DB",2000,40),
            new Employe("Prasadh1","Microsoft",5000,25),
            new Employe("Rajesh1","Operations",4100,35),
            new Employe("Selva1","Finance",5500,50),
            new Employe("Amrish2","DB",2000,40),
            new Employe("Prasadh2","Microsoft",3000,25),
            new Employe("Rajesh2","Operations",4100,35),
            new Employe("Selva2","Finance",5500,50)
        );

        //filtered by age
        List<Employe> ageList = employeList.stream().filter(e -> e.age()>=30).toList();
        System.out.println(ageList);

        //grouped by dept
        Map<String, List<Employe>> groupedEmployes = employeList.stream().collect(Collectors.groupingBy(Employe::Dept));
        System.out.println(groupedEmployes);

        //picking a max salaried staff from a department
        Map<String, Employe> topEmployeess = employeList.stream().collect(
            Collectors.groupingBy(Employe::Dept,Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparingInt(Employe::Salary)),empr -> empr.get())));


        Map<String, Employe> topEmployees =
            employeList.stream()
                .collect(Collectors.groupingBy(
                    Employe::Dept,
                    Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employe::Salary)), Optional::get)
                ));
        System.out.println(topEmployees);

        Map<String, Employe> topEmployes =
            employeList.stream()
                .collect(Collectors.toMap(
                    e -> e.Dept(),
                    e -> e,
                    BinaryOperator.maxBy(Comparator.comparingInt(Employe::Salary))
                ));
    }


}
