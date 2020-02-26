import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;



public class LSArrayApp {

    static String[] ArrayData= new String[2976];
    static int opCount = 0;

    public static void main(String[] args) {
        //read file and add to list
        try {
            File myObj = new File("./src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            Scanner myReader = new Scanner(myObj);
	        int counter=0;

	    while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
        		ArrayData[counter++]=data;
                opCount++;
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
            opCount++;
        }
        else{
            System.out.println("Number of arguments: "+args.length);
        printAreas(args[0], args[1], args[2]);
        }

        System.out.println("Value of opCount is:"+ opCount);
    }
    public static void printAreas (String stage, String day, String startTime){
        String concat = stage + "_" +  day + "_" + startTime;
        System.out.println("print Areas called");


        for (String data: ArrayData) {
            String[] splitted = data.split(" "); //data element0 2 elements: date etc, areas
            if (splitted[0].equals(concat)){
                System.out.println("Matching areas: " + splitted[1] );
                //.equals
                //add matching areas to array which will be later output.
                opCount++;
            }

        }
    }
    public static void printAllAreas() {
        for (String data: ArrayData) {
             System.out.println(data);
        }



    }
}
