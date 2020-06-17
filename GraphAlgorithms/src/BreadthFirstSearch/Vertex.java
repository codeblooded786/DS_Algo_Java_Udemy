package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 18/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */
public class Vertex {

    private int data;
    private boolean visited;
    private List<Vertex> neighbourList;

    public Vertex(int data) {
        this.data = data;
        neighbourList = new ArrayList<>();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<Vertex> neighbourList) {
        this.neighbourList = neighbourList;
    }

    public void addNeighbourVertex(Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return data == vertex.data &&
                visited == vertex.visited &&
                Objects.equals(neighbourList, vertex.neighbourList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, visited, neighbourList);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", visited=" + visited +
                ", neighbourList=" + neighbourList +
                '}';
    }
}
