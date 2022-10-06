package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;


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
        int max = 0;

        String[][] pointArr = new String[row][col];
        for (int r=0 ; r<row ; r++) {
            input = br.readLine().split("");
            for (int c=0 ; c<col ; c++) {
                pointArr[r][c] = input[c];
                if (input[c].equals("1"))
                    max++;
            }
        }

        List<String> queueList = new ArrayList<>();
        queueList.add(getPoint(0,0));

        Map<String, Integer> vcMap = new HashMap<>();
        vcMap.put(getPoint(0,0), 1);

        int[] moving = {-1, 1};
        String dest = getPoint(row-1, col-1);
        for (int i=0 ; i<max ; i++) {

            if (i >= queueList.size()) {
                System.out.println(-1);
                break;
            }

            String[] point = queueList.get(i).split(",");
            int x = Integer.parseInt(point[0]);
            int y = Integer.parseInt(point[1]);

            for (int m : moving) {
                int nX = x + m;
                if (nX<0 || nX>=row)
                    continue;
                if (!pointArr[nX][y].equals("1"))
                    continue;
                if (vcMap.containsKey(getPoint(nX,y)))
                    continue;
                queueList.add(getPoint(nX,y));
                vcMap.put(getPoint(nX,y), vcMap.get(getPoint(x,y))+1);
            }

            for (int m : moving) {
                int nY = y + m;
                if (nY<0 || nY>=col)
                    continue;

                if (!pointArr[x][nY].equals("1"))
                    continue;
                if (vcMap.containsKey(getPoint(x,nY)))
                    continue;
                queueList.add(getPoint(x,nY));
                vcMap.put(getPoint(x,nY), vcMap.get(getPoint(x,y))+1);
            }

            if (vcMap.containsKey(dest)) {
                System.out.println(vcMap.get(dest));
                break;
            }
        }
        return;
    }

    public static String getPoint(int x, int y) {
        return x + "," + y;
    }

}
