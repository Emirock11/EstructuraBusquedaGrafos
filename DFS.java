import java.io.*; 
import java.util.*; 
  

public class  DFS
{ 
    private int V;   // Número de vértices
  
    //Representation Arreglo de listas
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    DFS(int v)
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Funcion para agregar un borde
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
    } 

     //****************************** Aquí es en donde está lo más importante **************************************************

    // Función DFS
    void DFSUtil(int v,boolean visited[]) 
    { 
        // Marca el nodo actual visitado y lo imprime como falso o verdadero
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Repite para todos los vertices adyacentes del vértice actual
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // Function para DFS traversal. Usa la recursividad de DFSUtil()
    void DFS(int v) 
    { 
        // Se marcan como falso los vertices que no se han visitado
        boolean visited[] = new boolean[V]; 
  
        // Llama el ayudante recursivo para imprimir el DFS transversal

        DFSUtil(v, visited); 
    } 

    //************************************************************************************************************************

    public static void main(String args[]) 
    { 
        Graph g = new Graph(4); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
    } 
} 