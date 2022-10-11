package org.example.programmers.skillcheck;

import java.util.HashMap;
import java.util.Map;

public class Level2_1 {

    public static void main(String[] args) {
        int[] answer = solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        System.out.println(answer[0] + ", " + answer[1]);
    }

    public static int[] solution(int n, String[] words) {
        Map<String, Boolean> wordMap = new HashMap<>();
        wordMap.put(words[0], true);

        int idx = 0;
        for (int i=1 ; i<words.length ; i++) {
            String pre = words[i-1];
            String now = words[i];
            if (pre.charAt(pre.length()-1) != now.charAt(0)) {
                idx = i;
                break;
            }

            if (wordMap.containsKey(words[i])){
                idx = i;
                break;
            }
            wordMap.put(now, true);
        }

        int round = (int) idx / n + 1;
        int person = (idx+1) % n;
        if (person == 0)
            person = n;

        if (idx == 0) {
            person = 0;
            round = 0;
        }

        int[] answer = {person, round};

        return answer;
    }


}
