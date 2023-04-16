import java.util.*;

class Graph {
    private Map<String, Integer> vertexIndex;
    private List<String> vertices;
    private int[][] adjacencyMatrix;
    private Map<String, Set<String>> adjacencyList;

    public Graph() {
        this.vertexIndex = new HashMap<>();
        this.vertices = new ArrayList<>();
        this.adjacencyMatrix = new int[0][0];
        adjacencyList = new HashMap<>();

    }
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new HashSet<>());
    }
    public void addEdge(String node1, String node2) {
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print(node + " -> ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

