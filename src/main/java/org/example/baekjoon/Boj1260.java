package org.example.baekjoon;

import java.io.*;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.*;

public class Boj1260 {

    static Map<Integer, List<Integer>> graph;

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] items = br.readLine().split(" ");
        int pointCount = Integer.parseInt(items[0]);
        int lineCount = Integer.parseInt(items[1]);
        int startPoint = Integer.parseInt(items[2]);

        graph = new HashMap<>();

        // 그래프 형태 만들기
        for (int i=0 ; i<lineCount ; i++) {
            items = br.readLine().split(" ");
            int p1 = Integer.parseInt(items[0]);
            int p2 = Integer.parseInt(items[1]);
            if (!graph.containsKey(p1))
                graph.put(p1, new ArrayList<>());
            if (!graph.containsKey(p2))
                graph.put(p2, new ArrayList<>());
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }

        for (int s : graph.keySet())
            Collections.sort(graph.get(s));

        List<Integer> dfsList = new ArrayList<>();
        dfsList.add(startPoint);
        List<Integer> bfsList = new ArrayList<>();
        bfsList.add(startPoint);

        List<Integer> bfs = bfsFunc(bfsList, 0);
        List<Integer> dfs = dfsFunc(dfsList);
        print(dfs); print(bfs);
    }

    public static List<Integer> dfsFunc(List<Integer> answer){
        int now = answer.get(answer.size()-1);
        if (!graph.containsKey(now))
            return answer;
        for (int s : graph.get(now)) {
            if (!answer.contains(s)) {
                answer.add(s);
                answer = dfsFunc(answer);
            }
        }
        return answer;
    }

    public static List<Integer> bfsFunc(List<Integer> answer, int idx){
        int now = answer.get(idx);
        if (!graph.containsKey(now))
            return answer;
        for (int s : graph.get(now)) {
            if (!answer.contains(s))
                answer.add(s);
        }

        if (idx < answer.size()-1) {
            idx++;
            answer = bfsFunc(answer, idx);
        }

        return answer;
    }

    public static void print(List<Integer> item){
        String value = "";
        for (int s : item)
            value = value + s + " ";

        value = value.substring(0, value.length()-1);
        System.out.println(value);
    }
}