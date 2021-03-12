class Method {
    public void func(int[][] mat, int src) {
        int n = mat.length;
        int[] dis = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dis[i] = Integer.MAX_VALUE; //Infinity
            visited[i] = false;
        }
        dis[src] = 0;

        for (int i = 0; i < n; i++) {
            int vertex = minimumDist(dis, visited);

            if (vertex != Integer.MAX_VALUE) {
                visited[vertex] = true;
                for(int j=0; j<n; j++){
                    if(mat[vertex][j] > 0){
                        int newDist = dis[vertex] + mat[vertex][j];
                        dis[j] = Math.min(dis[j], newDist);
                    }
                }
            }
        }
        System.out.println("\t DIJKSTRA'S ALGORITHM");
        for(int i=0; i<n; i++){
            System.out.println("Source Vertex 0 to  " + i + ":\t Shortest Path = " + dis[i]);
        }
    }

    private static int minimumDist(int[] dis, boolean[] visited) {
        int d = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int i = 0; i < dis.length; i++) {
            if(!visited[i] && dis[i]<d){
                d = dis[i];
                j = i;
            }
        }
        return j;
    }
}


public class DijkstraCode {

        public static void main(String[] args) {
            int [][] matrix = new int[][]{
                    { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                    { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                    { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                    { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                    { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                    { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                    { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                    { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

            Method m = new Method();
            m.func(matrix, 0);
        }
}
