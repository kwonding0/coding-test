package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {

    //[3차] 압축
    //https://school.programmers.co.kr/learn/courses/30/lessons/17684
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<String, Integer>() {{
            for (int i = 65; i <= 90; i++) { //대문자알파벳 기본으로 사전에 넣음
                put(String.valueOf((char) i), i - 64);
            }
        }};

        String[] split = msg.split("");
        String word = "";
        String nextWord = "";
        for (int j = 0; j < split.length; j++) {
            word += split[j];
            nextWord = j == split.length - 1 ? "" : split[j + 1];

            if (dictionary.containsKey(word + nextWord)) { //합친 단어가 사전에 있는지 확인
                if(j == split.length - 1){ //마지막글자면 단어값 answer에 추가
                    answer.add(dictionary.get(word));
                }
                continue;
            } else { //합친단어가 사전에 없으면 등록 및 합치기 전 단어값 answer에 추가
                dictionary.put(word + nextWord, dictionary.size() + 1);
                answer.add(dictionary.get(word));
                word = "";
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
