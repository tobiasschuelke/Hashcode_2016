import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main (String[] args) {
        if (args == null || args.length != 1) {
            System.err.println("No input File specified!");
            return;
        }

        try {
            String input = new String(Files.readAllBytes(Paths.get(args[0])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
