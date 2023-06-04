package GraphFramework;

/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */

public class Edge implements Comparable<Edge> {

    int weight;
    Vertex source;
    Vertex target;
    Vertex parent;


    public Edge() {
        source = new Vertex(); 
        target = new Vertex();
        parent = new Vertex();
    }
    
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        parent= new Vertex();
    }   
  
    @Override
    public int compareTo(Edge o) {
        if(this.weight > o.weight)
            return 1;
        else if (this.weight == o.weight)
            return 0;
        else return -1;
      
    }

	public void displayInfo() {
		
	}
	
} 

