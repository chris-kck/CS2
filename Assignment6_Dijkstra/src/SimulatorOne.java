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
            int[] allNodes;
            int[] hostpitalN;
            int[] victimN;
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
            //We now have our graph g populated. Now the fun part :)
            // Null was received, so loop was aborted.
            //g.dijkstra( startName );
            //g.printPath( destName );
            //g.printPath( destName );

            //trip going
            g.dijkstra( "2" ); //hospital
            g.printPath( "0" ); // victim

            //trip back
            g.dijkstra( "0" ); //victim
            g.printPath( "2" ); //back

            //modiy printpath to print path instead of cost



        } catch (IOException e) {
            // TODO: Add error handler
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

}
