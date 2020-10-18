import java.util.Arrays;

class PrimAlgorithm {

    public void Prim(int G[][], int V) {
        int LIMIT = 99;
        int no_edge;

        boolean[] selected = new boolean[V];

        Arrays.fill(selected, false);
        no_edge = 0;
        selected[0] = true;

        System.out.println(" PRIM'S ALGORITHM \n");
        System.out.println("--------------------");
        System.out.println("  Edge \t |\t Weight");
        System.out.println("--------------------");

        while (no_edge < V - 1) {
            int min = LIMIT;
            int x = 0; // row number
            int y = 0; // col number

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

            System.out.println(" "+x + " - " +" "+ y + "\t |\t" + " "+ G[x][y]);
            selected[y] = true;
            no_edge++;
        }
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        PrimAlgorithm g = new PrimAlgorithm();
        int V = 5;
        int[][] G = { { 0, 9, 75, 0, 0 }, { 9, 0, 95, 19, 42 }, { 75, 95, 0, 51, 66 }, { 0, 19, 51, 0, 31 },
                { 0, 42, 66, 31, 0 } };

        g.Prim(G, V);
    }
}