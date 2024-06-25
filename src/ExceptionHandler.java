public class ExceptionHandler extends Exception{

    public ExceptionHandler(String message) {
        super(message);
    }


    public static void main(String[] args) {
        try {
            if(!(args.length==0)) throw new ExceptionHandler("wrong value");
        } catch (ExceptionHandler e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
