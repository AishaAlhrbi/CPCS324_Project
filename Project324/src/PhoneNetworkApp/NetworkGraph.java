package PhoneNetworkApp;

/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */
import GraphFramework.Edge;
import GraphFramework.Graph;
import GraphFramework.Vertex;

public class NetworkGraph extends Graph {

    public NetworkGraph() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Vertex createVertex(int label) {
        return new Office(label);
    }

    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        return new Line(source, target, weight);
    }

}
