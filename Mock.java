import java.util.Arrays;
import java.util.Scanner;

class PrimAlgorithm {

    void Prim(int G[][], int V) {
        int LIMIT = 99;
        int no_edge;

        boolean[] selected = new boolean[V];

        Arrays.fill(selected, false);
        no_edge = 0;
        selected[0] = true;

        System.out.println(" PRIM'S ALGORITHM \n");
        System.out.println("--------------------------");
        System.out.println("  Edge \t\t |\t Weight");
        System.out.println("--------------------------");

        while (no_edge < V - 1) {
            int min = LIMIT;
            int x = 0; // source
            int y = 0; // destination

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        // not in selected and there is an edge
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

                System.out.println(" " + (x+1) + '0' + " - " + " " + (y+1) + '0' + "\t |\t" + " " + G[x][y]);

            selected[y] = true;
            no_edge++;
        }
        System.out.println("--------------------------");
    }
}


class KruskalAlgo {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    // Union
    class subset {
        int parent, rank;
    }

    int vertices, edges;
    Edge edge[];

    // Graph creation
    KruskalAlgo(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }


    void KruskalAlgo() {
        Edge result[] = new Edge[vertices];
        int e = 0;
        int i;
        for (i = 0; i < vertices; ++i)
            result[i] = new Edge();

        // Sorting the edges
        Arrays.sort(edge);
        subset subsets[] = new subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        System.out.println("--------------------");
        System.out.println("Edge \t| Weight");
        System.out.println("--------------------");
        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < vertices - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println((result[i].src+1)+"0" + " - " + (result[i].dest +1)+"0 "+ "| \t" + result[i].weight);
    }
}

public class Mock{
    public static void main(String[] args) {
        int V = 4;
        int edges = 5;
        int INF = 999;
        PrimAlgorithm pa = new PrimAlgorithm();
        KruskalAlgo ka = new KruskalAlgo(V, edges);

        int[][] G = { { 0, 3, INF , 1 }, { 3, 0, 4, 2 }, { INF, 4, 0,  6 }, { 1, 2, 6, 0 }};

        Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.println("Choose  1 for Prim's and 2 for Kruskal's");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        pa.Prim(G, V);
                        break;
                    case 2:
                        ka.edge[0].src = 0;
                        ka.edge[0].dest = 1;
                        ka.edge[0].weight = 3;

                        ka.edge[3].src = 0;
                        ka.edge[3].dest = 3;
                        ka.edge[3].weight = 1;

                        ka.edge[1].src = 1;
                        ka.edge[1].dest = 2;
                        ka.edge[1].weight = 4;

                        ka.edge[4].src = 1;
                        ka.edge[4].dest = 3;
                        ka.edge[4].weight = 2;

                        ka.edge[2].src = 2;
                        ka.edge[2].dest = 3;
                        ka.edge[2].weight = 6;

                        System.out.println("\n\nKRUSKAL ALGORITHM \n");

                        ka.KruskalAlgo();

                    default:
                        return;
                }
            }


    }
}