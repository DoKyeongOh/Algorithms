package org.example.kakao;

import java.util.HashMap;
import java.util.Map;

public class TestReal {


    public static void main(String[] arg) {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";

        String answer = "";
        Map<String, Integer> nMap = new HashMap<>();
        String[] names = S.split(",");
        String[] emails = new String[names.length];
        for (int i=0 ; i< names.length ; i++) {
            String name = names[i].trim();

            String[] items = name.split(" ");
            String fi = items[0].split("")[0];
            String mi = "";
            String last = "";

            if (items.length > 2) {
                mi = items[1].split("")[0];
                last = items[2];
            } else {
                last = items[1];
            }

            String[] lastItem = last.split("-");
            last = "";
            for (String s : lastItem) {
                last = last + s;
            }
            if (last.length() >= 8) {
                last = last.substring(1,8);
            }

            String C = "example";
            emails[i] = fi.toLowerCase() + mi.toLowerCase() + last.toLowerCase();

            for (int n=0 ; n<=names.length ; n++) {
                if (nMap.containsKey(emails[i])) {
                    nMap.replace(emails[i], nMap.get(emails[i])+1);
                    emails[i] = emails[i] + nMap.get(emails[i]);
                } else {
                    nMap.put(emails[i], 1);
                    break;
                }
            }

            emails[i] = emails[i] + "@" + C.toLowerCase() + ".com";

            answer = answer + name + " <" + emails[i] + ">, ";
        }
        answer = answer.substring(0, answer.trim().length()-1);
        System.out.println(answer);



        String C = "example";

        return;
    }

}
