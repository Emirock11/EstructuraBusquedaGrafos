import java.io.*; 
import java.util.*; 
  

public class  BFS
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Funcion para agregar un borde
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    //*********************************** Parte mas importante para la busqueda ****************************************

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Marca el nodo actual visitado y lo imprime como falso o verdadero
        boolean visited[] = new boolean[V];

        // Crea un queue para BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Marca el nodo actual como visitado y lo enqueue
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
} 