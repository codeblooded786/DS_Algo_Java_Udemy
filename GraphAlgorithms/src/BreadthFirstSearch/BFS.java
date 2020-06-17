package BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 18/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */
public class BFS {

    public void bfs(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex actualVertex = queue.remove();

            System.out.println("Vertex visited: " + actualVertex);

            for (Vertex vertex : actualVertex.getNeighbourList()) {
                if (!vertex.isVisited()) {
                    vertex.setVisited(Boolean.TRUE);
                    queue.add(vertex);
                }
            }
        }
    }
}
