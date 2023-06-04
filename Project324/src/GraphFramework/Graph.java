package GraphFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import PhoneNetworkApp.Line;
import PhoneNetworkApp.NetworkGraph;
import PhoneNetworkApp.Office;

/*
 *  @authors Reem, Aisha, Sara, Hanady
 * CPCS-324
 * Project Code
 * 4 June. 2023
 */
public class Graph {

    int verticesNO;
    int edgeNO;
    Boolean isDigraph;
    Vertex[] vertices;
    Graph map;

    public Graph(int verticesNO, int edgeNO, boolean isDigraph) {
        this.verticesNO = verticesNO;
        this.edgeNO = edgeNO;
        this.isDigraph = isDigraph;
        this.vertices = new Vertex[verticesNO];
    }

    public Graph() {
    }

    // Create Vertex
    public Vertex createVertex(int label) {
        return new Vertex(label);
    }

    // Create Edge
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        return new Edge(source, target, weight);
    }

    /**
     * addEdge(v,u,w): is a function that creates an edge object and passes the
     * source vertex v, the target vertex u and w the vertex weight as
     * parameters, assigns the target vertex to the adjacent list of the source
     * vertex and if the graph is undirected then it will add the source vertex
     * to the adjacent list of the target vertex. It increments the EdgeNo by
     * one in case it is a directed graph and by two if it is an undirected
     * graph.
     *
     */
    /**
     * This Method Read The Graph file from the Main
     */
    public void readGraphFromFile(File fileName) throws FileNotFoundException {

        Scanner input = new Scanner(fileName);

        String typeofGraph = input.nextLine(); // Is direct graph or not?
        if (typeofGraph.equalsIgnoreCase("digraph 0")) {
            isDigraph = false; // 0 == undirected graph
        } else if (typeofGraph.equalsIgnoreCase("digraph 1")) {
            isDigraph = true; // 1 == directed graph
        }

        int totalNumberOfVertices = input.nextInt(); // Read # Vertices 
        int totalNumberOfEdge = input.nextInt(); // Read # Edges 

        if (!isDigraph) {
            totalNumberOfEdge *= 2;
        }

        vertices = new Vertex[totalNumberOfVertices]; // Initialize Array of Vertices

        while (edgeNO < totalNumberOfEdge) {
            char source = input.next().charAt(0);
            char destination = input.next().charAt(0);
            int weight = input.nextInt();

            addEdge(source - 65, destination - 65, weight);

        }
        input.close();
    }

    public Edge addEdge(int v, int u, int weight) {

        Graph map = new NetworkGraph();

        // This Eliminate Duplicate 
        if (vertices[v] == null) {
            verticesNO++; // Increment# of Vertices First to Avoid Size problem
            vertices[v] = map.createVertex(v); // Create new Source Vertex in the Array of Vertices
        }

        if (vertices[u] == null) {
            verticesNO++;
            vertices[u] = map.createVertex(u);
        }

        Edge newEdge = map.createEdge(vertices[v], vertices[u], weight);
        edgeNO++; // Increase # of Edges

        // Access the Vertex Adj_List and add the Edge with its weight.    		 
        vertices[v].adjList.add(newEdge);

        // If the Graph is undirected 
        if (!isDigraph) {

            // Add the OPPOSITE Edge (Undirected).   
            newEdge = map.createEdge(vertices[u], vertices[v], weight);
            edgeNO++; // Increase # of Edges

            // Access the Vertex Adj_List and add the Edge with its weight.
            vertices[u].adjList.add(newEdge);
        }

        return newEdge;

    }

    public void makeGraph(int verticesNO, int edgeNO) {

        // Store All Vertices Accordingly 
        for (int i = 0; i < verticesNO; i++) {
            vertices[i] = new Vertex(i);
        }

        // Store Edges respectively to make sure ALL VERTICES ARE CONNCTED ( (|V|-1)= # E )
        for (int i = 0; i < verticesNO - 1; i++) {

            // Vertex u, Vertex v, RANDOM Edge Weight
            addEdge(vertices[i].label, vertices[i + 1].label, (int) (1 + Math.random() * 10));
        }

        int i = 0;
        // Add Remaining Edges RANDOMLY -> edgeNO-(|V|-1)
        while (i < (edgeNO - (verticesNO - 1))) {
            int vertexU = (int) (Math.random() * verticesNO);
            int vertexV = (int) (Math.random() * verticesNO);

            // Avoid vertex if its self-looped
            if (vertexU == vertexV) {
                continue; // Skip the loop ( increment is skipped also) & get new random vertices.
            }

            // Avoid duplicate edge with the same source and target
            for (int j = 0; j < vertices[vertexU].adjList.size(); j++) {
                if (vertices[vertexU].adjList.get(j).target.label != vertexV) {

                    break; // break out of loop if vertexU and vertexV are not an edge.

                } // end of if statement
            }

            // if there was no self-loop vertex & none existing edge, add new edge & increment
            addEdge(vertices[vertexU].label, vertices[vertexV].label, (int) (1 + Math.random() * 10));
            i++;

        }
    }
}
