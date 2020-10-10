package com.guru.learning;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {

    private final int SIZE;
    private final LinkedList[] adjcentNodes;

    public Graph(int size) {
        SIZE = size;
        adjcentNodes = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjcentNodes[i] = new LinkedList();
        }
    }

    public void addEdge(int edge, int value) {
        adjcentNodes[edge].add(value);
    }

    public void DFS() {
        boolean[] visited = new boolean[SIZE];
        for (int i = 0; i < SIZE; i++) {
            DFSUtil(i, visited);
        }
    }

    public void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.println(vertex);

        ListIterator iterator = adjcentNodes[vertex].listIterator();

        while (iterator.hasNext()) {
            int data = (int) iterator.next();
            if (!visited[data]) {
                DFSUtil(data, visited);
            }
        }
    }
}

