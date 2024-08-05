package Exercise07.CustomExceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
    public static void readFile(String filePath){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader(filePath));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new FileReadException("Error reading file: " + filePath, e);
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Failed to close reader");
                }
            }
        }
    }
}
