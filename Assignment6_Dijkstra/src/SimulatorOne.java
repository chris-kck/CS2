import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class SimulatorOne {
    public static String[] victims = new String[5];
    public static String[] hospitals = new String[5];
    public static String route="";
    public static int Tcost=0;
    public static Route[] k = new Route[5];


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
                    //System.out.println("Nodes= "+ Nodes);
                }
                if (count-->=0 && lineNo!=0){ //get all nodes' vertex info
                    //System.out.println("Source,Dest data:"+line); //iterate till zero
                    //create vertices here
                    String split[]= line.replace("\t", " ").split(" ");
                    createGraph(split, g);
                }
                if (lineNo==Nodes+1){
                    //System.out.println("Number of hospitals"+ line);
                }
                //hospitals/victims list will tell u how many hospitals /victims
                if (lineNo==Nodes+2){
                    //System.out.println("Hospital Nodes"+ line);
                    hospitals = line.trim().split(" ");
                    //h.setHospitals(hospitals);
                }

                if (lineNo==Nodes+3){
                    //System.out.println("Number of victims"+ line);
                }
                if (lineNo==Nodes+4){
                    //System.out.println("Victim Nodes"+ line);
                    victims = line.trim().split(" ");
                    //h.setVictims(victims);
                }

                //Lines = Nodes + Nodes info 1xNodes + hosp info x2 + victim info x2
                // TODO: Handle input line
                lineNo++; //increase line count
            }
            //Input read complete, We now have our graph g populated. Now the fun part :
            //For each victim, visit hospitals. check for several same minCost paths.
            // for victim -> hospital, hospital (check all hospital costs, compare & store if equal cost.
            int i=0;
            for (String victim : victims) {
                //System.out.println("victim " + victim);
                for (String hospital : hospitals) { //different hospitals for same victim
                    //for hospital heck for same T.cost and output: multiple cost.
                    //System.out.println("hospital " + hospital);
                    roundTrip(g,hospital, victim); //modifies route
                    k[i++]=new Route(victim,hospital, route, Tcost); // store routes in Array

                     //roundTrip(g, hospital, victim); //changes Tcost value
                    route=""; Tcost=0; //reset route and Tcost for next iterstion
                    //System.out.println();
                }
            }

            ArrayList<Route> answer= best_route(k, victims);
                String v="";
                for (Route b:answer){
                    if (!(b.victim.equals(v))){
                        System.out.println("victim "+b.victim);
                        System.out.println(b.toString());
                        v = b.victim;
                    }
                    else{
                        System.out.println(b.toString());
                    }
                }

        } catch (IOException e) {
            //Error handler
        }

    }
    //extend to produce for different victims
    public static ArrayList best_route(Route[] k, String[] victims) {
        //compare k's different hosp-vict route objects' Tcost. Print with lowest cost or equal costs.
        ArrayList<Route> best = new ArrayList<Route>();


            int n =0;
            int kcount = 0;
            for(String victim:victims) {
                best.add(k[kcount]); //add first different victim's Route to compare to.
                for (Route a : k) { //k has ALL victims
                    //counts k's index
                    if (a != null) {
                    if (a.victim==victim) { //selects first victim & adds relevant detail, then moves on to next victim
                        kcount++;
                        if (a.Tcost < best.get(n).Tcost) {
                                best.set(n, a); //replace new lowest cost route to 0.
                            }
                            if ((a.Tcost == best.get(n).Tcost) && !(a.route.equals(best.get(n).route))) {
                                best.add(a); n++;//add to "1" route if cost is same but different routes
                            }

                            //if new victim, set best to new victim's

                        }
                    }
                } n++; //kcount=0; //move to next arraylist element no.
                //kcount=0;
            }
        return best;
    }

    public static void createGraph(String[] a, Graph g){

        for (int i = 1; i < a.length; i+=2) { // start from 1 to skip source index.
                double tmp = Double.parseDouble(a[i+1]); //when u add an edge, the algo adds the vertex if it didn't exist
                g.addEdge(a[0].trim(),a[i].trim(),tmp);
        }
    }

    public static void roundTrip(Graph g, String hospital, String victim){
        //System.out.println("Roundtrip from "+ hospital+" to "+victim);
        g.dijkstra( hospital); //hospital
        g.printPath( victim ); // victim
        g.dijkstra( victim ); //victim
        g.printPath( hospital ); //back
        route = route.substring(0,route.indexOf(victim))+ route.substring(route.indexOf(victim)+2).trim(); //remove repeated victim character & end space.
    }

}


class Route {
    public int Tcost;   // Vertex name
    public String victim;   // Vertex name
    public String hospital;   // Vertex name
    public String route;    // Adjacent vertices

    public Route(String victim, String hospital, String route, int Tcost){
        this.Tcost=Tcost;
        this.victim=victim;
        this.hospital=hospital;
        this.route=route;
    }

    public int getTcost() {
        return Tcost;
    }

    public String getHospital() {
        return hospital;
    }

    public String getRoute() {
        return route;
    }

    public String getVictim() {
        return victim;
    }

    @Override
    public String toString() {
             return  "hospital " + hospital + "\n"+ route;
    }
}


// routes gen - continue if unreachable, route=unreachable, Tcost high infini