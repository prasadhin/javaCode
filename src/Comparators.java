import java.util.*;
import java.util.stream.Collectors;

public class Comparators {

    public static List<Employee> getEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee("Prasadh", 123, "IT"),
                new Employee("Jamy", 124, "Tech"),
                new Employee("Trevor", 423, "Product"),
                new Employee("Trevor", 423, "Data"),
                new Employee("Smy", 126, "Tech")
        );
        return employees;
    }

    public static void main(String[] args) {
        Comparator<Employee> nameascending = (e1, e2) -> e1.getName().compareTo(e2.getName());
        List<Employee> emp = getEmployees();

        //sort the data in source
        Collections.sort(emp,nameascending);
        emp.forEach(System.out::println);

        //sort the data in source and collect in new list
        List<Employee> newemp = emp.stream().sorted(nameascending).toList();

        //reverse sorting
        emp.stream().sorted(Comparator.comparing(Employee::getName).reversed()).toList();

        //sorting by multile fields
        Collections.sort(emp,Comparator.comparing(Employee::getName).thenComparing(Employee::getDept));
        emp.forEach(System.out::println);


        emp.stream().sorted(Comparator.comparing(Employee::getName).reversed().thenComparing(Employee::getDept)).toList();
        var e1 = emp.stream().min(Comparator.comparing(Employee::getEmpid)).orElse(new Employee("dPrasadh", 123, "IT"));
        System.out.println("e1="+e1);
        //emp.forEach(System.out::println);

        //group by dept and print their employees
        Map<String, List<Employee>> result = emp.stream().collect(Collectors.groupingBy(Employee::getDept));
        result.forEach((key, value) -> System.out.println(key + value));

        //group by field and count
        List<BlogPost> posts = getBlogPosts();
        Map<String, Integer> likesCount = posts.stream().collect(Collectors.groupingBy(BlogPost::postType, Collectors.summingInt(BlogPost::likes)));

        //likesCount.forEach((k,v)-> System.out.println(STR."Key=\{k} and value =\{v}"));

        // group by - multiple fields and take the max salary
        // dept and role wise, highest paid
        Map<String, Map<String, Optional<Employee>>> highestPaidByDeptAndJob = emp.stream()
            .collect(Collectors.groupingBy(Employee::getDept,
                Collectors.groupingBy(Employee::getName,
                    Collectors.maxBy(Comparator.comparingInt(Employee::getEmpid)))));

        highestPaidByDeptAndJob.forEach((department, jobMap) ->
            jobMap.forEach((jobTitle, employee) ->
                System.out.println("Department: " + department + ", Job Title: " + jobTitle + ", Highest Paid Employee: " + employee.orElse(null))));
    }


// group by - multiple fields
/*        Map<String, Map<String, List<Employee>>> multipleFieldsMapList = employeesList.stream()
            .collect(
                Collectors.groupingBy(Employee::getDesignation,
                    Collectors.groupingBy(Employee::getGender)));*/

        // group by - multiple fields
        // Grouping by designation and Gender two properties and need to get the count.

        /*Map<String, Map<String, Long>> multipleFieldsMap = employeesList.stream()
            .collect(
                Collectors.groupingBy(Employee::getDesignation,
                    Collectors.groupingBy(Employee::getGender,
                        Collectors.counting())));*/

/*        2.7. Getting the Sum from Grouped Results
        To calculate the total sum of likes for each type:


        Map<BlogPostType, Integer> likesPerType = posts.stream()
            .collect(groupingBy(BlogPost::getType, summingInt(BlogPost::getLikes)));*/



    record BlogPost(String postType, Integer likes){};

    static List<BlogPost> getBlogPosts(){
        return List.of(
            new BlogPost("BBC Show",10),
            new BlogPost("Sky Show",15),
            new BlogPost("BBC Show",18),
            new BlogPost("FB Post",19),
            new BlogPost("Tweeter Post",16)
        );
    }
}
