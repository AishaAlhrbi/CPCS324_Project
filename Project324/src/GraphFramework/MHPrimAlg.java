
package GraphFramework;
/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */
import java.util.PriorityQueue;

public class MHPrimAlg extends MSTAlgorithm {

    // Data fields
    private int cost = 0;

    /**
     * PQPrimAlg Constructor
     *
     * @param graph
     */
    public MHPrimAlg(Graph graph) {
        MSTresultList = new Edge[graph.verticesNO]; // Array holds the edges of MST
    }

    public MHPrimAlg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Shows Resulting MST
     *
     * @param graph
     */
    @Override
    public void findMST(Graph graph) {

        Vertex vc = graph.vertices[0]; // Current vertex will hold vertex 0.

        PriorityQueue<Edge> pq = new PriorityQueue<>(); //PriorityQueue to store edges weights

        
        // Loop through vertices array (|V|-1)
        for (int i = 0; i < MSTresultList.length - 1; i++) {

            // Loop through adjacent vertices of this vertex
            for (int j = 0; j < vc.adjList.size(); j++) {
                Edge edge = vc.adjList.get(j);
                edge.source.isVisited = true;
                // Check if its visited or not before adding it to the queue
                if (!edge.target.isVisited) {
                    pq.add(edge); // Remaining edges

                }
            } 
            while (!pq.isEmpty()) {
                Edge edge = pq.remove(); // Remove edge with minimum-weight edge e*=(v*, u*)

                if (!edge.target.isVisited) {

                    edge.target.isVisited = true; // Mark u* (target) as visited now 

                    MSTresultList[i] = edge; // Add the target edge to the MST list

                    cost += MSTresultList[i].weight; // Get cost of minimum-weight edges (MST)

                    vc = edge.target; // Next Vertex to check adjacent of it
                    break; // exit after adding 1 result to the MST
                } 
            } 
        } 
    } 

    @Override
    public void displayResultingMST() {
        for (int i = 0; i < MSTresultList.length - 1; i++) {
            Vertex vf = MSTresultList[i].source;
            vf.displayInfo();
            System.out.print(" - ");
            Vertex vs = MSTresultList[i].target;
            vs.displayInfo();
            System.out.print(" : line length: " + (MSTresultList[i].source.label + 1) + " ");
            Edge e = MSTresultList[i];
            e.displayInfo();
            System.out.println();
        }
    }

    @Override
    public void displayMSTcost() {
        System.out.println("designed phone network:  " + this.cost);
    }

}
