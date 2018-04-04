package shashi.java.graphs;

/**
 * Created with IntelliJ IDEA.
 * User: Shashi Mourya
 * Email: 0905shashi@gmail.com
 * Date: 4/4/18
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayTraversal {

    private int V;   // No. of vertices
    private static int[][] adjMatrix;

    ArrayTraversal(int v){
        ArrayTraversal.adjMatrix = new int[v][v];
        this.V=v;
        for(int i=0; i<v; i++)
            for(int j=0;j<v;j++)
                adjMatrix[i][j]=0;
    }

    int minDistance(int dist[], boolean[] visited)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (visited[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public void shortestPath(int s){

        int dist[] = new int[V];

        // Mark all the vertices as not visited (For first DFS)
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[s]=0;
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, visited);

            // Mark the picked vertex as processed
            visited[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!visited[v] && adjMatrix[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+adjMatrix[u][v] < dist[v])
                    dist[v] = dist[u] + adjMatrix[u][v];
        }

        System.out.println(dist[V-1]);
    }

    // Driver method
    public static void main(String args[])
    {
        //int[] arr = {2,4,6,5,4,1};
        int[] arr = {2,4,6,5,4,1,7,5};
        int size = arr.length;
        ArrayTraversal arrTrav = new ArrayTraversal(size);

        //graph construction adjacency list
      /*  for(int i=0; i<size-1; i++){
            //if(i!=0) arrTrav.addEdge(i,i);
            arrTrav.addEdge(i,i+1,1);
            for(int j=i+1; j<size; j++){
                if(arr[i]==arr[j])
                    arrTrav.addEdge(i,j,1);
            }
        }
*/
        for(int i=0; i<size-1; i++){
            adjMatrix[i][i+1]=1;
            for(int j=i+2; j<size; j++){
                if(arr[i]==arr[j])
                    adjMatrix[i][j]=1;
            }
        }

        //test
       /* for(int i=0; i<size; i++){

            for(int j=0; j<size; j++){
                System.out.print(adjMatrix[i][j]);
            }
            System.out.println();
        }*/

        arrTrav.shortestPath(0);

    }
}
