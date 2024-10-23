package GFG.Graph.NeetCode;

import java.util.*;

//https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructItinerary {
    public List <String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();

        // Step 1 - Create Graph - with sorted Nodes using Priority List
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph
                    .computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                    .add(ticket.get(1));
        }


        dfsRight(graph, "JFK", itinerary);
        return itinerary;
    }

    public void dfsRight(Map<String, PriorityQueue<String>> graph, String origin, LinkedList<String> itinerary){
        PriorityQueue<String> q = graph.getOrDefault(origin, new PriorityQueue<>());
        if(q == null || q.isEmpty()){
            itinerary.addFirst(origin);
            return;
        }
        while(!q.isEmpty()){
            String destination = q.remove();
            dfsRight(graph, destination, itinerary);
        }
        itinerary.addFirst(origin);
    }

    public static void main(String[] args) {
        // [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("MUC","LHR"));
        list.add(Arrays.asList("JFK","MUC"));
        list.add(Arrays.asList("SFO","SJC"));
        list.add(Arrays.asList("LHR","SFO"));

//        [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]
        List<List<String>> list2 = new ArrayList<>();
        list2.add(Arrays.asList("JFK","KUL"));
        list2.add(Arrays.asList("JFK","NRT"));
        list2.add(Arrays.asList("NRT","JFK"));

        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> result = reconstructItinerary.findItinerary(list);
        List<String> result2 = reconstructItinerary.findItinerary(list2);

        System.out.println("List 1 result");
        for(String dest: result) {
            System.out.print(dest  + "->");
        }

        System.out.println("List 2 result");
        for(String dest: result2) {
            System.out.print(dest + "->");
        }

    }
}
