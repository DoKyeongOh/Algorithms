package org.example.baekjoon.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Boj2606 {

    static Map<String, List<String>> graph;

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
//        solution(br);
        solution2(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        int pc = Integer.parseInt(br.readLine());
        int lc = Integer.parseInt(br.readLine());
        graph = new HashMap<>();

        for (int i=0 ; i<lc ; i++) {
            String[] li = br.readLine().split(" ");
            if (!graph.containsKey(li[0]))
                graph.put(li[0], new ArrayList<>());
            if (!graph.containsKey(li[1]))
                graph.put(li[1], new ArrayList<>());

            graph.get(li[0]).add(li[1]);
            graph.get(li[1]).add(li[0]);
        }

        int count = dfs(new HashMap<>(), "1");
        System.out.println(count-1);

    }

    public static int dfs(Map<String, Boolean> map, String point){
        if (!map.containsKey(point)) {
            map.put(point, true);
        }
        for (String p : graph.get(point)) {
            if (!map.containsKey(p))
                dfs(map, p);
        }
        return map.keySet().size();
    }

    public static void solution2(BufferedReader br) throws IOException {
        int count = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());
        Map<String, Set<String>> map = new HashMap<>();
        for (int i=0 ; i<count ; i++)
            map.put("" + (i + 1), new HashSet<>());
        for (int i=0 ; i<lineCount ; i++) {
            String[] items = br.readLine().split(" ");
            map.get(items[0]).add(items[1]);
            map.get(items[1]).add(items[0]);
        }
        Set<String> resultSet = new HashSet<>();
        dfs2(map, resultSet, "1");
        System.out.println(resultSet.size()-1);
    }
    private static void dfs2(Map<String, Set<String>> map, Set<String> result, String now) {
        for (String item : map.get(now)) {
            if (result.contains(item))
                continue;
            result.add(item);
            dfs2(map, result, item);
        }
    }
}
