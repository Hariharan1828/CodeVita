import java.util.*;

class Graph1{
    private Map<String, List<String>>  adjacencyList;

    public Graph1(Map<String, List<String>> adjacencyList) {
        this.adjacencyList = adjacencyList;
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
public class BuildOrder11 {

}
