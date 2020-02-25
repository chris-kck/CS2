import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LSArrayApp {
    public static void main(String[] args) {
        try {
            File myObj = new File("./src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            Scanner myReader = new Scanner(myObj);
	    int counter=0;
            String[] ArrayData= new String[2976];
	    while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
		
		ArrayData[counter++]=data;
                System.out.println(data);
            }

            System.out.println("The element is "+ArrayData[2970]);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Hello KC");
    }
}
