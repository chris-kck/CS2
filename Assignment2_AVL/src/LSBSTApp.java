import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <h1><b>LSBSTApp</b></h1>
 * The LSBSTApp program implements an application that
 * reads data from a text file and stores it in a
 * binary search tree. It has a method which
 * lookups up data matching with a user-specified key.
 * <br><hr>
 * @author  Chris Kateera
 * @version 1.0
 * @since   01-03-2020
 */
public class LSBSTApp {

    static int insertCount = 0;
    static int findCount = 0;
    static BinarySearchTree<String> bin = new BinarySearchTree<>();
    public static void main(String[] args){
        System.out.println("------------START-OF-OUTPUT------------------");
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

        System.out.println("Value of BST insertCount is:"+ LSBSTApp.insertCount);
        System.out.println("Value of BST height is: "+ bin.getHeight());
        if (args.length==0){
            System.out.println("Arguments: No arguments passed");
            printAllAreas(bin);
        }
        else if (args.length==3){
            System.out.print("Arguments: ");
            for (String arg : args) { System.out.print(arg+ " ");} System.out.println();
            printAreas(args[0], args[1], args[2]);
        }
        else{System.out.println("Arguments: Invalid number of arguments");}
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
         * are printed
         */
        BinaryTreeNode<String> node;
        node = bin.find(concat);
        if (node!= null) {
            System.out.println(node.data);
            System.out.println("Value of BST findCount is:"+ LSBSTApp.findCount);
        }
        else {
            System.out.println("Areas not found.");
        }
    }

    public static void printAllAreas( BinarySearchTree<String> bin){
        bin.inOrder();
        System.out.println(insertCount);
    }


}
