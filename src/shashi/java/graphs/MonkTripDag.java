package shashi.java.graphs;// Java implementation of Kosaraju's algorithm to print all SCCs

import java.util.*;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Shashi Mourya
 * Date: 3/19/18
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
// This class represents a directed graph using adjacency list
// representation
class MonkTripDag
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
    private static int stateCount = 0;

    //Defines a Graph with v vertices
    MonkTripDag(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w){
        adj[v-1].add(w-1);
    }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v,boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        //System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i =adj[v].iterator();
        while (i.hasNext())
        {
            n = i.next();
            if (!visited[n])
                DFSUtil(n,visited);
        }
    }

    // Function that returns reverse (or transpose) of this graph
    MonkTripDag getTranspose()
    {
        MonkTripDag g = new MonkTripDag(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack)
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext())
        {
            int n = i.next();
            if(!visited[n])
                fillOrder(n, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack
        stack.push(new Integer(v));
    }

    // The main function that finds and prints all strongly
    // connected components
    void printSCCs()
    {
        Stack stack = new Stack();

        // Mark all the vertices as not visited (For first DFS)
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        // Fill vertices in stack according to their finishing
        // times
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                fillOrder(i, visited, stack);

        // Create a reversed graph
        MonkTripDag gr = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++)
            visited[i] = false;

       // Now process all vertices in order defined by Stack
        while (stack.empty() == false)
        {

            // Pop a vertex from stack
            int v = (Integer)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[v] == false)
            {
                gr.DFSUtil(v, visited);
                //System.out.println();
                stateCount++;
            }
        }
    }

    // Driver method
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        s.nextLine();
        MonkTripDag monkTrip = new MonkTripDag(N);
        for(int i=0; i<M; i++){
             int v = s.nextInt();
             int u = s.nextInt();
            monkTrip.addEdge(v, u);
            s.nextLine();
        }
       /* monkTrip.addEdge(0, 1);
        monkTrip.addEdge(1, 2);
        monkTrip.addEdge(2, 0);
        monkTrip.addEdge(0, 3);*/
       // monkTrip.addEdge(3, 4);

        monkTrip.printSCCs();
        if(stateCount!=0)
            System.out.println(stateCount-1);
        else
            System.out.println(stateCount);
    }
}