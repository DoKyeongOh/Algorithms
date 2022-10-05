package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Boj2178 {

    public static void main(String[] arg) throws Exception {
        File file = new File("src/main/resources/input");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        solution(br);
        return;
    }

    public static void solution(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int[][] modNums = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        String[][] map = new String[row][col];
        for (int i=0 ; i<row ; i++) {
            String[] roads = br.readLine().split("");
            for (int j=0 ; j<col ; j++)
                map[i][j] = roads[j];
        }

        int max = Arrays.stream(map)
                .mapToInt(arr -> (int) Arrays.stream(arr).filter(s -> s.equals("1")).count())
                .sum();

        Map<String, Integer> memory = new HashMap<>();
        memory.put(getPoint(0,0), 1);
        List<String> queueList = new ArrayList<>();
        queueList.add(getPoint(0,0));
        int count = 1;

        for (int i=0 ; i<max ; i++) {
            if (i >= queueList.size()) {
                System.out.println(-1);
                break;
            }

            String point = queueList.get(i);
            int x = Integer.parseInt(point.split(",")[0]);
            int y = Integer.parseInt(point.split(",")[1]);
            if (x == row-1 && y==col-1) {
                System.out.println(count);
                break;
            }

            for (int[] moving : modNums) {
                int newX = x + moving[0];
                int newY = y + moving[1];
                if (newX < 0 || newX > map.length-1)
                    continue;
                if (newY < 0 || newY > map[0].length-1)
                    continue;
                if (!map[newX][newY].equals("1"))
                    continue;
                if (memory.containsKey(getPoint(newX, newY)))
                    continue;
                count = memory.get(point) + 1;
                memory.put(getPoint(newX, newY), count);
                queueList.add(getPoint(newX, newY));
            }
        }
        return;
    }

    public static String getPoint(int x, int y) {
        return x + "," + y;
    }
}
