import java.util.*;

class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addProject(String project) {
        if (!adjacencyList.containsKey(project)) {
            adjacencyList.put(project, new ArrayList<>());
        }
    }

    public void addDependency(String from, String to) {
        adjacencyList.get(from).add(to);
    }

    public List<String> buildOrder() {
        List<String> buildOrder = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (String project : adjacencyList.keySet()) {
            if (!visited.contains(project)) {
                dfs(project, visited, buildOrder);
            }
        }

        return buildOrder;
    }

    private void dfs(String project, Set<String> visited, List<String> buildOrder) {
        visited.add(project);

        for (String dependency : adjacencyList.getOrDefault(project, new ArrayList<>())) {
            if (!visited.contains(dependency)) {
                dfs(dependency, visited, buildOrder);
            }
        }

        buildOrder.add(project);
    }
}

public class BuildOrder10 {
    public static List<String> findBuildOrder(List<String> projects, List<String[]> dependencies) {
        Graph graph = new Graph();

        for (String project : projects) {
            graph.addProject(project);
        }

        for (String[] dependency : dependencies) {
            graph.addDependency(dependency[0], dependency[1]);
        }

        List<String> buildOrder = graph.buildOrder();

        // Check for cycles
        if (buildOrder.size() != projects.size()) {
            return Collections.emptyList(); // Error: there is a cycle
        }

        // Reverse the order to get the correct build order
        Collections.reverse(buildOrder);
        return buildOrder;
    }

    public static void main(String[] args) {
        List<String> projects = Arrays.asList("a", "b", "c", "d", "e", "f");
        List<String[]> dependencies = Arrays.asList(
                new String[]{"a", "d"},
                new String[]{"f", "b"},
                new String[]{"b", "d"},
                new String[]{"f", "a"},
                new String[]{"d", "c"}
        );

        List<String> result = findBuildOrder(projects, dependencies);

        if (result.isEmpty()) {
            System.out.println("Error: There is a cycle in the dependencies.");
        } else {
            System.out.println("Build Order: " + result);
        }
    }
}
