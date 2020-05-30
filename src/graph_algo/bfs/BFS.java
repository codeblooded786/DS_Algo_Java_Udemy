package graph_algo.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex vertex = queue.remove();
            System.out.println(vertex + " ");
            vertex.setVisited(true);

            for (Vertex vertex1 : vertex.getNeighbourList()) {

                if (!vertex1.isVisited()) {
                    vertex1.setVisited(true);
                    queue.add(vertex1);
                }
            }
        }
    }
}
