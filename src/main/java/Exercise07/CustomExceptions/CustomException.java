package Exercise07.CustomExceptions;

public class CustomException {
    public static void main(String[] args) {
        var file = new FileProcessor();
        try {
            file.readFile("new_file.txt");
        }catch (FileReadException e) {
            System.err.println("Custom Exception Caught: " + e.getMessage());
        }
    }
}
