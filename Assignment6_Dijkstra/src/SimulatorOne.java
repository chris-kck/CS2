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
            int lineNo=0;
            int Nodes =0;
            int count=0;
            Graph g = new Graph( );

            while ((line = in.readLine()) != null) {

                if (lineNo==0) {
                    Nodes = count = Integer.parseInt(line);
                    System.out.println("Nodes= "+ Nodes);
                }
                if (count-->=0 && lineNo!=0){ //get all nodes' vertex info
                    System.out.println("Source,Dest data:"+line); //iterate till zero
                    //create vertices here
                    String split[]= line.split(" ");
                    createGraph(split, g);

                }
                    //modify vertices to add hosp/victim info
                if (lineNo==Nodes+1){
                    System.out.println("Number of hospitals"+ line);
                }
                //hospitals/victims list will tell u how many hospitals /victims
                if (lineNo==Nodes+2){
                    System.out.println("Hospital Nodes"+ line);

                }
                if (lineNo==Nodes+3){
                    System.out.println("Number of victims"+ line);
                }
                if (lineNo==Nodes+4){
                    System.out.println("Victim Nodes"+ line);
                }


                //Lines = Nodes + Nodes info 1xNodes + hosp info x2 + victim info x2
                // TODO: Handle input line
                lineNo++; //increase line count
            }
            //Input read complete, We now have our graph g populated. Now the fun part :
            //For each victim, visit hospitals. check for several same minCost paths.
            // for victim -> hospital, hospital (check all hospital costs, compare & store if equal cost.


            roundTrip(g,"2","0");

        } catch (IOException e) {
            //Error handler
        }

    }
    /*
    public static int[] intList(String [] a){
        int[] b = new int[a.length];
        int count=0;
        for (String data: a) {
            count++;
            b[count]=(Integer.parseInt(data));
        }
        return b;
    }
     */

    public static void createGraph(String[] a, Graph g){

        for (int i = 1; i < a.length; i+=2) {
            //if (i==0) continue; //skip source index
            //else{
                //create vertex & edge
                //when u add an edge, the algo adds the vertex if it didn't exist
                double tmp = Double.parseDouble(a[i+1]);
                g.addEdge(a[0],a[i],tmp);
            //}
        }
    }
    public static String route="";

    public static void roundTrip(Graph g, String hospital, String victim){
        g.dijkstra( hospital); //hospital
        g.printPath( victim ); // victim
        g.dijkstra( victim ); //victim
        g.printPath( hospital ); //back

        //remove repeated victim character & end space.
        route = route.substring(0,route.indexOf(victim))+ route.substring(route.indexOf(victim)+2, route.length()-1);

        //compare different hospital routes.
        System.out.println("Complete Clean route:"+ route);
        //get a list with
        //s.substring(0, pos) + s.substring(pos + 1);
    }

}
