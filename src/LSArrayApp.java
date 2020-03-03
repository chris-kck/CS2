import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.*;



public class LSArrayApp {

    static String[] ArrayData= new String[2976];
    static int opCount = 0;
    static boolean match_found= false;

    public static void main(String[] args) {
        //read file and add to list
        try {
            File myObj = new File("./src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            Scanner myReader = new Scanner(myObj);
	        int counter=0;

	    while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
        		ArrayData[counter++]=data;
                //System.out.println(data);
            }
            //System.out.println("The element is "+ArrayData[2970]);
            //String[] splited = ArrayData[2970].split(" ");
	        //System.out.println("splitted is:" + splited[0]);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //System.out.println("Hello KC");
        if (args.length==0){
            printAllAreas();
        }
        else if (args.length==3){
            System.out.println("Number of arguments: "+args.length);
        printAreas(args[0], args[1], args[2]);
        }
        else{System.out.println("Invalid number of arguments");}

        System.out.println("Value of opCount is:"+ opCount);

    }


    public static void printAreas (String stage, String day, String startTime){
        String concat = stage + "_" +  day + "_" + startTime;

        for (String data: ArrayData) {
            opCount++;
            String[] splitted = data.split(" "); //data element0 2 elements: date etc, areas
            if (splitted[0].equals(concat)) {
                System.out.println("Matching areas: " + splitted[1]);
                match_found = true;
                break;
            }
        }
            if (!match_found){
                System.out.println("Areas not found");
            }
    }
    public static void printAllAreas() {
        for (String data: ArrayData) {
             System.out.println(data);

        }
    }

}
