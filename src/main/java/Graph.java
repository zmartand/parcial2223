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

    public void addVertex(String vertex) {
        if (!vertexIndex.containsKey(vertex)) {
            vertexIndex.put(vertex, vertices.size());
            vertices.add(vertex);

            int newSize = vertices.size();
            int[][] newMatrix = new int[newSize][newSize];
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                for (int j = 0; j < adjacencyMatrix.length; j++) {
                    newMatrix[i][j] = adjacencyMatrix[i][j];
                }
            }
            adjacencyMatrix = newMatrix;
        }
    }

    public void addEdge(String vertex1, String vertex2, int distance) {
        int index1 = vertexIndex.get(vertex1);
        int index2 = vertexIndex.get(vertex2);
        adjacencyMatrix[index1][index2] = distance;
        adjacencyMatrix[index2][index1] = distance;
    }

    public void depthFirstTraversal(String startVertex) {
        boolean[] visited = new boolean[vertices.size()];
        depthFirstTraversal(startVertex, visited);
    }

    private void depthFirstTraversal(String vertex, boolean[] visited) {
        int index = vertexIndex.get(vertex);
        if (!visited[index]) {
            visited[index] = true;
            System.out.println(vertex);
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[index][i] != 0) {
                    depthFirstTraversal(vertices.get(i), visited);
                }
            }
        }
    }

    public List<String> shortestPath(String startVertex, String endVertex) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (String vertex : vertices) {
            if (vertex.equals(startVertex)) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            queue.add(vertex);
        }

        while (!queue.isEmpty()) {
            String currentVertex = queue.poll();
            int currentIndex = vertexIndex.get(currentVertex);
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                int edgeDistance = adjacencyMatrix[currentIndex][i];
                if (edgeDistance != 0) {
                    String neighbor = vertices.get(i);
                    int newDistance = distances.get(currentVertex) + edgeDistance;
                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        previous.put(neighbor, currentVertex);
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        List<String> path = new ArrayList<>();
        String current = endVertex;
        while (!current.equals(startVertex)) {
            path.add(current);
            current = previous.get(current);
        }
        path.add(startVertex);
        Collections.reverse(path);
        return path;
    }

    public void removeHighestDegreeVertex() {
        int maxDegree = -1;
        String maxDegreeVertex = null;
        for (String vertex : vertices) {
            int degree = 0;
            int index = vertexIndex.get(vertex);
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[index][i] != 0) {
                    degree++;
                }
            }
            if (degree > maxDegree) {
                maxDegree = degree;
                maxDegreeVertex = vertex;
            }
        }

        if (maxDegreeVertex != null) {
            int indexToRemove = vertexIndex.get(maxDegreeVertex);
            vertexIndex.remove(maxDegreeVertex);
            vertices.remove(indexToRemove);

            int newSize = vertices.size();
            int[][] newMatrix = new int[newSize][newSize];
            for (int i = 0; i < newSize; i++) {
                for (int j = 0; j < newSize; j++) {
                    if (i < indexToRemove && j < indexToRemove) {
                        newMatrix[i][j] = adjacencyMatrix[i][j];
                    } else if (i < indexToRemove && j > indexToRemove) {
                        newMatrix[i][j] = adjacencyMatrix[i][j + 1];
                    } else if (i > indexToRemove && j < indexToRemove) {
                        newMatrix[i][j] = adjacencyMatrix[i + 1][j];
                    } else if (i > indexToRemove && j > indexToRemove) {
                        newMatrix[i][j] = adjacencyMatrix[i + 1][j + 1];
                    }
                }
            }
            adjacencyMatrix = newMatrix;
        }
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

