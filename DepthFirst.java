import java.util.*;
class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex (char name){
        label = name;
        wasVisited = false;
    }
}

class Graph{
    private final int MAX_VER = 20;
    private Vertex vList[];
    private int adjMat[][];
    private int pos;
    private Stack<Integer> s;

    public Graph(){
        vList = new Vertex[MAX_VER];
        adjMat = new int [MAX_VER][MAX_VER];
        pos = 0;
        s = new Stack<Integer>();
    }

    public void addVertex(char name){
        vList[pos++] = new Vertex(name);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
        //System.out.println(start +  end);
    }

    public void displayVertex(int v){
        if(v == 0) {
            System.out.println("|Graph Begins|");
            System.out.println("\t" + vList[v].label + " " + "Initial:" +  v);
        }

        for(int i = 0; i < pos; i++){
            if(adjMat[v][i] == 1 && vList[i].wasVisited == true){
                System.out.println("\t" + vList[v].label + " " + "Edge: " + i + v);
            }
        }
        if(v == (pos-1)){
            System.out.println("|End of Graph|");
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

    public void dfs() {
        vList[0].wasVisited = true;
        displayVertex(0);
        s.push(0);

        while(!s.isEmpty()) {
            int v = getUnvisitedVertex(s.peek());

            if(v == -1) {
                s.pop();
            } else {
                vList[v].wasVisited = true;
                displayVertex(v);
                s.push(v);
            }
        }
    }
}

public class DepthFirst {
    public static void main(String[] args) {
        char value;
        Graph g = new Graph();
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
                    g.dfs();
                    System.out.println();
                    break;

                default:
                   return;
            }
        }
    }
}