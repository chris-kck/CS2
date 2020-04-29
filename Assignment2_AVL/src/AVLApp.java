import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <h1><b>AVLApp</b></h1>
 * The AVLApp program implements an application that
 * reads data from a text file and stores it in a
 * AVL tree. It has a method which
 * lookups up data matching with a user-specified key.
 * <br><hr>
 * @author  Chris Kateera
 * @version 1.0
 * @since   29-04-2020
 */

public class AVLApp {
    static int insertCount = 0;
    static int  findCount = 0;
    static AVLTree<String> bin = new AVLTree<String>();
    public static void main(String[] args){
        System.out.println("------------START-OF-OUTPUT-------------------");
        try {
            File myObj = new File("./src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                bin.insert(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Value of AVL insertCount is:"+ AVLApp.insertCount);
        System.out.println("Value of AVL height is: "+ bin.getHeight());

        if (args.length==0){
            System.out.println("Arguments: No arguments passed");
            printAllAreas(bin);
        }
        else if (args.length==1){
            printAreas(args[0]); //Condition for automation which passes 1 argument already concatenated
        }
        else if (args.length==3){
            System.out.print("Arguments: ");
            for (String arg : args) { System.out.print(arg+ " ");} System.out.println();
            printAreas(args[0], args[1], args[2]);
        }

        else {System.out.println("Arguments: Invalid number of arguments");}
        System.err.println(AVLApp.findCount); // Sends findCount to stderr stream for part5: I need to collect findCount values ONLY
        System.out.println("------------END-OF-OUTPUT------------------");
    }

    public static void printAreas (String stage, String day, String startTime){
        String concat = stage + "_" +  day + "_" + startTime;
        printAreas(concat);
    }

    public static void printAreas (String concat){
        /**
         * printAreas method concatenated input strings and
         * compares them with a stored key. Matching results
         * are printed.
         */

        BinaryTreeNode<String> node;
        node = bin.find(concat);
        if (node!= null) {
            System.out.println(node.data);
            System.out.println("Value of AVL findCount is:"+ AVLApp.findCount);
        }
        else {
            System.out.println("Areas not found");
        }
    }

    public static void printAllAreas( AVLTree<String> bin){
        bin.inOrder();
    }


}
