package GraphFramework;
import java.util.LinkedList;

/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */

public class Vertex {
   
    int label; // Name of this Vertex
    Boolean isVisited;
    LinkedList <Edge> adjList; // The AdjList of this Vertex
    
    public Vertex() {
        adjList = new LinkedList<Edge>() ;
    }
  
    public Vertex(int label) {
        this.label = label;
        this.isVisited = false;
        adjList = new LinkedList<Edge>();
    }

    public void displayInfo() {
    }
} 
