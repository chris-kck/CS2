import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LSBSTApp {
public static void main(String[] args){
    BinarySearchTree<String> bin = new BinarySearchTree<String >();

    try {
        File myObj = new File("./src/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            bin.insert(myReader.nextLine());

            //call printall areas
        }
        myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
}



}
