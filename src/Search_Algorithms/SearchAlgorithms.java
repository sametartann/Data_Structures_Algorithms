package Search_Algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SearchAlgorithms {
    // Linear Search
    public static int linearSearch(int[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key) {
                return i; // Return the index where the key is found
            }
        }
        return -1; // Return -1 if key is not found
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Return the index where the target is found
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Return -1 if target is not found
    }
    // Depth-First Search (DFS)
    public static boolean dfs(int[][] graph, int start, int target) {
        boolean[] visited = new boolean[graph.length];
        return dfsHelper(graph, start, target, visited);
    }

    private static boolean dfsHelper(int[][] graph, int node, int target, boolean[] visited) {
        if (node == target) {
            return true; // Target found
        }

        visited[node] = true;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                if (dfsHelper(graph, neighbor, target, visited)) {
                    return true; // Target found in one of the neighbors
                }
            }
        }

        return false; // Target not found
    }

    // Breadth-First Search (BFS)
    public static boolean bfs(int[][] graph, int start, int target) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == target) {
                return true; // Target found
            }

            visited[node] = true;

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }

        return false; // Target not found
    }


    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 5, 3};
        int target = 5;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        // Linear Search
        long startTime = System.nanoTime();
        int linearIndex = linearSearch(arr, target);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;
        System.out.println("Linear Search:");
        System.out.println("Index: " + linearIndex);
        System.out.println("Execution Time: " + linearTime + " ns"); // -3800 ns- in my computer

        // Binary Search
        Arrays.sort(arr); // Binary Search requires a sorted array
        startTime = System.nanoTime();
        int binaryIndex = binarySearch(arr, target);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;
        System.out.println("\nBinary Search:");
        System.out.println("Index: " + binaryIndex);
        System.out.println("Execution Time: " + binaryTime + " ns"); // -2700 ns- in my computer

        // Depth-First Search (DFS)
        int[][] graph = {
                {1, 2},     // Node 0 is connected to nodes 1 and 2
                {0, 3, 4},  // Node 1 is connected to nodes 0, 3, and 4
                {0, 5},     // Node 2 is connected to nodes 0 and 5
                {1},        // Node 3 is connected to node 1
                {1},        // Node 4 is connected to node 1
                {2, 6},     // Node 5 is connected to nodes 2 and 6
                {5}         // Node 6 is connected to node 5
        };
        startTime = System.nanoTime();
        boolean dfsResult = dfs(graph, 0, target);
        endTime = System.nanoTime();
        long dfsTime = endTime - startTime;
        System.out.println("\nDepth-First Search (DFS):");
        System.out.println("Result: " + dfsResult);
        System.out.println("Execution Time: " + dfsTime + " ns"); // -5200 ns- in my computer

        // Breadth-First Search (BFS)
        startTime = System.nanoTime();
        boolean bfsResult = bfs(graph, 0, target);
        endTime = System.nanoTime();
        long bfsTime = endTime - startTime;
        System.out.println("\nBreadth-First Search (BFS):");
        System.out.println("Result: " + bfsResult);
        System.out.println("Execution Time: " + bfsTime + " ns"); // -425300 ns- in my computer
    }
}
