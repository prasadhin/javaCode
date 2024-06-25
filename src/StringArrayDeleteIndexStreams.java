import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StringArrayDeleteIndexStreams {

    public static Integer[] convertPrimitiveToInteger(int[] input, int index){
        return Arrays.stream(input)
            .filter(i->i!=index)
            .boxed()
            .toArray(Integer[]::new);
    }

    public static Employee[] convertListEmployeestoArray(List<Employee> employeeList){
        return employeeList.stream().toArray(Employee[] ::new);

    }
    public static void main(String[] args) {
       int[] numbers = IntStream.rangeClosed(1,10).toArray();
       Integer[] objectNumbers = convertPrimitiveToInteger(numbers,3);
        Arrays.stream(objectNumbers).forEach(System.out::println);

        Employee[] employees = convertListEmployeestoArray(Comparators.getEmployees());
        Arrays.stream(employees).forEach(System.out::println);

    }
}
