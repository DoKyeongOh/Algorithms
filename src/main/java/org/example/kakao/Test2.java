package org.example.kakao;

import java.util.HashMap;
import java.util.Map;

public class Test2 {

    public static void main(String[] arg) {
        int[] T = {0,0,1,1};
        int[] A = {2};
        System.out.println(solution(T, A));
        return;
    }

    static Map<Integer, Boolean> skillMap;
    public static int solution(int[] T, int[] A) {
        skillMap = new HashMap<>();
        for (int a : A) {
            entrySkill(T, a);
        }
        return skillMap.keySet().size();
    }

    public static void entrySkill(int[] T, int a) {
        if (!skillMap.containsKey(T[a])) {
            skillMap.put(T[a], true);
        }
        if (!skillMap.containsKey(a)) {
            skillMap.put(a, true);
        }

        if (T[a] == 0 || T[a] == a) {
            return;
        }

        entrySkill(T, T[a]);
    }

}
