package level1;

import java.util.HashMap;
import java.util.Map;

public class NumberEnglishString {

    //숫자 문자열과 영단어
    //https://school.programmers.co.kr/learn/courses/30/lessons/81301
    public int solution(String s) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("ten", "10");

        String value = "";
        for (String key : map.keySet()) {
            value = map.get(key);
            if (s.contains(key)) {
                s = s.replaceAll(key, value);
            }
        }

        return Integer.parseInt(s);
    }
}
