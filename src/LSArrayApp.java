import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.*;
import java.lang.*;
import java.io.*;


public class LSArrayApp {

    static String[] ArrayData= new String[2976];

    public static void main(String[] args) {
        try {
            File myObj = new File("./src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            Scanner myReader = new Scanner(myObj);
	        int counter=0;
	    while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
        		ArrayData[counter++]=data;
                System.out.println(data);
            }

            System.out.println("The element is "+ArrayData[2970]);
            String[] splited = ArrayData[2970].split(" ");
	        System.out.println("splitted is:" + splited[0]);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("Hello KC");

        if (args.length == 0){
            System.out.println("Length"+args.length);
        printAreas(args[0], args[1], args[2]);
        }
    }
    public static void printAreas (String stage, String day, String startTime){
        String concat = stage + "_" +  day + "_" + startTime;
        System.out.println("Test");


        for (String data: ArrayData) {
            String[] data0 = data.split(" "); //data element0
            if (data0[0].equals(concat)){
                System.out.println("Matching areas: " + data );
                //.equals
                //add matching areas to array which will be later output.
            }

        }
    }
    public static void printAllAreas (){

    }
}