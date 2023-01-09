package org.example.programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 테이블_해시함수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}}, 2, 2, 3));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (t1, t2) -> t1[col-1]==t2[col-1] ? t2[0]-t1[0] : t1[col-1]-t2[col-1]);
        for (int i=row_begin-1 ; i<=row_end-1 ; i++) {
            int buf = 0;
            for (int n=0 ; n<data[i].length ; n++) {
                buf += data[i][n] % (i+1);
            }
            answer ^= buf;
        }
        return answer;
    }
}
