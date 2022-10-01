package org.example.kakao;

import java.util.HashMap;
import java.util.Map;

public class FindMinNumber {

    public static void main(String arg[]){
        int[] arr = {1,3,6,4,1,2};
        System.out.println(solution(arr));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int n : A) {
            if (!map.containsKey(n)) {
                map.put(n, true);
            }
        }

        for (int i=1 ; i<100000 ; i++) {
            if (map.containsKey(i)) {
                continue;
            }
            return i;
        }
        return 0;
    }
}
