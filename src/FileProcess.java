import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcess {
    public static void main(String[] args) throws IOException {
        System.out.println("heele");
        Supplier<Stream<String>> streamSupplier = () -> {
            try {
                return Files.lines(Paths.get("sample.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };
        //Stream<String> lines = Files.lines(Paths.get("sample.txt"));
        Stream<String> lines = streamSupplier.get();
        //lines.forEach(System.out::println);
       // List<String> words =
        List<String> words = lines.flatMap(line -> Arrays.stream(line.split("\\s+"))).collect(Collectors.toList());
        //List<String> words = lines.map((a) -> a.split(" ")).flatMap().collect(Collectors.toList()))
        words.forEach(System.out::println);
        lines.close();
        lines = Files.lines(Paths.get("sample.txt"));
        List<String[]> wordss = lines.map(a -> a.split(" ")).collect(Collectors.toList());
        wordss.stream().forEach((a)-> Arrays.asList(a).forEach(System.out::print));
        for (String[] strings : wordss) {
           for (String word: strings){
               System.out.println(word);
           }
        }
    }
}
