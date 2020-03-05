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

    static boolean match_found= false;
    static int opCount = 0;
    static BinarySearchTree<String> bin = new BinarySearchTree<String >();
public static void main(String[] args){
    //System.out.println("------------START-OF-OUTPUT-------------------");
    try {
        File myObj = new File("./src/subset/600.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            bin.insert(myReader.nextLine());
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        //System.out.println("An error occurred.");
        e.printStackTrace();
    }

    if (args.length==0){
        printAllAreas(bin);
    }
    else if (args.length==1){
        //System.out.println("Number of arguments: "+args.length);
        printAreas(args[0]);//, args[1], args[2]);
    }
    else{System.out.println("Invalid number of arguments");}


    //System.out.println("Value of insertCount is:"+ LSArrayApp.insertCount);
    //System.out.println("Value of findCount is:"+ LSArrayApp.findCount);
    System.out.println(LSArrayApp.findCount);
    //System.out.println("Value of opCount is:"+ opCount + "\n");
    //System.out.println("------------END-OF-OUTPUT------------------");
}



    public static void printAreas (String concat){
        /**
         * printAreas method concatenated input strings and
         * compares them with a stored key. Matching results
         * are printed.
         */
        //String concat = stage + "_" +  day + "_" + startTime;
        BinaryTreeNode<String> node  = new BinaryTreeNode<String>(null,null,null);
        node = bin.find(concat);
        if (node!= null) {
            //System.out.println(node.data);
        }
        else {
            //System.out.println("Areas not found");
        }
    }

public static void compare_nodes(){
    //String split[]= node.data.toString().split(" ")
    //for each bin node, create new [0] node then compare with concat node node.data[0] to
}

public static void printAllAreas( BinarySearchTree<String> bin){
    bin.inOrder();
    //System.out.println(bin.toString());
}


}
