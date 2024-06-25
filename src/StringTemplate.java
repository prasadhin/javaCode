import static java.lang.StringTemplate.STR;

public class StringTemplate {

    public static void main(String[] args) {
        String msg = "";
        var name = "Prasad";
        var age = 20;

        msg = STR. "This is \{ name } and \{    age}";
        System.out.println(msg);
        System.out.println(interpolationUsingSTRProcessor("great","20C","IT"));
    }

    static String interpolationUsingSTRProcessor(String feelsLike, String temperature, String unit) {
        return STR
            . "Today's weather is \{ feelsLike }, with a temperature of \{ temperature } degrees \{ unit }";
    }
}
