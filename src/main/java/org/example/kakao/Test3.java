package org.example.kakao;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

    public static void main(String[] arg) {
        int[] A = {7,4,-2,4,-2,-9};
        System.out.println(solution(A));
        return;
    }



    public static int solution(int[] A) {
        int max = 0;
        if (A.length == 1)
            return 1;

        for (int i=0 ; i<A.length-1 ; i++) {
            for (int k=i+1 ; k<A.length ; k++) {
                int len = getSlineLength(A, i, k);
                if (len == -1) {
                    continue;
                }
                if (max < len) {
                    max = len;
                }
            }
        }
        return max;
    }

    public static int getSlineLength(int[] arr, int sp, int ep) {
        int start = arr[sp];
        int next = arr[sp+1];

        for (int i=sp ; i<=ep ; i++) {
            if ((i-sp) % 2 == 0) {
                if (start != arr[i]) {
                    return -1;
                }
            } else {
                if (next != arr[i]) {
                    return -1;
                }
            }
        }
        return ep-sp+1;
    }

}
