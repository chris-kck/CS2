import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;

/**
 * <h1><b>LSArrayApp</b></h1>
 * The LSArrayApp program implements an application that
 * reads data from a text file and stores it in an
 * unsorted array data structure. It has a method which
 * lookups up data matching with a user-specified key.
 * <br><hr>
 *
 * @author  Chris Kateera
 * @version 1.0
 * @since   01-03-2020
 */


public class LSArrayApp {

    static String[] ArrayData= new String[2976];
    static int opCount = 0;
    static int insertCount = 0;
    static int findCount = 0;
    static boolean match_found= false;
    static String[] files={"./src/subset/300.txt"};//,"./src/subset/600.txt","./src/subset/900.txt","./src/subset/1200.txt","./src/subset/1800.txt","./src/subset/2400.txt","./src/subset/2700.txt","./src/subset/2900.txt"};

    public static void main(String[] args) {
        //read file and add to list
        /**
         * This is the main method which calls other relevant
         * methods depending on arguments passed.
         * @param args Used when user passes parameters
         * @return Nothing.
         * @exception FileNotFoundException If Schedule file not found
         */

        for (String set:files) {
            //System.out.println("------------START-OF-"+set+"OUTPUT-------------------");
            try {
                File myObj = new File(set);
                Scanner myReader = new Scanner(myObj);
                int counter = 0;

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    ArrayData[counter++] = data;
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


            if (args.length == 0) {
                printAllAreas();
            } else if (args.length == 1) {
                //System.out.println("Number of arguments: " + args.length);
                printAreas(args[0]);
            } else {
                System.out.println("Invalid number of arguments");
            }

            System.out.println(opCount);//"Value of opCount is:" + opCount + "\n");
            //System.out.println("------------END-OF-"+set+"OUTPUT------------------");
        }

    }


    public static void printAreas (String concat){
        /**
         * printAreas method concatenated input strings and
         * compares them with a stored key. Matching results
         * are printed.
         */
        //String concat = stage + "_" +  day + "_" + startTime;

        for (String data: ArrayData) {
            if (data == null) break;
            opCount++;
            String[] splitted = data.split(" "); //data element0 2 elements: date etc, areas
            if (splitted[0].equals(concat)) {
                //System.out.println("Matching areas: " + splitted[1]);
                match_found = true;
                break;
            }
        }
            if (!match_found){
                System.out.println("Areas not found");
            }
    }


    public static void printAllAreas() {
        /**
         * printAllAreas method prints out all the areas,
         * times, stages and affected zones.
         */
        for (String data: ArrayData) {
            if (data == null) break;
             System.out.println(data);
        }

    }

}
