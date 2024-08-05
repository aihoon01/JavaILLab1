package Exercise07;

import java.io.IOException;

public class ExceptionHandling {
    public static void main(String[] args) {
        //Handling checked exception with try-catch block
        try {
            checkedExceptionMethod();
        } catch (IOException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        //Handling unchecked exception with try-catch block
        try {
            uncheckedException();
        } catch (RuntimeException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        //Handling both checked and unchecked exceptions together
        try {
            int outcome = (int) Math.ceil((Math.random() *2));
            System.out.println("outcome = " + outcome);

            if (outcome == 1) {
                checkedExceptionMethod();
            } else {
                uncheckedException();
            }
        } catch(IOException e) {
            System.out.println("Caught checked exception in a chained exception");
        } catch (RuntimeException e) {
            System.out.println("Caught unchecked Exception in this chained exception");
        }
    }

    public static void checkedExceptionMethod() throws IOException {
        throw new IOException(("This is a checked Exception"));
    }

    public static void uncheckedException() {
        throw new RuntimeException("This is an unchecked exception");
    }
}
