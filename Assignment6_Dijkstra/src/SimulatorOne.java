import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimulatorOne {

    public static void main ( String [] args ){
        try {
            // Wrap the System.in inside BufferedReader
            // But do not close it in a finally block, as we
            // did no open System.in; enforcing the rule that
            // he who opens it, closes it; leave the closing to the OS.
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                // TODO: Handle input line
            }

            // Null was received, so loop was aborted.

        } catch (IOException e) {
            // TODO: Add error handler
        }


        //System.out.println(args[0]+args[1]+args[2]+args[4]);
    }
}
