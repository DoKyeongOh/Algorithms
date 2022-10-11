package org.example.programmers.skillcheck;

import java.util.*;

public class Level2_2 {
    public static void main(String[] args) {
        int[] answer = solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        Arrays.stream(answer).forEach(System.out::println);
    }

    public static int[] solution(String[][] places) {
        int roomCount = places.length;
        int[] answer = new int[roomCount];

        for (int i=0 ; i<roomCount ; i++) {
            int row = places.length;
            int col = places[0].length;
            String[][] coord = new String[row][col];

            for (int n=0 ; n<row ; n++)
                coord[n] = places[i][n].split("");

            answer[i] = 0;
            if (isCorrectSeat(coord))
                answer[i] = 1;
        }

        return answer;
    }

    public static boolean isCorrectSeat(String[][] coord) {
        Map<Integer, List<Integer>> pMap = new HashMap<>();
        for (int x=0 ; x<coord.length ; x++) {
            pMap.put(x, new ArrayList<>());
            for (int y=1 ; y<coord[0].length ; y++) {
                if (!coord[x][y].equals("P"))
                    continue;
                pMap.get(x).add(y);
            }
        }

        for (int x : pMap.keySet()) {
            for (int y : pMap.get(x)) {
                if (isExistPInMenDist(coord, x, y, 0))
                    return false;
            }
        }

        return true;
    }

    public static boolean isExistPInMenDist(String[][] coord, int x, int y, int count) {
        if (count > 1)
            return false;

        count++;
        int[] move = {-1, 1};
        for (int m : move) {
            if (y+m<0 || y+m>=coord[0].length)
                continue;
            if (coord[x][y+m].equals("P"))
                return true;
            if (coord[x][y+m].equals("X"))
                return false;
            if (count > 1)
                break;
            if (coord[x][y+m].equals("O"))
                return isExistPInMenDist(coord, x, y + m, count);
        }

        for (int m : move) {
            if (x+m<0 || x+m>coord.length)
                continue;
            if (coord[x+m][y].equals("P"))
                return true;
            if (coord[x+m][y].equals("X"))
                return false;
            if (count > 1)
                break;
            if (coord[x+m][y].equals("O"))
                return isExistPInMenDist(coord, x + m, y, count);
        }

        return false;
    }

}
