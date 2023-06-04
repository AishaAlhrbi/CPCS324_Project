package PhoneNetworkApp;

/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */
import GraphFramework.Edge;
import GraphFramework.Vertex;

public class Line extends Edge {

    private final int Length;

    public Line(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
        this.Length = weight * 5;
    }

    @Override
    public void displayInfo() {

        System.out.print("line length:  " + Length);
    }

}
