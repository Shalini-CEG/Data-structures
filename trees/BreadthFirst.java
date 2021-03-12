import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BFVertex {
    public char label;
    public boolean wasVisited;

    public BFVertex (char name){
        label = name;
        wasVisited = false;
    }
}

class BFGraph {
    private final int MAX_VER = 20;
    private BFVertex vList[];
    private int adjMat[][];
    private int pos;
    private Queue<Integer> q;

    public BFGraph() {
        vList = new BFVertex[MAX_VER];
        adjMat = new int[MAX_VER][MAX_VER];
        pos = 0;
        q = new LinkedList<Integer>();
    }

    public void addVertex(char name) {
        vList[pos++] = new BFVertex(name);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v){
        if(v == 0) {
            System.out.println("|Graph Begins|");
            System.out.println("\t" + "Vertex" + " " + vList[v].label + " " + "Initial:" +  v);
        }

        for(int i = 0; i < pos; i++){
            if(adjMat[v][i] == 1 && vList[i].wasVisited == true){
                System.out.println("\t" + "Vertex" + " " + vList[v].label + " " + "Edge: " + i + v);
            }
        }
    }

    public int getUnvisitedVertex(int v){
        for(int i = 0; i < pos; i++){
            if(adjMat[v][i] == 1 && vList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void bfs() {
        vList[0].wasVisited = true;
        displayVertex(0);
        q.add(0);
        int v2;

        while(!q.isEmpty()) {
            int v1 = q.remove();
            while((v2=getUnvisitedVertex(v1))!=-1) {
                vList[v2].wasVisited = true;
                displayVertex(v2);
                q.add(v2);
            }
        }
    }
}

public class BreadthFirst {
    public static void main(String[] args) {
        char value;
        BFGraph g = new BFGraph();
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an operation to perform\n\t1. Add vertex   2. Add an Edge 3. Display  4. Close");
            int ch = s.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Assign a value for vertex...");
                    value = s.next().charAt(0);
                    g.addVertex(value);
                    System.out.println("Extend graph by adding edges");
                    break;

                case 2:
                    System.out.println("Connect edges from ___ and to ___: ");
                    g.addEdge(s.nextInt(),s.nextInt() );
                    break;

                case 3:
                    System.out.println(" \t CHECK OUT VISITS ");
                    g.bfs();
                    System.out.println();
                    break;

                default:
                    return;
            }
        }
    }
}
